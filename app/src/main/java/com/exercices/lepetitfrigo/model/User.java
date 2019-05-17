package com.exercices.lepetitfrigo.model;

import java.util.Date;

public class User {

    private String name;
    private String email;
    private String password;
    private Date birthDate;


    public User(String name,String email, String password, Date birthDate) {
        this.name = name;
        this.email=email;
        this.password = password;
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}
