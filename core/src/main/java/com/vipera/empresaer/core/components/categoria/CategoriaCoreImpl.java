package com.vipera.empresaer.core.components.categoria;

import com.vipera.empresaer.core.components.cliente.ClienteCoreImpl;
import com.vipera.empresaer.core.utils.LogUtils;
import com.vipera.empresaer.dao.models.Categoria;
import com.vipera.empresaer.dao.services.categoria.CategoriaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategoriaCoreImpl implements CategoriaCore {

    private static final Logger LOGGER = LoggerFactory.getLogger(CategoriaCoreImpl.class);

    @Autowired
    private CategoriaService service;


    @Override
    public List<Categoria> findAll() {
        LOGGER.info(LogUtils.coreMarker, "CORE -   CategoriaCoreImpl   - INPUT - findAll - Searching all");

        List all = service.findAll();

        LOGGER.info(LogUtils.coreMarker, "CORE -   CategoriaCoreImpl   - OUTPUT - findAll - Returning all");

        return all;
    }

    @Override
    public Categoria findById(Long id) {
        return service.findById(id).orElse(null);
    }

    @Override
    public Categoria save(Categoria object) {
        LOGGER.info(LogUtils.coreMarker, "CORE -   CategoriaCoreImpl   - INPUT - save - Saving categoria");

        Categoria t = service.save(object);

        LOGGER.info(LogUtils.coreMarker, "CORE -   CategoriaCoreImpl   - OUTPUT - save - Returning saved categoria");
        return t;
    }

    @Override
    public void delete(Categoria object) {
        service.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        service.deleteById(id);
    }
}
