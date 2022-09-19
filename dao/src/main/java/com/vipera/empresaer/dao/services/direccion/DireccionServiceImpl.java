package com.vipera.empresaer.dao.services.direccion;

import com.vipera.empresaer.dao.models.Cliente;
import com.vipera.empresaer.dao.models.Direccion;
import com.vipera.empresaer.dao.repositories.DireccionRepository;
import com.vipera.empresaer.dao.services.categoria.CategoriaServiceImpl;
import com.vipera.empresaer.dao.utils.LogUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class DireccionServiceImpl implements DireccionService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DireccionServiceImpl.class);

    @Autowired
    private DireccionRepository repository;

    @Override
    public List<Direccion> findAll() {
        LOGGER.info(LogUtils.daoMarker, "DAO -   DireccionServiceImpl   - INPUT - findAll - Searching all");

        List all = repository.findAll();

        LOGGER.info(LogUtils.daoMarker, "DAO -   DireccionServiceImpl   - OUTPUT - findAll - Returning all");

        return repository.findAll();
    }

    @Override
    public Optional<Direccion> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Direccion save(Direccion object) {
        LOGGER.info(LogUtils.daoMarker, "DAO -   DireccionServiceImpl   - INPUT - save - Saving Direccion");

        Direccion t = repository.save(object);

        LOGGER.info(LogUtils.daoMarker, "DAO -   DireccionServiceImpl   - OUTPUT - save - Returning saved Direccion");

        return t;
    }

    @Override
    public void delete(Direccion object) {
        repository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
