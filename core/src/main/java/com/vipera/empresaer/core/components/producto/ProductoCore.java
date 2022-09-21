package com.vipera.empresaer.core.components.producto;

import com.vipera.empresaer.core.components.BaseCore;
import com.vipera.empresaer.dao.models.Producto;

import java.util.List;
import java.util.Map;

public interface ProductoCore extends BaseCore<Producto> {

    List<Producto> findAllByCategoriaId(Long categoriaId);


    List<Map<String, Object>> findAllPreciosComparison();
}
