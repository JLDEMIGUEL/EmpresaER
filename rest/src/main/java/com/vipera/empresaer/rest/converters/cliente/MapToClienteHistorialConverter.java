package com.vipera.empresaer.rest.converters.cliente;

import com.vipera.empresaer.rest.responses.cliente.ClienteHistorialResponse;
import com.vipera.empresaer.rest.utils.logs.LogUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;

import java.util.Date;
import java.util.Map;

public class MapToClienteHistorialConverter implements Converter<Map<String,Object>, ClienteHistorialResponse> {

    private static final Logger LOGGER = LoggerFactory.getLogger(MapToClienteHistorialConverter.class);

    @Override
    public ClienteHistorialResponse convert(Map<String, Object> source) {

        LOGGER.info(LogUtils.restMarker, "REST -   MapToClienteHistorialConverter   - INPUT - convert - Converting");

        ClienteHistorialResponse historial = new ClienteHistorialResponse();

        historial.setNombre((String) source.get("nombre"));
        historial.setCantidad((Integer) source.get("cantidad"));
        historial.setPrecio((Double) source.get("precio"));
        historial.setFecha((Date) source.get("fecha"));

        LOGGER.info(LogUtils.restMarker, "REST -   MapToClienteHistorialConverter   - OUTPUT - convert - Converted");



        return historial;
    }
}
