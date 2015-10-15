package com.andrzejpe.spring.config;

import com.andrzejpe.spring.aspect.Audience;
import com.andrzejpe.spring.concert.Performance;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created by jedrek on 2015-10-15.
 */
@Configuration
@EnableAspectJAutoProxy
public class AopConfig {

    @Bean
    public Audience getAudience(){
        return new Audience();
    }

    @Bean
    public Performance getPerformance(){
        return new Performance();
    }
}
