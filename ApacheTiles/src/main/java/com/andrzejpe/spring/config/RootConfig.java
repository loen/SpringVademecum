package com.andrzejpe.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by jedrek on 2015-10-24.
 */
@Configuration
@ComponentScan(basePackages = "com.andrzejpe.spring",
        excludeFilters ={ @ComponentScan.Filter (type = FilterType.ANNOTATION, value = EnableWebMvc.class)})
public class RootConfig {
}
