package com.vipera.empresaer.rest.converters.direccion;

import com.vipera.empresaer.dao.models.Direccion;
import com.vipera.empresaer.rest.requests.DireccionRequest;
import com.vipera.empresaer.rest.utils.logs.LogUtils;
import com.vipera.empresaer.rest.validators.DireccionValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;

public class DireccionRequestToDireccionConverter implements Converter<DireccionRequest, Direccion> {

    private static final Logger LOGGER = LoggerFactory.getLogger(DireccionRequestToDireccionConverter.class);

    @Override
    public Direccion convert(DireccionRequest source) {

        LOGGER.info(LogUtils.restMarker, "REST -   DireccionRequestToDireccionConverter   - INPUT - convert - Converting");

        source = new DireccionValidator().validate(source);

        Direccion direccion = new Direccion();
        if(source.getId() != null){
            direccion.setId(source.getId());
        }else{
            direccion.setCalle(source.getCalle());
            direccion.setCiudad(source.getCiudad());
            direccion.setComuna(source.getComuna());
            direccion.setNumero(source.getNumero());
        }


        LOGGER.info(LogUtils.restMarker, "REST -   DireccionRequestToDireccionConverter   - OUTPUT - convert - Converted");



        return direccion;
    }
}
