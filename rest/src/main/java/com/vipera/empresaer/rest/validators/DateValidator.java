package com.vipera.empresaer.rest.validators;

import com.vipera.empresaer.core.exceptions.types.RestException;
import com.vipera.empresaer.rest.utils.LogUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateValidator {

    private static final Logger LOGGER = LoggerFactory.getLogger(DateValidator.class);

    public <T> Date validateDate(T date) {
        LOGGER.info(LogUtils.restMarker, "REST -   DateValidator   - INPUT - validateDate - Validating");

        if(date == null){
            LOGGER.info(LogUtils.restMarker, "REST -   DateValidator   - OUTPUT - validateDate - Validated");
            return null;
        }

        DateFormat format = new SimpleDateFormat("dd-MM-yyyy");

        Date retDate;
        try {
            retDate = format.parse(date.toString());
        } catch (ParseException e) {
            throw new RestException("11", "Unable to parse Date", HttpStatus.BAD_REQUEST);
        }

        LOGGER.info(LogUtils.restMarker, "REST -   DateValidator   - OUTPUT - validateDate - Validated");

        return retDate;
    }
}
