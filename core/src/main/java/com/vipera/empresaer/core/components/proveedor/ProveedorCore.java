package com.vipera.empresaer.core.components.proveedor;

import com.vipera.empresaer.core.components.BaseCore;
import com.vipera.empresaer.dao.models.Proveedor;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface ProveedorCore extends BaseCore<Proveedor> {


    List<Map<String, Object>> findAllByIngresos();
}
