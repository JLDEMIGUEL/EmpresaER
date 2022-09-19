package com.vipera.empresaer.core.components.cliente;

import com.vipera.empresaer.core.components.direccion.DireccionCoreImpl;
import com.vipera.empresaer.core.utils.LogUtils;
import com.vipera.empresaer.dao.models.Categoria;
import com.vipera.empresaer.dao.models.Cliente;
import com.vipera.empresaer.dao.services.cliente.ClienteService;
import com.vipera.empresaer.dao.services.direccion.DireccionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

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
        return service.findById(id).orElse(null);
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

        List<Object[]> objects = service.findHistorial(id).orElse(null);

        if(objects==null){
            LOGGER.error(com.vipera.empresaer.dao.utils.LogUtils.daoMarker, "CORE -   ClienteCoreImpl   - findHistorial - Error with database output");
            return null;
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

        List<Object[]> objects = service.findMediaGastos().orElse(null);

        if(objects==null){
            LOGGER.error(com.vipera.empresaer.dao.utils.LogUtils.daoMarker, "CORE -   ClienteCoreImpl   - findMediaGastos - Error with database output");
            return null;
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
