package com.andrzejpe.spring.service;

import com.andrzejpe.spring.dao.model.User;
import com.andrzejpe.spring.dao.model.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * Created by jedrek on 2016-01-06.
 */
@Component
public class UsersService {

    private UserRepo userRepo;

    @Autowired
    public UsersService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public Collection<User> getUsers(){
        return userRepo.getAllUsers();
    }

    public User saveUser(String firstName, String lastName){
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        userRepo.createUser(user);
        return user;
    }
}
