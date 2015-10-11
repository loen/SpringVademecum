package com.andrzejpe.spring.config;

import com.andrzejpe.spring.data.DataSource;
import com.andrzejpe.spring.data.DataSourceDev;
import com.andrzejpe.spring.data.DataSourceSit;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * Created by jedrek on 2015-10-11.
 */
@Configuration
public class MultiProfilesInOneConfigConfig {

    @Bean
    @Profile("dev")
    public DataSource getDevDataSource(){
        return new DataSourceDev();
    }

    @Bean
    @Profile("sit")
    public DataSource getSitDataSource(){
        return new DataSourceSit();
    }
}
