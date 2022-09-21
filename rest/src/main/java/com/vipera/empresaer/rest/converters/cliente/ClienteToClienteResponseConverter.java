package com.vipera.empresaer.rest.converters.cliente;

import com.vipera.empresaer.dao.models.Cliente;
import com.vipera.empresaer.rest.responses.cliente.ClienteResponse;
import com.vipera.empresaer.rest.utils.LogUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;

public class ClienteToClienteResponseConverter implements Converter<Cliente, ClienteResponse> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClienteToClienteResponseConverter.class);

    @Override
    public ClienteResponse convert(Cliente source) {

        LOGGER.info(LogUtils.restMarker, "REST -   ClienteToClienteResponseConverter   - INPUT - convert - Converting");

        ClienteResponse clienteResponse = new ClienteResponse();
        clienteResponse.setId(source.getId());
        clienteResponse.setNombre(source.getNombre());
        clienteResponse.setTelefono(source.getTelefono());
        clienteResponse.setDireccion(source.getDireccion());

        LOGGER.info(LogUtils.restMarker, "REST -   ClienteToClienteResponseConverter   - OUTPUT - convert - Converted");


        return clienteResponse;
    }
}
