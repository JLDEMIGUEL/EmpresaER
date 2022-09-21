package com.vipera.empresaer.core.components.cliente;

import com.vipera.empresaer.core.components.BaseCore;
import com.vipera.empresaer.dao.models.Cliente;

import java.util.List;
import java.util.Map;

public interface ClienteCore extends BaseCore<Cliente> {

    List<Map<String, Object>> findHistorial(Long id);

    List<Map<String, Object>> findMediaGastos();
}
