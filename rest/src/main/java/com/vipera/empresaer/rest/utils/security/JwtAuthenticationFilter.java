package com.vipera.empresaer.rest.utils.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vipera.empresaer.dao.models.User;
import com.vipera.empresaer.dao.services.security.UserDetailsImpl;
import com.vipera.empresaer.rest.utils.logs.LogUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {


    private static final Logger LOGGER = LoggerFactory.getLogger(JwtAuthenticationFilter.class);

    private AuthenticationManager authenticationManager;

    public JwtAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;

        setFilterProcessesUrl("/api/public/login");
    }


    @Override
    public Authentication attemptAuthentication(HttpServletRequest req,
                                                HttpServletResponse res) throws AuthenticationException {

        LOGGER.info(LogUtils.restMarker, "REST -   JwtAuthenticationFilter   - INPUT - attemptAuthentication - Attempting authentication");

        try {

            User creds = new ObjectMapper()
                    .readValue(req.getInputStream(), User.class);

            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            creds.getUsername(),
                            creds.getPassword(),
                            new ArrayList<>())
            );

            LOGGER.info(LogUtils.restMarker, "REST -   JwtAuthenticationFilter   - OUTPUT - attemptAuthentication - Authenticated");

            return authentication;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest req,
                                            HttpServletResponse res,
                                            FilterChain chain,
                                            Authentication auth) throws IOException {
        LOGGER.info(LogUtils.restMarker, "REST -   JwtAuthenticationFilter   - INPUT - successfulAuthentication - Generating token");


        String token = JWT.create()
                .withSubject(((UserDetailsImpl) auth.getPrincipal()).getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() + 10000))
                .sign(Algorithm.HMAC512("SECRET_KEY".getBytes()));

        String body = ((UserDetailsImpl) auth.getPrincipal()).getUsername() + " " + token;


        res.getWriter().write(body);

        LOGGER.info(LogUtils.restMarker, "REST -   JwtAuthenticationFilter   - OUTPUT - successfulAuthentication - Returning token");

        res.getWriter().flush();
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest req,
                                              HttpServletResponse res,
                                              AuthenticationException failed) throws IOException, ServletException {
        LOGGER.error(LogUtils.restMarker, "REST -   JwtAuthenticationFilter   - unsuccessfulAuthentication - Error while authenticating user");
        super.unsuccessfulAuthentication(req,res,failed);
    }


}
