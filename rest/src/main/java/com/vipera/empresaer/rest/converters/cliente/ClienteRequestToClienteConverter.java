package com.vipera.empresaer.rest.converters.cliente;

import com.vipera.empresaer.dao.models.Cliente;
import com.vipera.empresaer.rest.requests.ClienteRequest;
import com.vipera.empresaer.rest.utils.LogUtils;
import com.vipera.empresaer.rest.validators.NumberValidator;
import com.vipera.empresaer.rest.validators.StringValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;

public class ClienteRequestToClienteConverter implements Converter<ClienteRequest, Cliente> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClienteRequestToClienteConverter.class);

    @Override
    public Cliente convert(ClienteRequest source) {

        LOGGER.info(LogUtils.restMarker, "REST -   ClienteRequestToClienteConverter   - INPUT - convert - Converting");

        Cliente cliente = new Cliente();

        cliente.setId(new NumberValidator().validateLong(source.getId()));
        cliente.setNombre(new StringValidator().validate(source.getNombre()));
        cliente.setDireccion(source.getDireccion());//TODO
        cliente.setTelefono(new StringValidator().validatePhone(source.getTelefono()));

        LOGGER.info(LogUtils.restMarker, "REST -   ClienteRequestToClienteConverter   - OUTPUT - convert - Converted");

        return cliente;
    }
}
