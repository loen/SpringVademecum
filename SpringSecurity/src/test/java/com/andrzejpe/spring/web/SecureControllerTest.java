package com.andrzejpe.spring.web;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

public class SecureControllerTest {

    @Test
    public void shouldReturnHelloPage() throws Exception {
        SecureController secureController = new SecureController();
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(secureController).build();
        mockMvc.perform(get("/secure"))
                .andExpect(status().isOk())
                .andExpect(view().name("secureLayout"));
    }
}
