package com.vipera.empresaer.core.components.venta;

import com.vipera.empresaer.core.components.ventaproducto.VentaProductoCoreImpl;
import com.vipera.empresaer.core.utils.LogUtils;
import com.vipera.empresaer.dao.models.Cliente;
import com.vipera.empresaer.dao.models.Venta;
import com.vipera.empresaer.dao.services.cliente.ClienteService;
import com.vipera.empresaer.dao.services.venta.VentaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class VentaCoreImpl implements VentaCore {

    private static final Logger LOGGER = LoggerFactory.getLogger(VentaCoreImpl.class);

    @Autowired
    private VentaService service;

    @Autowired
    private ClienteService clienteService;


    @Override
    public List<Venta> findAll() {
        LOGGER.info(LogUtils.coreMarker, "CORE -   VentaCoreImpl   - INPUT - findAll - Searching all");

        List all = service.findAll();

        LOGGER.info(LogUtils.coreMarker, "CORE -   VentaCoreImpl   - OUTPUT - findAll - Returning all");

        return all;
    }

    @Override
    public Venta findById(Long id) {
        return service.findById(id).orElse(null);
    }

    @Override
    public Venta save(Venta object) {

        LOGGER.info(LogUtils.coreMarker, "CORE -   VentaCoreImpl   - INPUT - save - Saving Venta");

        if(object.getCliente().isNew()){
            LOGGER.info(LogUtils.coreMarker, "CORE -   VentaCoreImpl   - saving new Cliente");
            object.setCliente(clienteService.save(object.getCliente()));
        }

        Venta t = service.save(object);

        LOGGER.info(LogUtils.coreMarker, "CORE -   VentaCoreImpl   - OUTPUT - save - Returning saved Venta");
        return t;
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
