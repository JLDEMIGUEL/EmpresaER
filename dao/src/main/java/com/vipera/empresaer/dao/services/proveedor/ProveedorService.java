package com.vipera.empresaer.dao.services.proveedor;

import com.vipera.empresaer.dao.models.Proveedor;
import com.vipera.empresaer.dao.services.BaseService;

import java.util.List;

public interface ProveedorService extends BaseService<Proveedor> {

    List<Object[]> findAllByIngresos();
}
