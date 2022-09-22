package com.vipera.empresaer.rest.converters.categoria;

import com.vipera.empresaer.dao.models.Categoria;
import com.vipera.empresaer.rest.requests.CategoriaRequest;
import com.vipera.empresaer.rest.utils.LogUtils;
import com.vipera.empresaer.rest.validators.NumberValidator;
import com.vipera.empresaer.rest.validators.StringValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;

public class CategoriaRequestToCategoriaConverter implements Converter<CategoriaRequest, Categoria> {

    private static final Logger LOGGER = LoggerFactory.getLogger(CategoriaRequestToCategoriaConverter.class);


    @Override
    public Categoria convert(CategoriaRequest source) {
        LOGGER.info(LogUtils.restMarker, "REST -   CategoriaRequestToCategoriaConverter   - INPUT - convert - Converting");
        Categoria categoria = new Categoria();

        categoria.setId(new NumberValidator().validateLong(source.getId()));
        categoria.setNombre(new StringValidator().validate(source.getNombre()));
        categoria.setDescripcion(new StringValidator().validate(source.getNombre()));

        LOGGER.info(LogUtils.restMarker, "REST -   CategoriaRequestToCategoriaConverter   - OUTPUT - convert - Converted");

        return categoria;
    }
}
