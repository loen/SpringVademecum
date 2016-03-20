package com.andrzejpe.spring;

import com.andrzejpe.spring.dao.ErrorMessage;
import com.andrzejpe.spring.dao.User;
import com.andrzejpe.spring.web.Users;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasProperty;
import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class UsersTest {

    @Test
    public void shouldPerformGetUsers() throws Exception {
        Users users = new Users();
        MockMvc mockMvc = standaloneSetup(users).build();
        MvcResult mvcResult = mockMvc.perform(get("/users"))
                .andExpect(status().isOk())
                .andDo(print()).andReturn();

        String content = mvcResult.getResponse().getContentAsString();
        ObjectMapper objectMapper = new ObjectMapper();
        List<User> userList = objectMapper.readValue(content,
                objectMapper.getTypeFactory().constructCollectionType(List.class, User.class));
        assertEquals(3, userList.size());
        assertThat(userList, hasItem(hasProperty("name", equalTo("Beatka"))));
        assertThat(userList, hasItem(hasProperty("name", equalTo("Jedrek"))));
        assertThat(userList, hasItem(hasProperty("name", equalTo("Mateusz"))));
    }

    @Test
    public void shouldCreateNewUser() throws Exception {
        ObjectMapper o = new ObjectMapper();
        User u = new User();
        u.setName("Pusia");
        u.setAge(44);
        Users users = new Users();
        MockMvc mockMvc = standaloneSetup(users).build();
        MvcResult result = mockMvc.perform(post("/users")
                .content(o.writeValueAsString(u))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();
        String contentAsString = result.getResponse().getContentAsString();
        User returnedUser = o.readValue(contentAsString, User.class);
        assertEquals(u.getName(),returnedUser.getName());
        assertEquals(u.getAge(), returnedUser.getAge());
    }

    @Test
    public void itsNotAplaceForJaroslaw() throws Exception {
        ObjectMapper o = new ObjectMapper();
        User u = new User();
        u.setName("Jaroslaw");
        u.setAge(64);
        MockMvc mockMvc = standaloneSetup(new Users()).build();
        MvcResult result = mockMvc.perform(post("/users")
                .content(o.writeValueAsString(u))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isForbidden())
                .andDo(print())
                .andReturn();
        String contentAsString = result.getResponse().getContentAsString();
        ErrorMessage message = o.readValue(contentAsString, ErrorMessage.class);
        assertEquals("Tego pana nie obslugujemy", message.getError());
        assertEquals("Jaroslaw", message.getUser());

    }
}
