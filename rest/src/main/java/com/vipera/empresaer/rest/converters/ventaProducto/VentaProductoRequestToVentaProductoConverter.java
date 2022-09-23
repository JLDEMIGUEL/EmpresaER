package com.vipera.empresaer.rest.converters.ventaProducto;

import com.vipera.empresaer.dao.models.VentaProducto;
import com.vipera.empresaer.rest.converters.producto.ProductoRequestToProductoConverter;
import com.vipera.empresaer.rest.converters.venta.VentaRequestToVentaConverter;
import com.vipera.empresaer.rest.requests.VentaProductoRequest;
import com.vipera.empresaer.rest.utils.LogUtils;
import com.vipera.empresaer.rest.validators.VentaProductoValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;

public class VentaProductoRequestToVentaProductoConverter implements Converter<VentaProductoRequest, VentaProducto> {

    private static final Logger LOGGER = LoggerFactory.getLogger(VentaProductoRequestToVentaProductoConverter.class);

    @Override
    public VentaProducto convert(VentaProductoRequest source) {

        LOGGER.info(LogUtils.restMarker, "REST -   VentaProductoRequestToVentaProductoConverter   - INPUT - convert - Converting");

        source = new VentaProductoValidator().validate(source);

        VentaProducto ventaProducto = new VentaProducto();
        if(source.getId() != null){
            ventaProducto.setId(source.getId());
        }else {
            ventaProducto.setVenta(new VentaRequestToVentaConverter().convert(source.getVenta()));
            ventaProducto.setProducto(new ProductoRequestToProductoConverter().convert(source.getProducto()));
            ventaProducto.setCantidad(source.getCantidad());
            ventaProducto.setPrecio(source.getPrecio());
        }

        LOGGER.info(LogUtils.restMarker, "REST -   VentaProductoRequestToVentaProductoConverter   - OUTPUT - convert - Converted");

        return ventaProducto;
    }
}
