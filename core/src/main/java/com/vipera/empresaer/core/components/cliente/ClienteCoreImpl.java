package com.vipera.empresaer.core.components.cliente;

import com.vipera.empresaer.core.exceptions.types.RestException;
import com.vipera.empresaer.core.utils.LogUtils;
import com.vipera.empresaer.dao.models.Cliente;
import com.vipera.empresaer.dao.services.cliente.ClienteService;
import com.vipera.empresaer.dao.services.direccion.DireccionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ClienteCoreImpl implements ClienteCore {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClienteCoreImpl.class);

    @Autowired
    private ClienteService service;

    @Autowired
    private DireccionService direccionService;

    @Override
    public List<Cliente> findAll() {
        LOGGER.info(LogUtils.coreMarker, "CORE -   ClienteCoreImpl   - INPUT - findAll - Searching all");

        List all = service.findAll();

        LOGGER.info(LogUtils.coreMarker, "CORE -   ClienteCoreImpl   - OUTPUT - findAll - Returning all");

        return all;
    }

    @Override
    public Cliente findById(Long id) {
        LOGGER.info(LogUtils.coreMarker, "CORE -   ClienteCoreImpl   - INPUT - findById - Searching by id");

        Cliente cliente = service.findById(id).orElseThrow(() -> new RestException("1", "Cliente by Id not founded", HttpStatus.NOT_FOUND));

        LOGGER.info(LogUtils.coreMarker, "CORE -   ClienteCoreImpl   - OUTPUT - findById - Returning by id");

        return cliente;
    }

    @Override
    public Cliente save(Cliente object) {
        LOGGER.info(LogUtils.coreMarker, "CORE -   ClienteCoreImpl   - INPUT - save - Saving cliente");

        if(object.getDireccion().isNew()){
            LOGGER.info(LogUtils.coreMarker, "CORE -   ClienteCoreImpl   - saving new direccion");
            object.setDireccion(direccionService.save(object.getDireccion()));
        }

        Cliente t = service.save(object);

        LOGGER.info(LogUtils.coreMarker, "CORE -   ClienteCoreImpl   - OUTPUT - save - Returning saved cliente");
        return t;
    }

    @Override
    public void delete(Cliente object) {
        service.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        service.deleteById(id);
    }

    @Override
    public List<Map <String, Object>> findHistorial(Long id) {

        LOGGER.info(com.vipera.empresaer.dao.utils.LogUtils.daoMarker, "CORE -   ClienteCoreImpl   - INPUT - findHistorial - Searching clients record");

        List list = new ArrayList();

        List<Object[]> objects = service.findHistorial(id);

        if(objects.isEmpty()){
            throw new RestException("2","Historial by Id not founded", HttpStatus.NOT_FOUND);
        }

        objects.forEach(object -> {
            Map map = new HashMap<>();
            map.put("nombre",object[0]);
            map.put("precio",object[1]);
            map.put("cantidad",object[2]);
            map.put("fecha",object[3]);
            list.add(map);
        });

        LOGGER.info(com.vipera.empresaer.dao.utils.LogUtils.daoMarker, "CORE -   ClienteCoreImpl   - OUTPUT - findHistorial - Returning clients record");

        return list;
    }

    @Override
    public List<Map<String, Object>> findMediaGastos() {
        LOGGER.info(com.vipera.empresaer.dao.utils.LogUtils.daoMarker, "CORE -   ClienteCoreImpl   - INPUT - findMediaGastos - Searching clients waste average");

        List list = new ArrayList();

        List<Object[]> objects = service.findMediaGastos();

        if(objects.isEmpty()){
            throw new RestException("2","Historial by Id not founded", HttpStatus.NOT_FOUND);
        }

        objects.forEach(object -> {
            Map map = new HashMap<>();
            map.put("nombre",object[0]);
            map.put("MediaGastos",Double.valueOf(Math.round((Double)object[1]*100))/100);
            list.add(map);
        });

        LOGGER.info(com.vipera.empresaer.dao.utils.LogUtils.daoMarker, "CORE -   ClienteCoreImpl   - OUTPUT - findMediaGastos - Returning clients waste average");


        return list;

    }
}
