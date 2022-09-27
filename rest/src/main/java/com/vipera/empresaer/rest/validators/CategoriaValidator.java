package com.vipera.empresaer.rest.validators;

import com.vipera.empresaer.core.exceptions.types.RestException;
import com.vipera.empresaer.rest.requests.CategoriaRequest;
import com.vipera.empresaer.rest.utils.logs.LogUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;

public class CategoriaValidator {


    private static final Logger LOGGER = LoggerFactory.getLogger(CategoriaValidator.class);


    public CategoriaRequest validate(CategoriaRequest categoria){

        LOGGER.info(LogUtils.restMarker, "REST -   CategoriaValidator   - INPUT - validate - Validating");

        if(categoria == null){
            throw new RestException("14","Categoria must be not null", HttpStatus.BAD_REQUEST);
        }

        if(categoria.getId() == null && (categoria.getNombre() != null && categoria.getDescripcion() != null)){
            StringValidator validator = new StringValidator();
            validator.validate(categoria.getNombre());
            validator.validate(categoria.getDescripcion());
        } else if (categoria.getId() != null && (categoria.getNombre() == null && categoria.getDescripcion() == null)) {
            new NumberValidator().validate(categoria.getId());
        }else{
            throw new RestException("14","Categoria must have id xor other atributes", HttpStatus.BAD_REQUEST);
        }

        LOGGER.info(LogUtils.restMarker, "REST -   CategoriaValidator   - OUTPUT - validate - Validated");

        return categoria;
    }

}
