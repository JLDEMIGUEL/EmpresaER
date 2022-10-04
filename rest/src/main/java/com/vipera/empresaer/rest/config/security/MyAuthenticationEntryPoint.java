package com.vipera.empresaer.rest.config.security;

import com.vipera.empresaer.rest.utils.logs.LogUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class MyAuthenticationEntryPoint implements AuthenticationEntryPoint {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationEntryPoint.class);

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        LOGGER.info(LogUtils.restMarker, "REST -   AuthenticationEntryPoint   - INPUT - commence - USERNAME NOT FOUND OR WRONG PASSWORD - Sending response");

        response.getWriter().write("{ \"error\": \"USERNAME NOT FOUND OR WRONG PASSWORD\"}");
        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-16");
        response.flushBuffer();

        LOGGER.info(LogUtils.restMarker, "REST -   AuthenticationEntryPoint   - OUTPUT - commence - USERNAME NOT FOUND OR WRONG PASSWORD - Response sent");

    }
}
