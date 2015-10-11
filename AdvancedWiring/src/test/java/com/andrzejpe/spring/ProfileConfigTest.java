package com.andrzejpe.spring;

import com.andrzejpe.spring.config.ProfileConfig;
import com.andrzejpe.spring.data.DataSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ProfileConfig.class)
@ActiveProfiles(profiles = "dev")
public class ProfileConfigTest {

    @Inject
    private DataSource ds;

    @Test
    public void dataSourceShouldBeDevType() {
        assertEquals("DEV data", ds.getData());
    }

}
