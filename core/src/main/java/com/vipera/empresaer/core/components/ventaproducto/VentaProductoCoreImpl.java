package com.vipera.empresaer.core.components.ventaproducto;

import com.vipera.empresaer.core.components.producto.ProductoCore;
import com.vipera.empresaer.core.components.venta.VentaCore;
import com.vipera.empresaer.core.exceptions.types.RestException;
import com.vipera.empresaer.core.utils.LogUtils;
import com.vipera.empresaer.dao.models.Producto;
import com.vipera.empresaer.dao.models.Venta;
import com.vipera.empresaer.dao.models.VentaProducto;
import com.vipera.empresaer.dao.services.ventaproducto.VentaProductoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class VentaProductoCoreImpl implements VentaProductoCore {

    private static final Logger LOGGER = LoggerFactory.getLogger(VentaProductoCoreImpl.class);

    @Autowired
    private VentaProductoService service;

    @Autowired
    private ProductoCore productoCore;

    @Autowired
    private VentaCore ventaCore;

    @Override
    public List<VentaProducto> findAll() {
        LOGGER.info(LogUtils.coreMarker, "CORE -   VentaProductoCoreImpl   - INPUT - findAll - Searching all");

        List all = service.findAll();

        LOGGER.info(LogUtils.coreMarker, "CORE -   VentaProductoCoreImpl   - OUTPUT - findAll - Returning all");

        return all;
    }

    @Override
    public VentaProducto findById(Long id) {
        LOGGER.info(LogUtils.coreMarker, "CORE -   VentaProductoCoreImpl   - INPUT - findById - Searching by id");

        VentaProducto ventaProducto = service.findById(id).orElseThrow(() -> new RestException("1", "VentaProducto by Id not founded", HttpStatus.NOT_FOUND));


        LOGGER.info(LogUtils.coreMarker, "CORE -   VentaProductoCoreImpl   - OUTPUT - findById - Returning by id");

        return ventaProducto;
    }

    @Override
    public VentaProducto save(VentaProducto object) {

        LOGGER.info(LogUtils.coreMarker, "CORE -   VentaProductoCoreImpl   - INPUT - save - Saving VentaProducto");

        Producto producto; Venta venta;

        if(object.getProducto().isNew())
            producto = productoCore.save(object.getProducto());
        else
            producto = productoCore.findById(object.getProducto().getId());

        if(object.getVenta().isNew())
            venta = ventaCore.save(object.getVenta());
        else
            venta = ventaCore.findById(object.getVenta().getId());

        object.setProducto(producto); object.setVenta(venta);
        VentaProducto ventaProducto = service.save(object);

        LOGGER.info(LogUtils.coreMarker, "CORE -   VentaProductoCoreImpl   - OUTPUT - save - Returning saved VentaProducto");
        return ventaProducto;
    }

    @Override
    public void delete(VentaProducto object) {
        service.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        service.deleteById(id);
    }
}
