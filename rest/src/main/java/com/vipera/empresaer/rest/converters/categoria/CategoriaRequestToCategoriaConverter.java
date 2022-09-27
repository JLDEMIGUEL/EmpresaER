package com.vipera.empresaer.rest.converters.categoria;

import com.vipera.empresaer.dao.models.Categoria;
import com.vipera.empresaer.rest.requests.CategoriaRequest;
import com.vipera.empresaer.rest.utils.logs.LogUtils;
import com.vipera.empresaer.rest.validators.CategoriaValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;

public class CategoriaRequestToCategoriaConverter implements Converter<CategoriaRequest, Categoria> {

    private static final Logger LOGGER = LoggerFactory.getLogger(CategoriaRequestToCategoriaConverter.class);


    @Override
    public Categoria convert(CategoriaRequest source) {
        LOGGER.info(LogUtils.restMarker, "REST -   CategoriaRequestToCategoriaConverter   - INPUT - convert - Converting");

        source = new CategoriaValidator().validate(source);

        Categoria categoria = new Categoria();
        if(source.getId()!=null){
            categoria.setId(source.getId());
        }else{
            categoria.setNombre(source.getNombre());
            categoria.setDescripcion(source.getDescripcion());
        }


        LOGGER.info(LogUtils.restMarker, "REST -   CategoriaRequestToCategoriaConverter   - OUTPUT - convert - Converted");

        return categoria;
    }
}
