package com.vipera.empresaer.dao.services.cliente;

import com.vipera.empresaer.dao.models.Cliente;
import com.vipera.empresaer.dao.repositories.ClienteRepository;
import com.vipera.empresaer.dao.utils.LogUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ClienteServiceImpl implements ClienteService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClienteServiceImpl.class);

    @Autowired
    private ClienteRepository repository;

    @Override
    public List<Cliente> findAll() {
        LOGGER.info(LogUtils.daoMarker, "DAO -   ClienteServiceImpl   - INPUT - findAll - Searching all");

        List all = repository.findAll();

        LOGGER.info(LogUtils.daoMarker, "DAO -   ClienteServiceImpl   - OUTPUT - findAll - Returning all");

        return repository.findAll();
    }

    @Override
    public Optional<Cliente> findById(Long id) {
        LOGGER.info(LogUtils.daoMarker, "DAO -   CategoriaServiceImpl   - INPUT - findById - Searching by id");

        Optional<Cliente> optionalCliente = repository.findById(id);

        LOGGER.info(LogUtils.daoMarker, "DAO -   CategoriaServiceImpl   - OUTPUT - findById - Returning by id");
        return optionalCliente;
    }

    @Override
    public Cliente save(Cliente object) {
        LOGGER.info(LogUtils.daoMarker, "DAO -   ClienteServiceImpl   - INPUT - save - Saving Cliente");

        Cliente t = repository.save(object);

        LOGGER.info(LogUtils.daoMarker, "DAO -   ClienteServiceImpl   - OUTPUT - save - Returning saved Cliente");

        return t;
    }

    @Override
    public void delete(Cliente object) {
        repository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<Object[]> findHistorial(Long id) {
        LOGGER.info(LogUtils.daoMarker, "DAO -   ClienteServiceImpl   - INPUT - findHistorial - Searching clients record");

        List<Object[]> optionalObjects = repository.findHistorial(id);

        LOGGER.info(LogUtils.daoMarker, "DAO -   ClienteServiceImpl   - OUTPUT - findHistorial - Returning clients record");

        return optionalObjects;
    }

    @Override
    public List<Object[]> findMediaGastos() {

        LOGGER.info(LogUtils.daoMarker, "DAO -   ClienteServiceImpl   - INPUT - findMediaGastos - Searching clients waste average");

        List<Object[]> optionalObjects = repository.findMediaGastos();

        LOGGER.info(LogUtils.daoMarker, "DAO -   ClienteServiceImpl   - OUTPUT - findMediaGastos - Returning clients waste average");

        return optionalObjects;
    }
}
