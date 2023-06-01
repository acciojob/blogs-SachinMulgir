package com.driver.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public
class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "user_name",unique = true, nullable = false)
    String username;

    @Column(name = "password", nullable = false)
    String password;

    String firstName;

    String lastName;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    List<Blog> blogList = new ArrayList<>();

    public User() {
        this.firstName = "test";
        this.lastName = "test";
    }

    public User(String username, String password, String firstName, String lastName) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public List<Blog> getBlogList() {
        return blogList;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setBlogList(List<Blog> blogList) {
        this.blogList = blogList;
    }
}