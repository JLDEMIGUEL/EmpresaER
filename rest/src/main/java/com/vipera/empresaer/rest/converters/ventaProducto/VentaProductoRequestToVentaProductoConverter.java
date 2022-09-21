package com.vipera.empresaer.rest.converters.ventaProducto;

import com.vipera.empresaer.dao.models.VentaProducto;
import com.vipera.empresaer.rest.requests.VentaProductoRequest;
import com.vipera.empresaer.rest.utils.LogUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;

public class VentaProductoRequestToVentaProductoConverter implements Converter<VentaProductoRequest, VentaProducto> {

    private static final Logger LOGGER = LoggerFactory.getLogger(VentaProductoRequestToVentaProductoConverter.class);

    @Override
    public VentaProducto convert(VentaProductoRequest source) {

        LOGGER.info(LogUtils.restMarker, "REST -   VentaProductoRequestToVentaProductoConverter   - INPUT - convert - Converting");

        VentaProducto ventaProducto = new VentaProducto();
        ventaProducto.setId(source.getId());
        ventaProducto.setVenta(source.getVenta());
        ventaProducto.setProducto(source.getProducto());
        ventaProducto.setCantidad(source.getCantidad());
        ventaProducto.setPrecio(source.getPrecio());

        LOGGER.info(LogUtils.restMarker, "REST -   VentaProductoRequestToVentaProductoConverter   - OUTPUT - convert - Converted");



        return ventaProducto;
    }
}
