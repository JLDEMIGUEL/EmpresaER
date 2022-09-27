package com.vipera.empresaer.rest.converters.proveedor;

import com.vipera.empresaer.dao.models.Proveedor;
import com.vipera.empresaer.rest.responses.proveedor.ProveedorResponse;
import com.vipera.empresaer.rest.utils.logs.LogUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;

public class ProveedorToProveedorResponseConverter implements Converter<Proveedor, ProveedorResponse> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProveedorToProveedorResponseConverter.class);


    @Override
    public ProveedorResponse convert(Proveedor source) {

        LOGGER.info(LogUtils.restMarker, "REST -   ProveedorToProveedorResponseConverter   - INPUT - convert - Converting");

        ProveedorResponse proveedorResponse = new ProveedorResponse();
        proveedorResponse.setId(source.getId());
        proveedorResponse.setNombre(source.getNombre());
        proveedorResponse.setDireccion(source.getDireccion());
        proveedorResponse.setTelefono(source.getTelefono());
        proveedorResponse.setWeb(source.getWeb());

        LOGGER.info(LogUtils.restMarker, "REST -   ProveedorToProveedorResponseConverter   - OUTPUT - convert - Converted");



        return proveedorResponse;
    }
}
