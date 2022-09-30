package com.vipera.empresaer.rest.utils.security;

import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
@Primary
public class MyAuthenticationManager implements AuthenticationManager {
    private MyAuthentication myAuthentication;
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        Authentication auth = new MyAuthentication(authentication.getPrincipal(),authentication.getCredentials());
        //auth.setAuthenticated(true);
        return  auth;
    }
}
