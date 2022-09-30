package com.vipera.empresaer.rest.utils.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.vipera.empresaer.rest.utils.logs.LogUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;


public class JwtAuthorizationFilter extends BasicAuthenticationFilter {


    private static final Logger LOGGER = LoggerFactory.getLogger(JwtAuthorizationFilter.class);


    public JwtAuthorizationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }


    @Override
    protected void doFilterInternal(HttpServletRequest req,
                                    HttpServletResponse res,
                                    FilterChain chain) throws IOException, ServletException {

        LOGGER.info(LogUtils.restMarker, "REST -   JwtAuthorizationFilter  - doFilterInternal - Authorizing request");


        String header = req.getHeader("Authorization");

        if (header == null || !header.startsWith("Bearer ")) {
            chain.doFilter(req, res);
            return;
        }

        try{
            UsernamePasswordAuthenticationToken authentication = getAuthentication(req);

            SecurityContextHolder.getContext().setAuthentication(authentication);
            chain.doFilter(req, res);
        }catch (TokenExpiredException ex){

            LOGGER.error(LogUtils.restMarker, "REST -   JwtAuthorizationFilter  - doFilterInternal - Token expired");


            res.setStatus(HttpStatus.UNAUTHORIZED.value());
            res.getWriter().write("Token expired. Please, refresh your token");
            res.flushBuffer();
        }
    }


    // Reads the JWT from the Authorization header, and then uses JWT to validate the token
    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {
        String token = request.getHeader("Authorization");

        if (token != null) {
            // parse the token.
            String user = JWT.require(Algorithm.HMAC512("SECRET_KEY".getBytes()))
                    .build()
                    .verify(token.replace("Bearer ", ""))
                    .getSubject();

            if (user != null) {
                // new arraylist means authorities
                return new UsernamePasswordAuthenticationToken(user, null, new ArrayList<>());
            }

        }

        LOGGER.error(LogUtils.restMarker, "REST -   JwtAuthorizationFilter  - getAuthentication -  Unable to get Bearer Token Authorization");

        return null;
    }
}
