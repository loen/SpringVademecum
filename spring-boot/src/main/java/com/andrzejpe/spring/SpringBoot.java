package com.andrzejpe.spring;

import com.andrzejpe.spring.model.User;
import com.andrzejpe.spring.model.persistent.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@EnableAutoConfiguration
public class SpringBoot implements CommandLineRunner {

    @Autowired
    UserRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        repository.deleteAll();
        User a = new User();
        a.setName("Andrzej");
        a.setAge("33");
        repository.save(a);

        User b = new User();
        b.setName("Beata");
        b.setAge("32");
        repository.save(b);

        System.out.println("Customers found with findAll():");
        System.out.println("-------------------------------");
        for ( User user : repository.findAll()) {
            System.out.println(user);
        }
    }
}
