package com.vipera.empresaer.rest.converters.user;


import com.vipera.empresaer.dao.models.User;
import com.vipera.empresaer.rest.responses.user.UserResponse;
import com.vipera.empresaer.rest.utils.logs.LogUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;

public class UserToUserResponseConverter implements Converter<User, UserResponse> {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserToUserResponseConverter.class);


    @Override
    public UserResponse convert(User source) {
        LOGGER.info(LogUtils.restMarker, "REST -   UserToUserResponseConverter   - INPUT - convert - Converting");

        UserResponse response = new UserResponse();
        response.setUsername(source.getUsername());

        LOGGER.info(LogUtils.restMarker, "REST -   UserToUserResponseConverter   - OUTPUT - convert - Converted");
        return response;
    }
}
