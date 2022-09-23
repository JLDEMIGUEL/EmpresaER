package com.vipera.empresaer.core.components.venta;

import com.vipera.empresaer.core.components.cliente.ClienteCore;
import com.vipera.empresaer.core.exceptions.types.RestException;
import com.vipera.empresaer.core.utils.LogUtils;
import com.vipera.empresaer.dao.models.Cliente;
import com.vipera.empresaer.dao.models.Venta;
import com.vipera.empresaer.dao.services.venta.VentaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class VentaCoreImpl implements VentaCore {

    private static final Logger LOGGER = LoggerFactory.getLogger(VentaCoreImpl.class);

    @Autowired
    private VentaService service;

    @Autowired
    private ClienteCore clienteCore;


    @Override
    public List<Venta> findAll() {
        LOGGER.info(LogUtils.coreMarker, "CORE -   VentaCoreImpl   - INPUT - findAll - Searching all");

        List all = service.findAll();

        LOGGER.info(LogUtils.coreMarker, "CORE -   VentaCoreImpl   - OUTPUT - findAll - Returning all");

        return all;
    }

    @Override
    public Venta findById(Long id) {

        LOGGER.info(LogUtils.coreMarker, "CORE -   VentaCoreImpl   - INPUT - findById - Searching by id");

        Venta venta = service.findById(id).orElseThrow(() -> new RestException("1", "Venta by Id not founded", HttpStatus.NOT_FOUND));


        LOGGER.info(LogUtils.coreMarker, "CORE -   VentaCoreImpl   - OUTPUT - findById - Returning by id");
        return venta;
    }

    @Override
    public Venta save(Venta object) {

        LOGGER.info(LogUtils.coreMarker, "CORE -   VentaCoreImpl   - INPUT - save - Saving Venta");

        Cliente cliente;

        if(object.getCliente().isNew())
            cliente = clienteCore.save(object.getCliente());
        else
            cliente = clienteCore.findById(object.getCliente().getId());

        object.setCliente(cliente);

        Venta venta = service.save(object);

        LOGGER.info(LogUtils.coreMarker, "CORE -   VentaCoreImpl   - OUTPUT - save - Returning saved Venta");
        return venta;
    }

    @Override
    public void delete(Venta object) {
        service.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        service.deleteById(id);
    }
}
