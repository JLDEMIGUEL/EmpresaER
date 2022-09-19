package com.vipera.empresaer.dao.services.proveedor;

import com.vipera.empresaer.dao.models.Cliente;
import com.vipera.empresaer.dao.models.Producto;
import com.vipera.empresaer.dao.models.Proveedor;
import com.vipera.empresaer.dao.repositories.ProveedorRepository;
import com.vipera.empresaer.dao.services.categoria.CategoriaServiceImpl;
import com.vipera.empresaer.dao.utils.LogUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ProveedorServiceImpl implements ProveedorService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProveedorServiceImpl.class);

    @Autowired
    private ProveedorRepository repository;


    @Override
    public List<Proveedor> findAll() {
        LOGGER.info(LogUtils.daoMarker, "DAO -   ProveedorServiceImpl   - INPUT - findAll - Searching all");

        List all = repository.findAll();

        LOGGER.info(LogUtils.daoMarker, "DAO -   ProveedorServiceImpl   - OUTPUT - findAll - Returning all");

        return repository.findAll();
    }

    @Override
    public Optional<Proveedor> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Proveedor save(Proveedor object) {
        LOGGER.info(LogUtils.daoMarker, "DAO -   ProveedorServiceImpl   - INPUT - save - Saving Proveedor");

        Proveedor t = repository.save(object);

        LOGGER.info(LogUtils.daoMarker, "DAO -   ProveedorServiceImpl   - OUTPUT - save - Returning saved Proveedor");

        return t;
    }

    @Override
    public void delete(Proveedor object) {
        repository.delete(object);
    }


    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<List<Object[]>> findAllByIngresos() {
        LOGGER.info(LogUtils.daoMarker, "DAO -   ProveedorServiceImpl   - INPUT - findAllByIngresos - Searching all by Ingresos");

        Optional<List<Object[]>> allByIngresos = repository.findAllByIngresos();

        LOGGER.info(LogUtils.daoMarker, "DAO -   ProveedorServiceImpl   - OUTPUT - findAllByIngresos - Returning all by Ingresos");
        return allByIngresos;
    }
}
