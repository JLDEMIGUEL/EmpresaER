package com.vipera.empresaer.core.components.direccion;

import com.vipera.empresaer.core.components.producto.ProductoCoreImpl;
import com.vipera.empresaer.core.utils.LogUtils;
import com.vipera.empresaer.dao.models.Categoria;
import com.vipera.empresaer.dao.models.Direccion;
import com.vipera.empresaer.dao.services.direccion.DireccionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DireccionCoreImpl implements DireccionCore {

    private static final Logger LOGGER = LoggerFactory.getLogger(DireccionCoreImpl.class);

    @Autowired
    private DireccionService service;

    @Override
    public List<Direccion> findAll() {
        LOGGER.info(LogUtils.coreMarker, "CORE -   DireccionCoreImpl   - INPUT - findAll - Searching all");

        List all = service.findAll();

        LOGGER.info(LogUtils.coreMarker, "CORE -   DireccionCoreImpl   - OUTPUT - findAll - Returning all");

        return all;
    }

    @Override
    public Direccion findById(Long id) {
        return service.findById(id).orElse(null);
    }

    @Override
    public Direccion save(Direccion object) {
        LOGGER.info(LogUtils.coreMarker, "CORE -   DireccionCoreImpl   - INPUT - save - Saving Direccion");

        Direccion t = service.save(object);

        LOGGER.info(LogUtils.coreMarker, "CORE -   DireccionCoreImpl   - OUTPUT - save - Returning saved Direccion");
        return t;
    }

    @Override
    public void delete(Direccion object) {
        service.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        service.deleteById(id);
    }
}
