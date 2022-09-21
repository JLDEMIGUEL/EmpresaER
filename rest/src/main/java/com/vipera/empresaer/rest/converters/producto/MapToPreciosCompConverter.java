package com.vipera.empresaer.rest.converters.producto;

import com.vipera.empresaer.rest.responses.producto.ProductoPreciosCompResponse;
import com.vipera.empresaer.rest.utils.LogUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;

import java.util.Map;

public class MapToPreciosCompConverter implements Converter<Map<String,Object>, ProductoPreciosCompResponse> {

    private static final Logger LOGGER = LoggerFactory.getLogger(MapToPreciosCompConverter.class);

    @Override
    public ProductoPreciosCompResponse convert(Map<String, Object> source) {

        LOGGER.info(LogUtils.restMarker, "REST -   MapToPreciosCompConverter   - INPUT - convert - Converting");

        ProductoPreciosCompResponse response = new ProductoPreciosCompResponse();

        response.setPrecioActual((Double) source.get("PrecioActual"));
        response.setPrecioCompra((Double) source.get("PrecioCompra"));
        response.setNombre((String) source.get("Nombre"));
        response.setCategoria((String) source.get("Categoria"));
        response.setStock((Integer) source.get("Stock"));
        response.setCantidad((Integer) source.get("Cantidad"));

        LOGGER.info(LogUtils.restMarker, "REST -   MapToPreciosCompConverter   - OUTPUT - convert - Converted");

        return response;
    }
}
