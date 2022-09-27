package com.vipera.empresaer.rest.validators;

import com.vipera.empresaer.core.exceptions.types.RestException;
import com.vipera.empresaer.rest.requests.VentaRequest;
import com.vipera.empresaer.rest.utils.logs.LogUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;

public class VentaValidator {

    private static final Logger LOGGER = LoggerFactory.getLogger(VentaValidator.class);


    public VentaRequest validate(VentaRequest venta){

        LOGGER.info(LogUtils.restMarker, "REST -   VentaValidator   - INPUT - validate - Validating");

        if(venta == null){
            throw new RestException("14","venta must be not null", HttpStatus.BAD_REQUEST);
        }

        if(venta.getId() == null && (venta.getCliente() != null && venta.getFecha() != null
                && venta.getDescuento() != null)){
            //new ClienteValidator().validate(venta.getCliente());
            //new DateValidator().validateDate(venta.getFecha());//validated in ventaconverter
            new NumberValidator().validate(venta.getDescuento());
        } else if (venta.getId() != null && (venta.getCliente() == null && venta.getFecha() == null
                && venta.getDescuento() == null)) {
            new NumberValidator().validate(venta.getId());
        }else {
            throw new RestException("14","venta must have id xor other atributes", HttpStatus.BAD_REQUEST);
        }

        LOGGER.info(LogUtils.restMarker, "REST -   VentaValidator   - OUTPUT - validate - Validated");

        return venta;
    }
}
