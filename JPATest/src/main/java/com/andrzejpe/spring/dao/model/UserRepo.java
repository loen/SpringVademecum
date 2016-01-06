package com.andrzejpe.spring.dao.model;

import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

/**
 * Created by jedrek on 2016-01-06.
 */
public interface UserRepo {

    public Collection<User> getAllUsers();

    @Transactional
    public void createUser(User u);
}
