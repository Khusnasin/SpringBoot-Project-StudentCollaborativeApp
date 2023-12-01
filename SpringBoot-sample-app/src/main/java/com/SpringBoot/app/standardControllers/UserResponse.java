package com.SpringBoot.app.standardControllers;

public class UserResponse {

    private String name;
    private Long id;

    public UserResponse(String name, Long id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public Long getId() {
        return id;
    }
    /*public String getPassword() {
        return password;
    }*/

}