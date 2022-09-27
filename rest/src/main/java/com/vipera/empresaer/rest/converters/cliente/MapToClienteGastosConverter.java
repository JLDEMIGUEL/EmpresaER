package com.vipera.empresaer.rest.converters.cliente;

import com.vipera.empresaer.rest.responses.cliente.ClienteMediaGastosResponse;
import com.vipera.empresaer.rest.utils.logs.LogUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;

import java.util.Map;

public class MapToClienteGastosConverter implements Converter<Map<String,Object>, ClienteMediaGastosResponse> {

    private static final Logger LOGGER = LoggerFactory.getLogger(MapToClienteGastosConverter.class);

    @Override
    public ClienteMediaGastosResponse convert(Map<String, Object> source) {

        LOGGER.info(LogUtils.restMarker, "REST -   MapToClienteGastosConverter   - INPUT - convert - Converting");

        ClienteMediaGastosResponse response = new ClienteMediaGastosResponse();

        response.setNombre((String) source.get("nombre"));
        response.setMediaGastos((Double) source.get("MediaGastos"));

        LOGGER.info(LogUtils.restMarker, "REST -   MapToClienteGastosConverter   - OUTPUT - convert - Converted");


        return response;
    }
}
