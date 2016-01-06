package com.andrzejpe.spring;

import com.andrzejpe.spring.web.UsersController;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * Created by jedrek on 2016-01-06.
 */
public class UsersControllerTest {

    @Test
    public void usersControllerIsWorking() throws Exception {
        UsersController users = new UsersController();
        MockMvc mockMvc = standaloneSetup(users).build();
        mockMvc.perform(get("/")).andExpect(view().name("users"));
    }
}
