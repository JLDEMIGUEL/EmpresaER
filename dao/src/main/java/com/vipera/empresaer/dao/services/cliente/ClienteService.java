package com.vipera.empresaer.dao.services.cliente;

import com.vipera.empresaer.dao.models.Cliente;
import com.vipera.empresaer.dao.services.BaseService;

import java.util.List;

public interface ClienteService extends BaseService<Cliente> {


    List<Object[]> findHistorial(Long id);


    List<Object[]> findMediaGastos();
}
