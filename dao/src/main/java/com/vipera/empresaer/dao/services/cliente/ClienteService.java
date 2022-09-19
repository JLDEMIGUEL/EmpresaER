package com.vipera.empresaer.dao.services.cliente;

import com.vipera.empresaer.dao.models.Cliente;
import com.vipera.empresaer.dao.services.BaseService;

import java.util.List;
import java.util.Optional;

public interface ClienteService extends BaseService<Cliente> {


    Optional<List<Object[]>> findHistorial(Long id);


    Optional<List<Object[]>> findMediaGastos();
}
