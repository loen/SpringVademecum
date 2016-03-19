package com.andrzejpe.spring.dao;

public class ErrorMessage {

    private String error;
    private String user;


    public ErrorMessage(){}

    public ErrorMessage(String error, String user) {
        this.error = error;
        this.user = user;
    }

    public void setError(String error) {
        this.error = error;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getError() {
        return error;
    }

    public String getUser() {
        return user;
    }
}
