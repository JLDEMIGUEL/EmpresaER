package com.vipera.empresaer.rest.converters.ventaProducto;

import com.vipera.empresaer.dao.models.VentaProducto;
import com.vipera.empresaer.rest.responses.ventaproducto.VentaProductoResponse;
import com.vipera.empresaer.rest.utils.LogUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;

public class VentaProductoToVentaProductoResponseConverter implements Converter<VentaProducto, VentaProductoResponse> {

    private static final Logger LOGGER = LoggerFactory.getLogger(VentaProductoToVentaProductoResponseConverter.class);

    @Override
    public VentaProductoResponse convert(VentaProducto source) {

        LOGGER.info(LogUtils.restMarker, "REST -   VentaProductoToVentaProductoResponseConverter   - INPUT - convert - Converting");

        VentaProductoResponse ventaProductoResponse = new VentaProductoResponse();
        ventaProductoResponse.setId(source.getId());
        ventaProductoResponse.setVenta(source.getVenta());
        ventaProductoResponse.setProducto(source.getProducto());
        ventaProductoResponse.setCantidad(source.getCantidad());
        ventaProductoResponse.setPrecio(source.getPrecio());

        LOGGER.info(LogUtils.restMarker, "REST -   VentaProductoToVentaProductoResponseConverter   - OUTPUT - convert - Converted");



        return ventaProductoResponse;
    }
}
