package com.andrzejpe.spring.data;

import org.springframework.stereotype.Component;

/**
 * Created by jedrek on 2015-10-11.
 */

@Component
public class DataSourceSit implements DataSource {
    @Override
    public String getData() {
        return "SIT data";
    }
}
