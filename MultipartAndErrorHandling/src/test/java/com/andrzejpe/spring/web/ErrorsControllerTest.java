package com.andrzejpe.spring.web;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * Created by jedrek on 2015-10-31.
 */
public class ErrorsControllerTest {

    @Test
    public void shouldGetErrors() throws Exception {
        ErrorsController errorsController = new ErrorsController();
        MockMvc mockMvc = standaloneSetup(errorsController).build();
        mockMvc.perform(get("/errors")).andExpect(status().isBadGateway());
    }

    @Test
    public void shouldGetNotKnow() throws Exception {
        ErrorsController errorsController = new ErrorsController();
        MockMvc mockMvc = standaloneSetup(errorsController).build();
        mockMvc.perform(get("/notknow"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("name"))
                .andExpect(model().attributeExists("message"));
    }
}
