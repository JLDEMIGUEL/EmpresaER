package com.vipera.empresaer.rest.controllers;

import com.vipera.empresaer.core.components.user.UserCore;
import com.vipera.empresaer.dao.models.User;
import com.vipera.empresaer.rest.converters.user.AuthRequestToUserConverter;
import com.vipera.empresaer.rest.converters.user.UserToUserResponseConverter;
import com.vipera.empresaer.rest.requests.AuthRequest;
import com.vipera.empresaer.rest.utils.logs.LogUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "api/public")
public class AuthController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthController.class);


    @Autowired
    private UserCore core;

    @PostMapping("register")
    public ResponseEntity register(@RequestBody AuthRequest request) {
        LOGGER.info(LogUtils.restMarker, "REST -   AuthController   - INPUT - register - Registering user");

        User user = new AuthRequestToUserConverter().convert(request);

        User saved = core.register(user);



        LOGGER.info(LogUtils.restMarker, "REST -   AuthController   - INPUT - register - User registered");
        return new ResponseEntity(new UserToUserResponseConverter().convert(saved),HttpStatus.OK);
    }
}
