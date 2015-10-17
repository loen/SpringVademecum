package com.andrzejpe.spring.web;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * Created by jedrek on 2015-10-17.
 */
public class HomeControllerTest {

    @Test
    public void mainPageIsWorking() throws Exception {
        HomeController home = new HomeController();
        MockMvc mockMvc = standaloneSetup(home).build();
        mockMvc.perform(get("/")).andExpect(view().name("home"));
    }

    @Test
    public void homePageIsWorking() throws Exception {
        HomeController home = new HomeController();
        MockMvc mockMvc = standaloneSetup(home).build();
        mockMvc.perform(get("/homepage")).andExpect(view().name("home"));
    }
}
