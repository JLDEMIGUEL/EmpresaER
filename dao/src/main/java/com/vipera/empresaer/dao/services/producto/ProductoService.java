package com.vipera.empresaer.dao.services.producto;

import com.vipera.empresaer.dao.models.Producto;
import com.vipera.empresaer.dao.services.BaseService;

import java.util.List;

public interface ProductoService extends BaseService<Producto> {


    List<Producto> findAllByCategoriaId(Long categoriaId);

    List<Object[]> findAllPreciosComparison();
}
