package com.vipera.empresaer.rest.validators;

import com.vipera.empresaer.core.exceptions.types.RestException;
import com.vipera.empresaer.rest.utils.LogUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;

public class NumberValidator {

    private static final Logger LOGGER = LoggerFactory.getLogger(NumberValidator.class);


    public <T> Long validateLong(T number){

        LOGGER.info(LogUtils.restMarker, "REST -   NumberValidator   - INPUT - validateLong - Validating");

        if(number == null){
            LOGGER.info(LogUtils.restMarker, "REST -   NumberValidator   - OUTPUT - validateLong - Validated");
            return null;
        }

        if(number.getClass() != Long.class){
            throw new RestException("10","Id must be Long", HttpStatus.BAD_REQUEST);
        }

        LOGGER.info(LogUtils.restMarker, "REST -   NumberValidator   - OUTPUT - validateLong - Validated");

        return (Long) number;
    }

    public <T> Double validateDouble(T number){

        LOGGER.info(LogUtils.restMarker, "REST -   NumberValidator   - INPUT - validateDouble - Validating");

        if(number == null){
            LOGGER.info(LogUtils.restMarker, "REST -   NumberValidator   - OUTPUT - validateDouble - Validated");
            return null;
        }

        if(number.getClass() != Double.class){
            throw new RestException("10","Value must be Double", HttpStatus.BAD_REQUEST);
        }

        LOGGER.info(LogUtils.restMarker, "REST -   NumberValidator   - OUTPUT - validateDouble - Validated");

        return (Double) number;
    }

    public <T> Integer validateInteger(T number){

        LOGGER.info(LogUtils.restMarker, "REST -   NumberValidator   - INPUT - validateInteger - Validating");

        if(number == null){
            LOGGER.info(LogUtils.restMarker, "REST -   NumberValidator   - OUTPUT - validateInteger - Validated");
            return null;
        }

        if(number.getClass() != Integer.class){
            throw new RestException("10","Id must be Integer", HttpStatus.BAD_REQUEST);
        }

        LOGGER.info(LogUtils.restMarker, "REST -   NumberValidator   - OUTPUT - validateInteger - Validated");

        return (Integer) number;
    }

    public <T> T validate(T number) {
        LOGGER.info(LogUtils.restMarker, "REST -   NumberValidator   - INPUT - validate - Validating");

        if(number == null){
            LOGGER.info(LogUtils.restMarker, "REST -   NumberValidator   - OUTPUT - validate - Validated");
            return null;
        }

        if(number.getClass() == Integer.class && (Integer)number<0){
            throw new RestException("10","Must be a positive value", HttpStatus.BAD_REQUEST);
        }else if(number.getClass() == Double.class && (Double)number<0){
            throw new RestException("10","Must be a positive value", HttpStatus.BAD_REQUEST);
        }else if(number.getClass() == Long.class && (Long)number<0){
            throw new RestException("10","Must be a positive value", HttpStatus.BAD_REQUEST);
        }

        LOGGER.info(LogUtils.restMarker, "REST -   NumberValidator   - OUTPUT - validate - Validated");

        return number;
    }
}
