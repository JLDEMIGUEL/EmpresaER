package com.vipera.empresaer.core.components.user;

import com.vipera.empresaer.core.exceptions.types.RestException;
import com.vipera.empresaer.core.utils.LogUtils;
import com.vipera.empresaer.dao.models.User;
import com.vipera.empresaer.dao.services.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserCoreImpl implements UserCore {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserCoreImpl.class);

    @Autowired
    private UserService service;

    @Override
    public User register(User user) {
        LOGGER.info(LogUtils.coreMarker, "CORE -   UserCoreImpl   - INPUT - register - Searching all");

        if(service.findUserByUsername(user.getUsername()).isPresent()){
            throw new RestException("20","Username already exists", HttpStatus.PRECONDITION_FAILED);
        }

        LOGGER.info(LogUtils.coreMarker, "CORE -   UserCoreImpl   - INPUT - register - Encoding password");
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));

        User saved = service.save(user);

        LOGGER.info(LogUtils.coreMarker, "CORE -   UserCoreImpl   - OUTPUT - register - Returning all");
        return saved;
    }
}
