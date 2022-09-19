package com.vipera.empresaer.dao.services.producto;

import com.vipera.empresaer.dao.models.Categoria;
import com.vipera.empresaer.dao.models.Producto;
import com.vipera.empresaer.dao.services.BaseService;

import java.util.List;
import java.util.Optional;

public interface ProductoService extends BaseService<Producto> {


    Optional<List<Producto>> findAllByCategoriaId(Long categoriaId);

    Optional<List<Object[]>> findAllPreciosComparison();
}
