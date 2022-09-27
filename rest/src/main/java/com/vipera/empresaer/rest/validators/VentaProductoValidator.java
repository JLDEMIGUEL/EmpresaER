package com.vipera.empresaer.rest.validators;

import com.vipera.empresaer.core.exceptions.types.RestException;
import com.vipera.empresaer.rest.requests.VentaProductoRequest;
import com.vipera.empresaer.rest.utils.logs.LogUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;

public class VentaProductoValidator {



    private static final Logger LOGGER = LoggerFactory.getLogger(VentaProductoValidator.class);


    public VentaProductoRequest validate(VentaProductoRequest ventaProducto){

        LOGGER.info(LogUtils.restMarker, "REST -   VentaProductoValidator   - INPUT - validate - Validating");

        if(ventaProducto == null){
            throw new RestException("14","ventaProducto must be not null", HttpStatus.BAD_REQUEST);
        }

        if(ventaProducto.getId() == null && (ventaProducto.getVenta() != null && ventaProducto.getProducto() != null
                && ventaProducto.getCantidad() != null && ventaProducto.getPrecio() != null)){
            //new VentaValidator().validate(ventaProducto.getVenta());
            //new ProductoValidator().validate(ventaProducto.getProducto());
            new NumberValidator().validate(ventaProducto.getCantidad());
            new NumberValidator().validate(ventaProducto.getPrecio());
        } else if (ventaProducto.getId() != null && (ventaProducto.getVenta() == null && ventaProducto.getProducto() == null
                && ventaProducto.getCantidad() == null && ventaProducto.getPrecio() == null)) {
            new NumberValidator().validate(ventaProducto.getId());
        }else {
            throw new RestException("14","ventaProducto must have id xor other atributes", HttpStatus.BAD_REQUEST);
        }

        LOGGER.info(LogUtils.restMarker, "REST -   VentaProductoValidator   - OUTPUT - validate - Validated");

        return ventaProducto;
    }

}
