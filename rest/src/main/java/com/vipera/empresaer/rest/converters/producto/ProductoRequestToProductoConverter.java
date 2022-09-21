package com.vipera.empresaer.rest.converters.producto;

import com.vipera.empresaer.dao.models.Producto;
import com.vipera.empresaer.rest.requests.ProductoRequest;
import com.vipera.empresaer.rest.utils.LogUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;

public class ProductoRequestToProductoConverter implements Converter<ProductoRequest, Producto> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductoRequestToProductoConverter.class);

    @Override
    public Producto convert(ProductoRequest source) {

        LOGGER.info(LogUtils.restMarker, "REST -   ProductoRequestToProductoConverter   - INPUT - convert - Converting");

        Producto producto = new Producto();
        producto.setId(source.getId());
        producto.setNombre(source.getNombre());
        producto.setProveedor(source.getProveedor());
        producto.setCategoria(source.getCategoria());
        producto.setPrecio(source.getPrecio());
        producto.setStock(source.getStock());

        LOGGER.info(LogUtils.restMarker, "REST -   ProductoRequestToProductoConverter   - OUTPUT - convert - Converted");



        return producto;
    }
}
