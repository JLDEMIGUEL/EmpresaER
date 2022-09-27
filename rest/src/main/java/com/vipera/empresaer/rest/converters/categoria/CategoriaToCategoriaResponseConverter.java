package com.vipera.empresaer.rest.converters.categoria;

import com.vipera.empresaer.dao.models.Categoria;
import com.vipera.empresaer.rest.responses.categoria.CategoriaResponse;
import com.vipera.empresaer.rest.utils.logs.LogUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;

public class CategoriaToCategoriaResponseConverter implements Converter<Categoria, CategoriaResponse> {


    private static final Logger LOGGER = LoggerFactory.getLogger(CategoriaToCategoriaResponseConverter.class);

    @Override
    public CategoriaResponse convert(Categoria source) {
        LOGGER.info(LogUtils.restMarker, "REST -   CategoriaToCategoriaResponseConverter   - INPUT - convert - Converting");

        CategoriaResponse categoriaResponse = new CategoriaResponse();
        categoriaResponse.setId(source.getId());
        categoriaResponse.setNombre(source.getNombre());
        categoriaResponse.setDescripcion(source.getDescripcion());

        LOGGER.info(LogUtils.restMarker, "REST -   CategoriaToCategoriaResponseConverter   - OUTPUT - convert - Converted");

        return categoriaResponse;
    }
}
