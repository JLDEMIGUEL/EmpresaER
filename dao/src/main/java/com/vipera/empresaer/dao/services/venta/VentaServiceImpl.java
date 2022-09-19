package com.vipera.empresaer.dao.services.venta;

import com.vipera.empresaer.dao.models.Cliente;
import com.vipera.empresaer.dao.models.Venta;
import com.vipera.empresaer.dao.repositories.VentaRepository;
import com.vipera.empresaer.dao.services.categoria.CategoriaServiceImpl;
import com.vipera.empresaer.dao.utils.LogUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class VentaServiceImpl implements VentaService {

    private static final Logger LOGGER = LoggerFactory.getLogger(VentaServiceImpl.class);

    @Autowired
    private VentaRepository repository;


    @Override
    public List<Venta> findAll() {
        LOGGER.info(LogUtils.daoMarker, "DAO -   VentaServiceImpl   - INPUT - findAll - Searching all");

        List all = repository.findAll();

        LOGGER.info(LogUtils.daoMarker, "DAO -   VentaServiceImpl   - OUTPUT - findAll - Returning all");

        return repository.findAll();
    }

    @Override
    public Optional<Venta> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Venta save(Venta object) {
        LOGGER.info(LogUtils.daoMarker, "DAO -   VentaServiceImpl   - INPUT - save - Saving Venta");

        Venta t = repository.save(object);

        LOGGER.info(LogUtils.daoMarker, "DAO -   VentaServiceImpl   - OUTPUT - save - Returning saved Venta");

        return t;
    }

    @Override
    public void delete(Venta object) {
        repository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
