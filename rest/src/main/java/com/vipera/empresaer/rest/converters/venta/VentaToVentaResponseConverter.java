package com.vipera.empresaer.rest.converters.venta;

import com.vipera.empresaer.dao.models.Venta;
import com.vipera.empresaer.rest.responses.venta.VentaResponse;
import com.vipera.empresaer.rest.utils.logs.LogUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;

public class VentaToVentaResponseConverter implements Converter<Venta, VentaResponse> {

    private static final Logger LOGGER = LoggerFactory.getLogger(VentaToVentaResponseConverter.class);

    @Override
    public VentaResponse convert(Venta source) {

        LOGGER.info(LogUtils.restMarker, "REST -   VentaToVentaResponseConverter   - INPUT - convert - Converting");

        VentaResponse ventaResponse = new VentaResponse();
        ventaResponse.setCliente(source.getCliente());
        ventaResponse.setId(source.getId());
        ventaResponse.setDescuento(source.getDescuento());
        ventaResponse.setFecha(source.getFecha());
        ventaResponse.setPrecioFinal(source.getPrecioFinal());

        LOGGER.info(LogUtils.restMarker, "REST -   VentaToVentaResponseConverter   - OUTPUT - convert - Converted");



        return ventaResponse;
    }
}
