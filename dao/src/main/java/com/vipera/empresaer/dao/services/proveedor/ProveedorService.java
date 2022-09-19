package com.vipera.empresaer.dao.services.proveedor;

import com.vipera.empresaer.dao.models.Producto;
import com.vipera.empresaer.dao.models.Proveedor;
import com.vipera.empresaer.dao.services.BaseService;

import java.util.List;
import java.util.Optional;

public interface ProveedorService extends BaseService<Proveedor> {

    Optional<List<Object[]>> findAllByIngresos();
}
