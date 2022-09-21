package com.vipera.empresaer.rest.converters.cliente;

import com.vipera.empresaer.dao.models.Cliente;
import com.vipera.empresaer.rest.requests.ClienteRequest;
import com.vipera.empresaer.rest.utils.LogUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;

public class ClienteRequestToClienteConverter implements Converter<ClienteRequest, Cliente> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClienteRequestToClienteConverter.class);

    @Override
    public Cliente convert(ClienteRequest source) {

        LOGGER.info(LogUtils.restMarker, "REST -   ClienteRequestToClienteConverter   - INPUT - convert - Converting");

        Cliente cliente = new Cliente();
        cliente.setId(source.getId());
        cliente.setNombre(source.getNombre());
        cliente.setDireccion(source.getDireccion());
        cliente.setTelefono(source.getTelefono());

        LOGGER.info(LogUtils.restMarker, "REST -   ClienteRequestToClienteConverter   - OUTPUT - convert - Converted");

        return cliente;
    }
}
