package com.vipera.empresaer.dao.services.ventaproducto;

import com.vipera.empresaer.dao.models.VentaProducto;
import com.vipera.empresaer.dao.repositories.VentaProductoRepository;
import com.vipera.empresaer.dao.utils.LogUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class VentaProductoServiceImpl implements VentaProductoService {

    private static final Logger LOGGER = LoggerFactory.getLogger(VentaProductoServiceImpl.class);

    @Autowired
    private VentaProductoRepository repository;

    @Override
    public List<VentaProducto> findAll() {
        LOGGER.info(LogUtils.daoMarker, "DAO -   VentaProductoServiceImpl   - INPUT - findAll - Searching all");

        List all = repository.findAll();

        LOGGER.info(LogUtils.daoMarker, "DAO -   VentaProductoServiceImpl   - OUTPUT - findAll - Returning all");

        return repository.findAll();
    }

    @Override
    public Optional<VentaProducto> findById(Long id) {
        LOGGER.info(LogUtils.daoMarker, "DAO -   CategoriaServiceImpl   - INPUT - findById - Searching by id");

        Optional<VentaProducto> optionalVentaProducto = repository.findById(id);

        LOGGER.info(LogUtils.daoMarker, "DAO -   CategoriaServiceImpl   - OUTPUT - findById - Returning by id");

        return optionalVentaProducto;
    }

    @Override
    public VentaProducto save(VentaProducto object) {
        LOGGER.info(LogUtils.daoMarker, "DAO -   VentaProductoServiceImpl   - INPUT - save - Saving VentaProducto");

        VentaProducto t = repository.save(object);

        LOGGER.info(LogUtils.daoMarker, "DAO -   VentaProductoServiceImpl   - OUTPUT - save - Returning saved VentaProducto");

        return t;
    }

    @Override
    public void delete(VentaProducto object) {
        repository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
