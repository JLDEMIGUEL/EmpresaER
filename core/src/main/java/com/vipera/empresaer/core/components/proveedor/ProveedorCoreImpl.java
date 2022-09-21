package com.vipera.empresaer.core.components.proveedor;

import com.vipera.empresaer.core.exceptions.types.RestException;
import com.vipera.empresaer.core.utils.LogUtils;
import com.vipera.empresaer.dao.models.Proveedor;
import com.vipera.empresaer.dao.services.direccion.DireccionService;
import com.vipera.empresaer.dao.services.proveedor.ProveedorService;
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
public class ProveedorCoreImpl implements ProveedorCore {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProveedorCoreImpl.class);

    @Autowired
    private ProveedorService service;

    @Autowired
    private DireccionService direccionService;


    @Override
    public List<Proveedor> findAll() {
        LOGGER.info(LogUtils.coreMarker, "CORE -   ProveedorCoreImpl   - INPUT - findAll - Searching all");

        List all = service.findAll();

        LOGGER.info(LogUtils.coreMarker, "CORE -   ProveedorCoreImpl   - OUTPUT - findAll - Returning all");

        return all;
    }

    @Override
    public Proveedor findById(Long id) {

        LOGGER.info(LogUtils.coreMarker, "CORE -   ProveedorCoreImpl   - INPUT - findById - Searching by id");

        Proveedor proveedor = service.findById(id).orElseThrow(() -> new RestException("1", "Proveedor by Id not founded", HttpStatus.NOT_FOUND));

        LOGGER.info(LogUtils.coreMarker, "CORE -   ProveedorCoreImpl   - OUTPUT - findById - Returning by id");
        return proveedor;
    }

    @Override
    public Proveedor save(Proveedor object) {

        LOGGER.info(LogUtils.coreMarker, "CORE -   ProveedorCoreImpl   - INPUT - save - Saving Proveedor");

        if(object.getDireccion().isNew()){
            LOGGER.info(LogUtils.coreMarker, "CORE -   ProveedorCoreImpl   - saving new direccion");
            object.setDireccion(direccionService.save(object.getDireccion()));
        }

        Proveedor t = service.save(object);

        LOGGER.info(LogUtils.coreMarker, "CORE -   ProveedorCoreImpl   - OUTPUT - save - Returning saved Proveedor");
        return t;
    }

    @Override
    public void delete(Proveedor object) {
        service.delete(object);
    }


    @Override
    public void deleteById(Long id) {
        service.deleteById(id);
    }

    @Override
    public List<Map<String, Object>> findAllByIngresos() {

        LOGGER.info(LogUtils.coreMarker, "CORE -   ProveedorCoreImpl   - INPUT - findAllByIngresos - Searching all by Ingresos");

        List all = new ArrayList();

        List<Object[]> objectList = service.findAllByIngresos();

        if(objectList.isEmpty()){
            throw new RestException("6","Ingresos not founded", HttpStatus.NOT_FOUND);
        }

        objectList.forEach(objects -> {
            Map map = new HashMap<>();
            map.put("Nombre Proveedor",objects[0]);
            map.put("Ingresos",objects[1]);
            all.add(map);
        });

        LOGGER.info(LogUtils.coreMarker, "CORE -   ProveedorCoreImpl   - OUTPUT - findAllByIngresos - Returning all by Ingresos");

        return all;
    }
}
