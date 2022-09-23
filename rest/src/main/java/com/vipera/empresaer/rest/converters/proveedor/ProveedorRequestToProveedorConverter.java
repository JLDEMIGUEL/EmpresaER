package com.vipera.empresaer.rest.converters.proveedor;

import com.vipera.empresaer.dao.models.Proveedor;
import com.vipera.empresaer.rest.converters.direccion.DireccionRequestToDireccionConverter;
import com.vipera.empresaer.rest.requests.ProveedorRequest;
import com.vipera.empresaer.rest.utils.LogUtils;
import com.vipera.empresaer.rest.validators.ProveedorValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;

public class ProveedorRequestToProveedorConverter implements Converter<ProveedorRequest, Proveedor> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProveedorRequestToProveedorConverter.class);

    @Override
    public Proveedor convert(ProveedorRequest source) {

        LOGGER.info(LogUtils.restMarker, "REST -   ProveedorRequestToProveedorConverter   - INPUT - convert - Converting");

        source= new ProveedorValidator().validate(source);

        Proveedor proveedor = new Proveedor();
        if(source.getId() != null){
            proveedor.setId(source.getId());
        }else {
            proveedor.setNombre(source.getNombre());
            proveedor.setDireccion(new DireccionRequestToDireccionConverter().convert(source.getDireccion()));
            proveedor.setTelefono(source.getTelefono());
            proveedor.setWeb(source.getWeb());
        }

        LOGGER.info(LogUtils.restMarker, "REST -   ProveedorRequestToProveedorConverter   - OUTPUT - convert - Converted");

        return proveedor;
    }
}
