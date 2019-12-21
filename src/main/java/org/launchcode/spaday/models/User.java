package org.launchcode.spaday.models;

import java.util.Date;

public class User {

    private int id;
    private String username;
    private String email;
    private String password;
    private Date whenCreated;
    private static int nextId = 1;

    public User(String username, String email, String password) {
        this.id = nextId;
        this.username = username;
        this.email = email;
        this.password = password;
        this.whenCreated = new Date();
        nextId++;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getWhenCreated() {
        return whenCreated;
    }
}
