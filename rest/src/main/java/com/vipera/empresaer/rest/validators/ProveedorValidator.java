package com.vipera.empresaer.rest.validators;

import com.vipera.empresaer.core.exceptions.types.RestException;
import com.vipera.empresaer.rest.requests.ProveedorRequest;
import com.vipera.empresaer.rest.utils.LogUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;

public class ProveedorValidator {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProveedorValidator.class);


    public ProveedorRequest validate(ProveedorRequest proveedor){

        LOGGER.info(LogUtils.restMarker, "REST -   ProveedorValidator   - INPUT - validate - Validating");

        if(proveedor == null){
            throw new RestException("14","proveedor must be not null", HttpStatus.BAD_REQUEST);
        }

        if(proveedor.getId() == null && (proveedor.getNombre() != null && proveedor.getDireccion() != null
                && proveedor.getWeb() != null && proveedor.getTelefono() != null)){
            new StringValidator().validate(proveedor.getNombre());
            //new DireccionValidator().validate(proveedor.getDireccion());
            new StringValidator().validateWeb(proveedor.getWeb());
            new StringValidator().validatePhone(proveedor.getTelefono());
        } else if (proveedor.getId() != null && (proveedor.getNombre() == null && proveedor.getDireccion() == null
                && proveedor.getWeb() == null && proveedor.getTelefono() == null)) {
            new NumberValidator().validate(proveedor.getId());
        }else{
            throw new RestException("14","proveedor must have id xor other atributes", HttpStatus.BAD_REQUEST);
        }

        LOGGER.info(LogUtils.restMarker, "REST -   ProveedorValidator   - OUTPUT - validate - Validated");

        return proveedor;
    }
}
