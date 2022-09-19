package com.vipera.empresaer.core.components.producto;

import com.vipera.empresaer.core.utils.LogUtils;
import com.vipera.empresaer.dao.models.Producto;
import com.vipera.empresaer.dao.services.categoria.CategoriaService;
import com.vipera.empresaer.dao.services.producto.ProductoService;
import com.vipera.empresaer.dao.services.proveedor.ProveedorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ProductoCoreImpl implements ProductoCore {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductoCoreImpl.class);

    @Autowired
    private ProductoService service;
    @Autowired
    private ProveedorService proveedorService;
    @Autowired
    private CategoriaService categoriaService;

    @Override
    public List<Producto> findAll() {
        LOGGER.info(LogUtils.coreMarker, "CORE -   ProductoCoreImpl   - INPUT - findAll - Searching all");

        List all = service.findAll();

        LOGGER.info(LogUtils.coreMarker, "CORE -   ProductoCoreImpl   - OUTPUT - findAll - Returning all");

        return all;
    }

    @Override
    public Producto findById(Long id) {
        return service.findById(id).orElse(null);
    }

    @Override
    public Producto save(Producto object) {

        LOGGER.info(LogUtils.coreMarker, "CORE -   ProductoCoreImpl   - INPUT - save - Saving Producto");

        if(object.getProveedor().isNew()){
            LOGGER.info(LogUtils.coreMarker, "CORE -   ProductoCoreImpl   - saving new Proveedor");
            object.setProveedor(proveedorService.save(object.getProveedor()));
        }
        if(object.getCategoria().isNew()){
            LOGGER.info(LogUtils.coreMarker, "CORE -   ProductoCoreImpl   - saving new Categoria");
            object.setCategoria(categoriaService.save(object.getCategoria()));
        }

        Producto t = service.save(object);

        LOGGER.info(LogUtils.coreMarker, "CORE -   ProductoCoreImpl   - OUTPUT - save - Returning saved Producto");
        return t;
    }

    @Override
    public void delete(Producto object) {
        service.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        service.deleteById(id);
    }

    @Override
    public List<Producto> findAllByCategoriaId(String categoriaId) {
        LOGGER.info(LogUtils.coreMarker, "CORE -   ProductoCoreImpl   - INPUT - findAllByCategoriaId - Searching all products of category :"+categoriaId);

        List<Producto> productoList = service.findAllByCategoriaId(Long.valueOf(categoriaId)).orElse(null);
        if(productoList == null){
            LOGGER.error(LogUtils.coreMarker, "CORE -   ProductoCoreImpl  - findAllByCategoriaId - Error database output");
            return null;
        }
        LOGGER.info(LogUtils.coreMarker, "CORE -   ProductoCoreImpl   - OUTPUT - findAllByCategoriaId - Returning products of category :"+categoriaId);
        return productoList;
    }

    @Override
    public List<Map<String, Object>> findAllPreciosComparison() {
        LOGGER.info(LogUtils.coreMarker, "CORE -   ProductoCoreImpl   - INPUT - findAllPreciosComparison -  Searching prices comparison");

        List all= new ArrayList<>();

        List<Object[]> list = service.findAllPreciosComparison().orElse(null);
        if(list == null){
            LOGGER.error(LogUtils.coreMarker, "CORE -   ProductoCoreImpl  - findAllPreciosComparison - Error database output");
            return null;
        }

        list.forEach(o -> {
            Map map = new HashMap<>();
            map.put("PrecioActual",o[0]);
            map.put("PrecioCompra",o[1]);
            map.put("Stock",o[2]);
            map.put("Cantidad",o[3]);
            map.put("Nombre",o[4]);
            map.put("Categoria",o[5]);
            all.add(map);
        });

        LOGGER.info(LogUtils.coreMarker, "CORE -   ProductoCoreImpl   - OUTPUT - findAllPreciosComparison - Returning prices comparison");

        return all;
    }
}
