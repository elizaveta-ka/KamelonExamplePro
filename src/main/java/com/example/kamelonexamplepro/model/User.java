package com.example.kamelonexamplepro.model;


import jakarta.persistence.*;

@Entity
@Table(name = "Users")
public class User {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private int Id;

    @Column(name = "user_name")
    private String name;

    @Column(name = "user_login")
    private String login;

    @Column(name = "user_password")
    private String password;

    public User() {
    }

    public User(int id, String name, String login, String password) {
        Id = id;
        this.name = name;
        this.login = login;
        this.password = password;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
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
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
