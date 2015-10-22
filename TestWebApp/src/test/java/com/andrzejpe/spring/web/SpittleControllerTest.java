package com.andrzejpe.spring.web;

import com.andrzejpe.spring.data.Spittle;
import com.andrzejpe.spring.data.SpittleRepository;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalTime;
import java.util.Random;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

/**
 * Created by jedrek on 2015-10-22.
 */
public class SpittleControllerTest {

    private SpittleRepository spittleRepository;
    private Spittle spittle;
    private long id = 44;

    @Before
    public void init() {
        Random r = new Random();
        spittle = new Spittle(id, "Spittle for id " + id, LocalTime.now(), r.nextDouble(), r.nextDouble());
        spittleRepository = mock(SpittleRepository.class);
        when(spittleRepository.getSpittle(id)).thenReturn(spittle);
    }

    @Test
    public void shouldReturnSingleSpittle() throws Exception {
        SpittleController spittleController = new SpittleController(spittleRepository);
        MockMvc mvc = standaloneSetup(spittleController).build();
        mvc.perform(get("/spittle/" + id))
                .andExpect(view().name("spittle"))
                .andExpect(model().attributeExists("spittle"))
                .andExpect(model().attribute("spittle", is(spittle)));
    }
}
