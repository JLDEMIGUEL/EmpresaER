package com.vipera.empresaer.rest.converters.producto;

import com.vipera.empresaer.dao.models.Producto;
import com.vipera.empresaer.rest.converters.categoria.CategoriaRequestToCategoriaConverter;
import com.vipera.empresaer.rest.converters.proveedor.ProveedorRequestToProveedorConverter;
import com.vipera.empresaer.rest.requests.ProductoRequest;
import com.vipera.empresaer.rest.utils.logs.LogUtils;
import com.vipera.empresaer.rest.validators.ProductoValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;

public class ProductoRequestToProductoConverter implements Converter<ProductoRequest, Producto> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductoRequestToProductoConverter.class);

    @Override
    public Producto convert(ProductoRequest source) {

        LOGGER.info(LogUtils.restMarker, "REST -   ProductoRequestToProductoConverter   - INPUT - convert - Converting");

        source = new ProductoValidator().validate(source);

        Producto producto = new Producto();

        if(source.getId() != null){
            producto.setId(source.getId());
        }else{
            producto.setNombre(source.getNombre());
            producto.setProveedor(new ProveedorRequestToProveedorConverter().convert(source.getProveedor()));
            producto.setCategoria(new CategoriaRequestToCategoriaConverter().convert(source.getCategoria()));
            producto.setPrecio(source.getPrecio());
            producto.setStock(source.getStock());
        }


        LOGGER.info(LogUtils.restMarker, "REST -   ProductoRequestToProductoConverter   - OUTPUT - convert - Converted");

        return producto;
    }
}
