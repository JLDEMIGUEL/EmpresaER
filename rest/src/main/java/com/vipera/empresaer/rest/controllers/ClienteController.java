package com.vipera.empresaer.rest.controllers;


import com.vipera.empresaer.core.components.cliente.ClienteCore;
import com.vipera.empresaer.core.exceptions.ExceptionService;
import com.vipera.empresaer.core.exceptions.types.RestException;
import com.vipera.empresaer.dao.models.Cliente;
import com.vipera.empresaer.rest.converters.cliente.ClienteRequestToClienteConverter;
import com.vipera.empresaer.rest.converters.cliente.ClienteToClienteResponseConverter;
import com.vipera.empresaer.rest.converters.cliente.MapToClienteGastosConverter;
import com.vipera.empresaer.rest.converters.cliente.MapToClienteHistorialConverter;
import com.vipera.empresaer.rest.requests.ClienteRequest;
import com.vipera.empresaer.rest.responses.cliente.ClienteHistorialResponse;
import com.vipera.empresaer.rest.responses.cliente.ClienteMediaGastosResponse;
import com.vipera.empresaer.rest.responses.cliente.ClienteResponse;
import com.vipera.empresaer.rest.utils.LogUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class ClienteController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClienteController.class);

    @Autowired
    private ClienteCore core;

    @GetMapping("/cliente/{id}")
    public ResponseEntity findById(@PathVariable Long id){

        try{
            LOGGER.info(LogUtils.restMarker, "REST -   ClienteController   - INPUT - findById - Searching by id");

            Cliente cliente = core.findById(id);

            LOGGER.info(LogUtils.restMarker, "REST -   ClienteController   - OUTPUT - findById - Returning cliente by id");

            ClienteResponse clienteResponse = new ClienteToClienteResponseConverter().convert(cliente);

            return new ResponseEntity<>(clienteResponse,HttpStatus.OK);
        }catch (RestException exception){
            return new ExceptionService().handleRestException(exception);
        }
    }


    @GetMapping("/cliente/all")
    public ResponseEntity findAll(){
        LOGGER.info(LogUtils.restMarker, "REST -   ClienteController   - INPUT - findAll - Searching all");

        List<Cliente> all = core.findAll();

        LOGGER.info(LogUtils.restMarker, "REST -   ClienteController   - OUTPUT - findAll - Returning all");

        List allResponse = new ArrayList<>();
        all.forEach(cliente -> {
            allResponse.add(new ClienteToClienteResponseConverter().convert(cliente));
        });

        return new ResponseEntity<>(allResponse,HttpStatus.OK);
    }
    @PostMapping("/cliente/save")
    public ResponseEntity save(@RequestBody ClienteRequest model){
        Cliente cliente = new ClienteRequestToClienteConverter().convert(model);

        LOGGER.info(LogUtils.restMarker, "REST -   ClienteController   - INPUT - save - Saving cliente");
        Cliente clienteSaved = core.save(cliente);

        if (clienteSaved == null)
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);

        LOGGER.info(LogUtils.restMarker, "REST -   ClienteController   - OUTPUT - save - Returning saved cliente");

        ClienteResponse clienteResponse = new ClienteToClienteResponseConverter().convert(clienteSaved);

        return new ResponseEntity(clienteResponse,HttpStatus.OK);
    }

    @GetMapping("/cliente/historial/{id}")
    public ResponseEntity findHistorial(@PathVariable Long id){

        try{
            LOGGER.info(LogUtils.restMarker, "REST -   ClienteController   - INPUT - findHistorial - Searching clients record");

            List<Map<String, Object>> mapList = core.findHistorial(id);

            if (mapList == null)
                return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
            LOGGER.info(LogUtils.restMarker, "REST -   ClienteController   - OUTPUT - findHistorial - Returning clients record");

            List<ClienteHistorialResponse> historialList = new ArrayList<>();
            mapList.forEach(map -> historialList.add(new MapToClienteHistorialConverter().convert(map)));

            return new ResponseEntity(historialList,HttpStatus.OK);
        }catch (RestException exception){
            return new ExceptionService().handleRestException(exception);
        }
    }


    @GetMapping("/cliente/all/gastos")
    public ResponseEntity findMediaGastos(){

        try{
            LOGGER.info(LogUtils.restMarker, "REST -   ClienteController   - INPUT - findMediaGastos - Searching clients waste average");

            List<Map<String, Object>> mapList = core.findMediaGastos();

            if (mapList == null)
                return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
            LOGGER.info(LogUtils.restMarker, "REST -   ClienteController   - OUTPUT - findMediaGastos - Returning clients waste average");

            List<ClienteMediaGastosResponse> responseList = new ArrayList<>();

            mapList.forEach(map -> responseList.add(new MapToClienteGastosConverter().convert(map)));

            return new ResponseEntity(responseList,HttpStatus.OK);
        }catch (RestException exception){
            return new ExceptionService().handleRestException(exception);
        }
    }
}
