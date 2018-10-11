package com.example.hemant.myapplication.model;

public class UserBuilder {
    private int id;
    private String name;

    public UserBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public UserBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public User createUser() {
        return new User(id, name);
    }
}