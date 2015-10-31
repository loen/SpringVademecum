package com.andrzejpe.spring.web;

import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.view.InternalResourceView;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * Created by jedrek on 2015-10-31.
 */

public class MultipartControllerTest {


  @Test
  public void shouldShowUserPage() throws Exception {
      MultipartController multipartController = new MultipartController();
      MockMvc mockMvc = standaloneSetup(multipartController)
              .setSingleView(new InternalResourceView("/WEB-INF/templates/multipart.html"))
              .build();
      mockMvc.perform(get("/multipart"))
              .andExpect(view().name("/multipart"))
              .andExpect(model().attributeExists("user"));
  }


}
