package com.vipera.empresaer.rest.converters.proveedor;

import com.vipera.empresaer.rest.responses.proveedor.ProveedorIngresosResponse;
import com.vipera.empresaer.rest.utils.logs.LogUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;

import java.util.Map;

public class MapToProveedorIngresosConverter implements Converter<Map<String,Object>, ProveedorIngresosResponse> {

    private static final Logger LOGGER = LoggerFactory.getLogger(MapToProveedorIngresosConverter.class);

    @Override
    public ProveedorIngresosResponse convert(Map<String, Object> source) {

        LOGGER.info(LogUtils.restMarker, "REST -   MapToProveedorIngresosConverter   - INPUT - convert - Converting");

        ProveedorIngresosResponse response = new ProveedorIngresosResponse();

        response.setNombre((String) source.get("Nombre Proveedor"));
        response.setIngresos((Double) source.get("Ingresos"));

        LOGGER.info(LogUtils.restMarker, "REST -   MapToProveedorIngresosConverter   - OUTPUT - convert - Converted");


        return response;
    }
}
