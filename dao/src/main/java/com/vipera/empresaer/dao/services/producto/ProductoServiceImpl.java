package com.vipera.empresaer.dao.services.producto;

import com.vipera.empresaer.dao.models.Producto;
import com.vipera.empresaer.dao.repositories.ProductoRepository;
import com.vipera.empresaer.dao.utils.LogUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ProductoServiceImpl implements ProductoService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductoServiceImpl.class);

    @Autowired
    private ProductoRepository repository;

    @Override
    public List<Producto> findAll() {
        LOGGER.info(LogUtils.daoMarker, "DAO -   ProductoServiceImpl   - INPUT - findAll - Searching all");

        List all = repository.findAll();

        LOGGER.info(LogUtils.daoMarker, "DAO -   ProductoServiceImpl   - OUTPUT - findAll - Returning all");

        return repository.findAll();
    }

    @Override
    public Optional<Producto> findById(Long id) {
        LOGGER.info(LogUtils.daoMarker, "DAO -   CategoriaServiceImpl   - INPUT - findById - Searching by id");

        Optional<Producto> optionalProducto = repository.findById(id);

        LOGGER.info(LogUtils.daoMarker, "DAO -   CategoriaServiceImpl   - OUTPUT - findById - Returning by id");
        return optionalProducto;
    }

    @Override
    public Producto save(Producto object) {
        LOGGER.info(LogUtils.daoMarker, "DAO -   ProductoServiceImpl   - INPUT - save - Saving Producto");

        Producto t = repository.save(object);

        LOGGER.info(LogUtils.daoMarker, "DAO -   ProductoServiceImpl   - OUTPUT - save - Returning saved Producto");

        return t;
    }

    @Override
    public void delete(Producto object) {
        repository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }


    @Override
    public List<Producto> findAllByCategoriaId(Long categoriaId) {

        LOGGER.info(LogUtils.daoMarker, "DAO -   ProductoServiceImpl   - INPUT - findAllByCategoriaId - Searching all products of category :"+categoriaId);

        List<Producto> optionalProductos = repository.findAllByCategoriaId(categoriaId);

        LOGGER.info(LogUtils.daoMarker, "DAO -   ProductoServiceImpl   - OUTPUT - findAllByCategoriaId - Returning products of category :"+categoriaId);

        return optionalProductos;
    }

    @Override
    public List<Object[]> findAllPreciosComparison() {
        LOGGER.info(LogUtils.daoMarker, "DAO -   ProductoServiceImpl   - INPUT - findAllPreciosComparison - Searching prices comparison");

        List<Object[]> optionalProductos = repository.findAllPreciosComparison();

        LOGGER.info(LogUtils.daoMarker, "DAO -   ProductoServiceImpl   - OUTPUT - findAllPreciosComparison - Returning prices comparison");

        return optionalProductos;    }
}
