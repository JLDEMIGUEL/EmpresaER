package com.vipera.empresaer.rest.validators;

import com.vipera.empresaer.core.exceptions.types.RestException;
import com.vipera.empresaer.rest.requests.DireccionRequest;
import com.vipera.empresaer.rest.utils.LogUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;

public class DireccionValidator {
    private static final Logger LOGGER = LoggerFactory.getLogger(DireccionValidator.class);


    public DireccionRequest validate(DireccionRequest direccion){

        LOGGER.info(LogUtils.restMarker, "REST -   DireccionValidator   - INPUT - validate - Validating");

        if(direccion == null){
            throw new RestException("14","direccion must be not null", HttpStatus.BAD_REQUEST);
        }

        if(direccion.getId() == null && (direccion.getCalle() != null && direccion.getCiudad() != null
                && direccion.getComuna() != null && direccion.getNumero() != null)){
            new StringValidator().validate(direccion.getCalle());
            new StringValidator().validate(direccion.getCiudad());
            new StringValidator().validate(direccion.getComuna());
            new NumberValidator().validate(direccion.getNumero());
        } else if (direccion.getId() != null && (direccion.getCalle() == null && direccion.getCiudad() == null
                && direccion.getComuna() == null && direccion.getNumero() == null)) {
            new NumberValidator().validate(direccion.getId());
        }else {
            throw new RestException("14","direccion must have id xor other atributes", HttpStatus.BAD_REQUEST);
        }

        LOGGER.info(LogUtils.restMarker, "REST -   DireccionValidator   - OUTPUT - validate - Validated");

        return direccion;
    }
}
