package com.vipera.empresaer.rest.converters.venta;

import com.vipera.empresaer.dao.models.Venta;
import com.vipera.empresaer.rest.requests.VentaRequest;
import com.vipera.empresaer.rest.utils.LogUtils;
import com.vipera.empresaer.rest.validators.DateValidator;
import com.vipera.empresaer.rest.validators.NumberValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;

public class VentaRequestToVentaConverter implements Converter<VentaRequest, Venta> {

    private static final Logger LOGGER = LoggerFactory.getLogger(VentaRequestToVentaConverter.class);

    @Override
    public Venta convert(VentaRequest source) {

        LOGGER.info(LogUtils.restMarker, "REST -   VentaRequestToVentaConverter   - INPUT - convert - Converting");

        Venta venta = new Venta();
        venta.setId(new NumberValidator().validateLong(source.getId()));
        venta.setCliente(source.getCliente());
        venta.setDescuento(new NumberValidator().validateDouble(source.getDescuento()));
        venta.setFecha(new DateValidator().validateDate(source.getFecha()));
        venta.setPrecioFinal(new NumberValidator().validateDouble(source.getPrecioFinal()));

        LOGGER.info(LogUtils.restMarker, "REST -   VentaRequestToVentaConverter   - OUTPUT - convert - Converted");



        return venta;
    }
}
