package com.vipera.empresaer.dao.services.categoria;

import com.vipera.empresaer.dao.models.Categoria;
import com.vipera.empresaer.dao.repositories.CategoriaRepository;
import com.vipera.empresaer.dao.utils.LogUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CategoriaServiceImpl implements CategoriaService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CategoriaServiceImpl.class);
    @Autowired
    private CategoriaRepository repository;


    @Override
    public List<Categoria> findAll() {

        LOGGER.info(LogUtils.daoMarker, "DAO -   CategoriaServiceImpl   - INPUT - findAll - Searching all");

        List all = repository.findAll();

        LOGGER.info(LogUtils.daoMarker, "DAO -   CategoriaServiceImpl   - OUTPUT - findAll - Returning all");

        return repository.findAll();
    }

    @Override
    public Optional<Categoria> findById(Long id) {

        LOGGER.info(LogUtils.daoMarker, "DAO -   CategoriaServiceImpl   - INPUT - findById - Searching by id");

        Optional<Categoria> optionalCategoria = repository.findById(id);

        LOGGER.info(LogUtils.daoMarker, "DAO -   CategoriaServiceImpl   - OUTPUT - findById - Returning by id");
        return optionalCategoria;
    }

    @Override
    public Categoria save(Categoria object) {
        LOGGER.info(LogUtils.daoMarker, "DAO -   CategoriaServiceImpl   - INPUT - save - Saving categoria");

        Categoria t = repository.save(object);

        LOGGER.info(LogUtils.daoMarker, "DAO -   CategoriaServiceImpl   - OUTPUT - save - Returning saved categoria");

        return t;
    }

    @Override
    public void delete(Categoria object) {
        repository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
