package com.vipera.empresaer.rest.converters.user;

import com.vipera.empresaer.dao.models.User;
import com.vipera.empresaer.rest.requests.AuthRequest;
import com.vipera.empresaer.rest.utils.logs.LogUtils;
import com.vipera.empresaer.rest.validators.AuthRequestValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;

public class AuthRequestToUserConverter implements Converter<AuthRequest, User> {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthRequestToUserConverter.class);

    @Override
    public User convert(AuthRequest source) {
        LOGGER.info(LogUtils.restMarker, "REST -   AuthRequestToUserConverter   - INPUT - convert - Converting");

        source= new AuthRequestValidator().validate(source);

        User user = new User();
        user.setUsername(source.getUsername());
        user.setPassword(source.getPassword());
        LOGGER.info(LogUtils.restMarker, "REST -   AuthRequestToUserConverter   - OUTPUT - convert - Converted");

        return user;
    }
}
