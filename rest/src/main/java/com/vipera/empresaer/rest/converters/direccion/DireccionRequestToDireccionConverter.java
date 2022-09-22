package com.vipera.empresaer.rest.converters.direccion;

import com.vipera.empresaer.dao.models.Direccion;
import com.vipera.empresaer.rest.requests.DireccionRequest;
import com.vipera.empresaer.rest.utils.LogUtils;
import com.vipera.empresaer.rest.validators.NumberValidator;
import com.vipera.empresaer.rest.validators.StringValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;

public class DireccionRequestToDireccionConverter implements Converter<DireccionRequest, Direccion> {

    private static final Logger LOGGER = LoggerFactory.getLogger(DireccionRequestToDireccionConverter.class);

    @Override
    public Direccion convert(DireccionRequest source) {

        LOGGER.info(LogUtils.restMarker, "REST -   DireccionRequestToDireccionConverter   - INPUT - convert - Converting");

        Direccion direccion = new Direccion();

        direccion.setId(new NumberValidator().validateLong(source.getId()));
        direccion.setCalle(new StringValidator().validate(source.getCalle()));
        direccion.setCiudad(new StringValidator().validate(source.getCiudad()));
        direccion.setComuna(new StringValidator().validate(source.getComuna()));
        direccion.setNumero(new NumberValidator().validateInteger(source.getNumero()));

        LOGGER.info(LogUtils.restMarker, "REST -   DireccionRequestToDireccionConverter   - OUTPUT - convert - Converted");



        return direccion;
    }
}
