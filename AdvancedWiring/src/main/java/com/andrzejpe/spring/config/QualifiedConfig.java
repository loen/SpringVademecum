package com.andrzejpe.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by jedrek on 2015-10-11.
 */
@Configuration
@ComponentScan(basePackages = "com.andrzejpe.spring.qualified")
public class QualifiedConfig {

}
