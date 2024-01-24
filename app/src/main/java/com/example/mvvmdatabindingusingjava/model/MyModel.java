package com.example.mvvmdatabindingusingjava.model;

public class MyModel {

    private final String name;
    private final String email;
    private final String website;

    public MyModel(String name, String email, String website) {
        this.name = name;
        this.email = email;
        this.website = website;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getWebsite() {
        return website;
    }
}