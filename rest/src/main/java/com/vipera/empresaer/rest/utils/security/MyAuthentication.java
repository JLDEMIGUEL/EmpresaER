package com.vipera.empresaer.rest.utils.security;

import com.vipera.empresaer.dao.models.User;
import com.vipera.empresaer.dao.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.ArrayList;
import java.util.Collection;


public class MyAuthentication extends UsernamePasswordAuthenticationToken{

    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Autowired
    private UserRepository repository;
    public MyAuthentication(Object principal, Object credentials) {
        super(principal, credentials, new ArrayList<>());
        user = repository.findByUsername((String)principal).orElse(null);
    }

    public MyAuthentication(Object principal, Object credentials, Collection<? extends GrantedAuthority> authorities) {
        super(principal, credentials, authorities);
    }
}
