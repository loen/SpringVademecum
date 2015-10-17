package com.andrzejpe.spring.web;

import com.andrzejpe.spring.data.Spittle;
import com.andrzejpe.spring.data.SpittleRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceView;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static org.hamcrest.Matchers.*;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

/**
 * Created by jedrek on 2015-10-17.
 */
public class SpittleControllerTest {

    private SpittleRepository spittleRepository;
    private List<Spittle> spittles;

    @Before
    public void init() {
        spittles = createSpitlleList(20);
        spittleRepository = mock(SpittleRepository.class);
        when(spittleRepository.findSpittles(anyLong(), eq(20))).thenReturn(spittles);
    }

    @Test
    public void shouldShowRecentSpittles() throws Exception {
        SpittleController sp = new SpittleController(spittleRepository);
        MockMvc mockMvc = standaloneSetup(sp)
                .setSingleView(new InternalResourceView("/WEB-INF/views/spittles.jsp"))
                .build();
        mockMvc.perform(get("/spittles"))
                .andExpect(view().name("spittles"))
                .andExpect(model().attributeExists("spittleList"))
                .andExpect(model().attribute("spittleList", hasItems(spittles.toArray())));

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
