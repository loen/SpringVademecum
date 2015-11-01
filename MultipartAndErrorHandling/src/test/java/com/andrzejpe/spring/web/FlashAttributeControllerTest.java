package com.andrzejpe.spring.web;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * Created by jedrek on 2015-11-01.
 */
public class FlashAttributeControllerTest {

    @Test
    public void shouldNotPassAttributes() throws Exception {
        FlashAttributeController flashAttributeController = new FlashAttributeController();
        MockMvc mockMvc = standaloneSetup(flashAttributeController).build();
        mockMvc.perform(get("/noflash"))
                .andExpect(redirectedUrl("/user/nouser"))
                .andExpect(model().attributeDoesNotExist("panLam"));
    }

    @Test
    public void shouldRedirectByUrl() throws Exception {
        FlashAttributeController flashAttributeController = new FlashAttributeController();
        MockMvc mockMvc = standaloneSetup(flashAttributeController).build();
        mockMvc.perform(get("/redUrl"))
                .andExpect(redirectedUrl("/user/urlUser?pasloUrl=pasloUrl"))
                .andExpect(model().attribute("pasloUrl", is("pasloUrl")));
    }

    @Test
    public void shouldUserFlashAttributes() throws Exception {
        FlashAttributeController flashAttributeController = new FlashAttributeController();
        MockMvc mockMvc = standaloneSetup(flashAttributeController).build();
        mockMvc.perform(get("/flashatt"))
                .andExpect(redirectedUrl("/user/flashUser"))
                .andExpect(flash().attributeExists("flashUser"));
    }
}
