package com.vipera.empresaer.rest.validators;

import com.vipera.empresaer.core.exceptions.types.RestException;
import com.vipera.empresaer.rest.utils.LogUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;

public class StringValidator {

    private static final Logger LOGGER = LoggerFactory.getLogger(StringValidator.class);

    //private final String regexEmail =  "^[a-zA-Z0-9._]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
    private final String regexWeb =  "[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";

    private final String regexPhone =  "[0-9]{8,10}$";

    public  <T> String  validate(T string){

        LOGGER.info(LogUtils.restMarker, "REST -   StringValidator   - INPUT - validate - Validating");

        if(string == null){
            LOGGER.info(LogUtils.restMarker, "REST -   StringValidator   - OUTPUT - validate - Validated");
            return null;
        }

        if( !(string.getClass()==String.class))
            throw new RestException("12","Value must be string", HttpStatus.BAD_REQUEST);

        LOGGER.info(LogUtils.restMarker, "REST -   StringValidator   - OUTPUT - validate - Validated");

        return (String)string;
    }

//    public  <T> String  validateEmail(T string){
//
//        LOGGER.info(LogUtils.restMarker, "REST -   StringValidator   - INPUT - validateEmail - Validating");
//
//        if(string == null){
//            LOGGER.info(LogUtils.restMarker, "REST -   StringValidator   - OUTPUT - validateEmail - Validated");
//            return null;
//        }
//
//        String email = this.validate(string);
//
//        if(!email.matches(regexEmail)){
//            throw new RestException("13","Email doesn't match with the expected format", HttpStatus.BAD_REQUEST);
//        }
//
//        LOGGER.info(LogUtils.restMarker, "REST -   StringValidator   - OUTPUT - validateEmail - Validated");
//
//
//        return email;
//    }

    public  <T> String  validateWeb(T string){

        LOGGER.info(LogUtils.restMarker, "REST -   StringValidator   - INPUT - validateWeb - Validating");

        if(string == null){
            LOGGER.info(LogUtils.restMarker, "REST -   StringValidator   - OUTPUT - validateWeb - Validated");
            return null;
        }

        String web = this.validate(string);

        if(!web.matches(regexWeb)){
            throw new RestException("13","Web doesn't match with the expected format", HttpStatus.BAD_REQUEST);
        }

        LOGGER.info(LogUtils.restMarker, "REST -   StringValidator   - OUTPUT - validateWeb - Validated");

        return web;
    }

    public  <T> String  validatePhone(T string){

        LOGGER.info(LogUtils.restMarker, "REST -   StringValidator   - INPUT - validatePhone - Validating");

        if(string == null){
            LOGGER.info(LogUtils.restMarker, "REST -   StringValidator   - OUTPUT - validatePhone - Validated");
            return null;
        }

        String phone = this.validate(string);

        if(!phone.matches(regexPhone)){
            throw new RestException("13","Phone doesn't match with the expected format", HttpStatus.BAD_REQUEST);
        }

        LOGGER.info(LogUtils.restMarker, "REST -   StringValidator   - OUTPUT - validatePhone - Validated");

        return phone;
    }

}
