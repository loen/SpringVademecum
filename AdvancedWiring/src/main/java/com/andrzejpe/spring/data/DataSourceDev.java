package com.andrzejpe.spring.data;

import org.springframework.stereotype.Component;

/**
 * Created by jedrek on 2015-10-11.
 */
@Component
public class DataSourceDev implements DataSource {
    @Override
    public String getData() {
        return "DEV data";
    }
}
