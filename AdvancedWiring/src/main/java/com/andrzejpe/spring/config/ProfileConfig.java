package com.andrzejpe.spring.config;


import com.andrzejpe.spring.conditional.ConditionalExample;
import com.andrzejpe.spring.conditional.EnvCondition;
import com.andrzejpe.spring.data.DataSource;
import com.andrzejpe.spring.data.DataSourceDev;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * Created by jedrek on 2015-10-11.
 */
@Configuration
@Profile("dev")
public class ProfileConfig {

   @Bean
    public DataSource getDataSource() {
       return new DataSourceDev();
   }

   @Bean
   @Conditional(EnvCondition.class)
   public ConditionalExample getConditionalExample(){
        return new ConditionalExample();
   }

}

