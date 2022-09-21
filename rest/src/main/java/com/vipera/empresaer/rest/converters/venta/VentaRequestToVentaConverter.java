package com.vipera.empresaer.rest.converters.venta;

import com.vipera.empresaer.dao.models.Venta;
import com.vipera.empresaer.rest.requests.VentaRequest;
import com.vipera.empresaer.rest.utils.LogUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;

public class VentaRequestToVentaConverter implements Converter<VentaRequest, Venta> {

    private static final Logger LOGGER = LoggerFactory.getLogger(VentaRequestToVentaConverter.class);

    @Override
    public Venta convert(VentaRequest source) {

        LOGGER.info(LogUtils.restMarker, "REST -   VentaRequestToVentaConverter   - INPUT - convert - Converting");

        Venta venta = new Venta();
        venta.setCliente(source.getCliente());
        venta.setId(source.getId());
        venta.setDescuento(source.getDescuento());
        venta.setFecha(source.getFecha());
        venta.setPrecioFinal(source.getPrecioFinal());

        LOGGER.info(LogUtils.restMarker, "REST -   VentaRequestToVentaConverter   - OUTPUT - convert - Converted");



        return venta;
    }
}
