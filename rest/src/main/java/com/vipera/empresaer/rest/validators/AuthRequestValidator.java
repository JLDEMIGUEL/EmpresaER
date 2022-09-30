package com.vipera.empresaer.rest.validators;

import com.vipera.empresaer.core.exceptions.types.RestException;
import com.vipera.empresaer.rest.requests.AuthRequest;
import com.vipera.empresaer.rest.utils.logs.LogUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;

public class AuthRequestValidator {


    private static final Logger LOGGER = LoggerFactory.getLogger(AuthRequestValidator.class);



    public AuthRequest validate(AuthRequest auth){

        LOGGER.info(LogUtils.restMarker, "REST -   AuthRequestValidator   - INPUT - validate - Validating");

        if(auth == null){
            throw new RestException("14","AuthRequest must be not null", HttpStatus.BAD_REQUEST);
        }

        if(auth.getUsername() != null && auth.getPassword() != null){
            StringValidator validator = new StringValidator();
            validator.validateAlphaNumeric(auth.getUsername());
            validator.validateAlphaNumeric(auth.getPassword());
        }else{
            throw new RestException("14","AuthRequest must have username and password", HttpStatus.BAD_REQUEST);
        }

        LOGGER.info(LogUtils.restMarker, "REST -   AuthRequestValidator   - OUTPUT - validate - Validated");

        return auth;
    }

}
