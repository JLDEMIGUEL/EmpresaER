package com.vipera.empresaer.rest.converters.proveedor;

import com.vipera.empresaer.dao.models.Proveedor;
import com.vipera.empresaer.rest.requests.ProveedorRequest;
import com.vipera.empresaer.rest.utils.LogUtils;
import com.vipera.empresaer.rest.validators.NumberValidator;
import com.vipera.empresaer.rest.validators.StringValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;

public class ProveedorRequestToProveedorConverter implements Converter<ProveedorRequest, Proveedor> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProveedorRequestToProveedorConverter.class);

    @Override
    public Proveedor convert(ProveedorRequest source) {

        LOGGER.info(LogUtils.restMarker, "REST -   ProveedorRequestToProveedorConverter   - INPUT - convert - Converting");

        Proveedor proveedor = new Proveedor();
        proveedor.setId(new NumberValidator().validateLong(source.getId()));
        proveedor.setNombre(new StringValidator().validate(source.getNombre()));
        proveedor.setDireccion(source.getDireccion());
        proveedor.setTelefono(new StringValidator().validatePhone(source.getTelefono()));
        proveedor.setWeb(new StringValidator().validateWeb(source.getWeb()));

        LOGGER.info(LogUtils.restMarker, "REST -   ProveedorRequestToProveedorConverter   - OUTPUT - convert - Converted");

        return proveedor;
    }
}
