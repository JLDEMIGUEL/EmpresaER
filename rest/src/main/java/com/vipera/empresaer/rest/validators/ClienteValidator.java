package com.vipera.empresaer.rest.validators;

import com.vipera.empresaer.core.exceptions.types.RestException;
import com.vipera.empresaer.rest.requests.ClienteRequest;
import com.vipera.empresaer.rest.utils.logs.LogUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;

public class ClienteValidator {


    private static final Logger LOGGER = LoggerFactory.getLogger(ClienteValidator.class);


    public ClienteRequest validate(ClienteRequest cliente){

        LOGGER.info(LogUtils.restMarker, "REST -   ClienteValidator   - INPUT - validate - Validating");

        if(cliente == null){
            throw new RestException("14","cliente must be not null", HttpStatus.BAD_REQUEST);
        }

        if(cliente.getId() == null && (cliente.getNombre() != null && cliente.getDireccion() != null
                && cliente.getTelefono() != null)){
            new StringValidator().validate(cliente.getNombre());
            new StringValidator().validatePhone(cliente.getTelefono());
            //new DireccionValidator().validate(cliente.getDireccion());
        } else if (cliente.getId() != null && (cliente.getNombre() == null && cliente.getDireccion() == null
                && cliente.getTelefono() == null)) {
            new NumberValidator().validate(cliente.getId());
        }else{
            throw new RestException("14","cliente must have id xor other atributes", HttpStatus.BAD_REQUEST);
        }

        LOGGER.info(LogUtils.restMarker, "REST -   ClienteValidator   - OUTPUT - validate - Validated");

        return cliente;
    }

}
