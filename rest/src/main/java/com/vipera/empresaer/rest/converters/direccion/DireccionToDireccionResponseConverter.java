package com.vipera.empresaer.rest.converters.direccion;

import com.vipera.empresaer.dao.models.Direccion;
import com.vipera.empresaer.rest.responses.direccion.DireccionResponse;
import com.vipera.empresaer.rest.utils.LogUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;

public class DireccionToDireccionResponseConverter implements Converter<Direccion, DireccionResponse> {

    private static final Logger LOGGER = LoggerFactory.getLogger(DireccionToDireccionResponseConverter.class);

    @Override
    public DireccionResponse convert(Direccion source) {

        LOGGER.info(LogUtils.restMarker, "REST -   DireccionToDireccionResponseConverter   - INPUT - convert - Converting");

        DireccionResponse direccionResponse = new DireccionResponse();

        direccionResponse.setId(source.getId());
        direccionResponse.setCalle(source.getCalle());
        direccionResponse.setCiudad(source.getCiudad());
        direccionResponse.setComuna(source.getComuna());
        direccionResponse.setNumero(source.getNumero());

        LOGGER.info(LogUtils.restMarker, "REST -   DireccionToDireccionResponseConverter   - OUTPUT - convert - Converted");



        return direccionResponse;
    }
}
