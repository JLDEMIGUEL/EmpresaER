package com.vipera.empresaer.rest.validators;

import com.vipera.empresaer.core.exceptions.types.RestException;
import com.vipera.empresaer.rest.utils.logs.LogUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;

public class StringValidator {

    private static final Logger LOGGER = LoggerFactory.getLogger(StringValidator.class);

    //private final String regexEmail =  "^[a-zA-Z0-9._]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";

    private final String regexBasic =  "[a-zA-Z\\s]{0,20}$";
    private final String regexAlphaNumeric =  "[a-zA-Z0-9\\s]{0,20}$";
    private final String regexWeb =  "www.[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
    private final String regexPhone =  "[0-9]{8,10}$";

    public  <T> String  validate(T value){

        LOGGER.info(LogUtils.restMarker, "REST -   StringValidator   - INPUT - validate - Validating");

        if(value == null){
            throw new RestException("14","Value must be not null", HttpStatus.BAD_REQUEST);
        }

        if( !(value.getClass()==String.class))
            throw new RestException("12","Value must be string", HttpStatus.BAD_REQUEST);

        String string = (String) value;

        if(!string.matches(regexBasic)){
            throw new RestException("13","Value doesn't match with the expected format", HttpStatus.BAD_REQUEST);
        }

        LOGGER.info(LogUtils.restMarker, "REST -   StringValidator   - OUTPUT - validate - Validated");

        return string;
    }



    public  <T> String  validateAlphaNumeric(T value){

        LOGGER.info(LogUtils.restMarker, "REST -   StringValidator   - INPUT - validateAlphaNumeric - Validating");

        if(value == null){
            throw new RestException("14","Value must be not null", HttpStatus.BAD_REQUEST);
        }

        if( !(value.getClass()==String.class))
            throw new RestException("12","Value must be string", HttpStatus.BAD_REQUEST);

        String string = (String) value;

        if(!string.matches(regexAlphaNumeric)){
            throw new RestException("13","Value doesn't match with the expected format", HttpStatus.BAD_REQUEST);
        }

        LOGGER.info(LogUtils.restMarker, "REST -   StringValidator   - OUTPUT - validateAlphaNumeric - Validated");

        return string;
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
            throw new RestException("14","Value must be not null", HttpStatus.BAD_REQUEST);
        }

        String web = (String) string;

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
        String phone = (String) string;

        if(!phone.matches(regexPhone)){
            throw new RestException("13","Phone doesn't match with the expected format", HttpStatus.BAD_REQUEST);
        }

        LOGGER.info(LogUtils.restMarker, "REST -   StringValidator   - OUTPUT - validatePhone - Validated");

        return phone;
    }

}
