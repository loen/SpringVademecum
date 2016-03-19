package com.andrzejpe.spring;

import com.andrzejpe.spring.web.UIController;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class UIControllerTest {

    @Test
    public void shouldReturnUI() throws Exception {
        UIController uiController = new UIController();
        MockMvc mockMvc = standaloneSetup(uiController).build();
        mockMvc.perform(get("/")).andExpect(view().name("main"))
        .andExpect(status().isOk());
    }
}
