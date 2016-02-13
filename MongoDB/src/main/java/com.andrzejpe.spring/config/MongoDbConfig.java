package com.andrzejpe.spring.config;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

/**
 * Created by jedrek on 2016-02-11.
 */
@Configuration
public class MongoDbConfig extends AbstractMongoConfiguration {
    @Override
    protected String getDatabaseName() {
        return "orders";
    }

    @Override
    public Mongo mongo() throws Exception {
        return new MongoClient("127.0.0.1", 27017);
    }
}
