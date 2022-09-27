package com.vipera.empresaer.rest.validators;

import com.vipera.empresaer.core.exceptions.types.RestException;
import com.vipera.empresaer.rest.requests.ProductoRequest;
import com.vipera.empresaer.rest.utils.logs.LogUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;

public class ProductoValidator {


    private static final Logger LOGGER = LoggerFactory.getLogger(ProductoValidator.class);


    public ProductoRequest validate(ProductoRequest producto){

        LOGGER.info(LogUtils.restMarker, "REST -   ProductoValidator   - INPUT - validate - Validating");

        if(producto == null){
            throw new RestException("14","producto must be not null", HttpStatus.BAD_REQUEST);
        }

        if(producto.getId() == null && (producto.getNombre() != null && producto.getCategoria() != null
                && producto.getProveedor() != null && producto.getStock() != null  && producto.getPrecio() != null)){
            new StringValidator().validate(producto.getNombre());
            //new CategoriaValidator().validate(producto.getCategoria());
            //new ProveedorValidator().validate(producto.getProveedor());
            new NumberValidator().validate(producto.getStock());
            new NumberValidator().validate(producto.getPrecio());
        } else if (producto.getId() != null && (producto.getNombre() == null && producto.getCategoria() == null
                && producto.getProveedor() == null && producto.getStock() == null  && producto.getPrecio() == null)) {
            new NumberValidator().validate(producto.getId());
        }else {
            throw new RestException("14","producto must have id xor other atributes", HttpStatus.BAD_REQUEST);
        }

        LOGGER.info(LogUtils.restMarker, "REST -   ProductoValidator   - OUTPUT - validate - Validated");

        return producto;
    }
}
