package com.vipera.empresaer.rest.converters.direccion;

import com.vipera.empresaer.dao.models.Direccion;
import com.vipera.empresaer.rest.requests.DireccionRequest;
import com.vipera.empresaer.rest.utils.LogUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;

public class DireccionRequestToDireccionConverter implements Converter<DireccionRequest, Direccion> {

    private static final Logger LOGGER = LoggerFactory.getLogger(DireccionRequestToDireccionConverter.class);

    @Override
    public Direccion convert(DireccionRequest source) {

        LOGGER.info(LogUtils.restMarker, "REST -   DireccionRequestToDireccionConverter   - INPUT - convert - Converting");

        Direccion direccion = new Direccion();

        direccion.setId(source.getId());
        direccion.setCalle(source.getCalle());
        direccion.setCiudad(source.getCiudad());
        direccion.setComuna(source.getComuna());
        direccion.setNumero(source.getNumero());

        LOGGER.info(LogUtils.restMarker, "REST -   DireccionRequestToDireccionConverter   - OUTPUT - convert - Converted");



        return direccion;
    }
}
