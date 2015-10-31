package com.andrzejpe.spring.dao;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by jedrek on 2015-10-31.
 */
public class User {
    @NotNull
    @Size(min = 3, max = 10)
    private String name;
    @NotNull
    @Size(min = 8, max = 15)
    private String password;

    public User(){}

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
