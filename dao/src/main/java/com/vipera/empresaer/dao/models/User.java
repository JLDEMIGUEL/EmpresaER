package com.vipera.empresaer.dao.models;

import javax.persistence.Column;
import javax.persistence.Entity;


@Entity
public class User extends BaseEntity{


    @Column
    private String username;
    @Column
    private String password;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
