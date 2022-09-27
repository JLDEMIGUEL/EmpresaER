package com.vipera.empresaer.rest.converters.venta;

import com.vipera.empresaer.dao.models.Venta;
import com.vipera.empresaer.rest.converters.cliente.ClienteRequestToClienteConverter;
import com.vipera.empresaer.rest.requests.VentaRequest;
import com.vipera.empresaer.rest.utils.logs.LogUtils;
import com.vipera.empresaer.rest.validators.DateValidator;
import com.vipera.empresaer.rest.validators.VentaValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;

public class VentaRequestToVentaConverter implements Converter<VentaRequest, Venta> {

    private static final Logger LOGGER = LoggerFactory.getLogger(VentaRequestToVentaConverter.class);

    @Override
    public Venta convert(VentaRequest source) {

        LOGGER.info(LogUtils.restMarker, "REST -   VentaRequestToVentaConverter   - INPUT - convert - Converting");

        source = new VentaValidator().validate(source);

        Venta venta = new Venta();
        if(source.getId() != null){
            venta.setId(source.getId());
        }else {
            venta.setCliente(new ClienteRequestToClienteConverter().convert(source.getCliente()));
            venta.setDescuento(source.getDescuento());
            venta.setFecha(new DateValidator().validateDate(source.getFecha()));
        }

        LOGGER.info(LogUtils.restMarker, "REST -   VentaRequestToVentaConverter   - OUTPUT - convert - Converted");

        return venta;
    }
}
