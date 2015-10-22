package com.andrzejpe.spring.web;

import com.andrzejpe.spring.data.Spittle;
import com.andrzejpe.spring.data.SpittleRepository;
import com.andrzejpe.spring.data.User;
import com.andrzejpe.spring.data.UserRegistration;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.view.InternalResourceView;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.hamcrest.Matchers.hasItems;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * Created by jedrek on 2015-10-17.
 */
public class SpittlesControllerTest {

    private SpittleRepository spittleRepository;
    private List<Spittle> spittles;
    private UserRegistration userRegistration;
    private User user;

    @Before
    public void init() {
        spittles = createSpitlleList(20);
        userRegistration = new UserRegistration("Jack", "Black", "jblack", "paslo");
        user = new User(44, "Jack", "Black", "jblack", "paslo");
        spittleRepository = mock(SpittleRepository.class);
        when(spittleRepository.findSpittles(100l, 20)).thenReturn(spittles);
        when(spittleRepository.save(userRegistration)).thenReturn(user);
    }

    @Test
    public void shouldShowRecentSpittles() throws Exception {
        SpittlesController sp = new SpittlesController(spittleRepository);
        MockMvc mockMvc = standaloneSetup(sp)
                .setSingleView(new InternalResourceView("/WEB-INF/views/spittles.jsp"))
                .build();
        mockMvc.perform(get("/spittles?max=100&count=20"))
                .andExpect(view().name("spittles"))
                .andExpect(model().attributeExists("spittleList"))
                .andExpect(model().attribute("spittleList", hasItems(spittles.toArray())));

    }

    @Test
    public void shouldShowRegistrationForm() throws Exception {
        SpittlesController sp = new SpittlesController(spittleRepository);
        MockMvc mockMvc = standaloneSetup(sp).build();
        mockMvc.perform(get("/spittles/register"))
                .andExpect(view().name("registrationForm"));
    }

    @Test
    public void shouldRegister() throws Exception {
        SpittlesController sp = new SpittlesController(spittleRepository);
        MockMvc mockMvc = standaloneSetup(sp).build();
        mockMvc.perform(post("/spittles/register")
                .param("firstName", "Jack")
                .param("lastName", "Black")
                .param("username", "jblack")
                .param("password", "paslo"))
                .andExpect(redirectedUrl("/spittles/jblack"));
        verify(spittleRepository, atLeastOnce()).save(userRegistration);
    }

    private List<Spittle> createSpitlleList(int spitlleSize) {
        List<Spittle> spittles = new ArrayList<>();
        LocalTime now = LocalTime.now();
        Random r = new Random();
        for (int i = 0; i < spitlleSize; i++) {
            Spittle spittle = new Spittle(i, String.format("Spittle No.%d", i), now.minusMinutes(i),
                    r.nextDouble(), r.nextDouble());
            spittles.add(spittle);
        }
        return spittles;
    }
}
