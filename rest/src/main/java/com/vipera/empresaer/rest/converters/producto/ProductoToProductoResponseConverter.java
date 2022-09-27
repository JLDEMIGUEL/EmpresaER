package com.vipera.empresaer.rest.converters.producto;

import com.vipera.empresaer.dao.models.Producto;
import com.vipera.empresaer.rest.responses.producto.ProductoResponse;
import com.vipera.empresaer.rest.utils.logs.LogUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;

public class ProductoToProductoResponseConverter implements Converter<Producto, ProductoResponse> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductoToProductoResponseConverter.class);

    @Override
    public ProductoResponse convert(Producto source) {

        LOGGER.info(LogUtils.restMarker, "REST -   ProductoToProductoResponseConverter   - INPUT - convert - Converting");

        ProductoResponse productoResponse = new ProductoResponse();
        productoResponse.setId(source.getId());
        productoResponse.setNombre(source.getNombre());
        productoResponse.setProveedor(source.getProveedor());
        productoResponse.setCategoria(source.getCategoria());
        productoResponse.setPrecio(source.getPrecio());
        productoResponse.setStock(source.getStock());

        LOGGER.info(LogUtils.restMarker, "REST -   ProductoToProductoResponseConverter   - OUTPUT - convert - Converted");



        return productoResponse;
    }
}
