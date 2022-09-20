package com.vipera.empresaer.rest.controllers;


import com.vipera.empresaer.core.components.cliente.ClienteCore;
import com.vipera.empresaer.core.exceptions.ExceptionService;
import com.vipera.empresaer.core.exceptions.types.RestException;
import com.vipera.empresaer.dao.models.Cliente;
import com.vipera.empresaer.rest.models.ClienteModel;
import com.vipera.empresaer.rest.utils.LogUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class ClienteController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClienteController.class);

    @Autowired
    private ClienteCore core;


    @GetMapping("/cliente/all")
    public ResponseEntity findAll(){
        LOGGER.info(LogUtils.restMarker, "REST -   ClienteController   - INPUT - findAll - Searching all");

        List all = core.findAll();

        LOGGER.info(LogUtils.restMarker, "REST -   ClienteController   - OUTPUT - findAll - Returning all");
        return new ResponseEntity<>(all,HttpStatus.OK);
    }
    @PostMapping("/cliente/save")
    public ResponseEntity save(@RequestBody ClienteModel model){
        Cliente cliente = new Cliente();

        BeanUtils.copyProperties(model,cliente);

        LOGGER.info(LogUtils.restMarker, "REST -   ClienteController   - INPUT - save - Saving cliente");
        Cliente t = core.save(cliente);

        if (t == null)
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);

        LOGGER.info(LogUtils.restMarker, "REST -   ClienteController   - OUTPUT - save - Returning saved cliente");

        return new ResponseEntity(t,HttpStatus.OK);
    }

    @GetMapping("/cliente/historial/{id}")
    public ResponseEntity findHistorial(@PathVariable Long id){

        try{
            LOGGER.info(LogUtils.restMarker, "REST -   ClienteController   - INPUT - findHistorial - Searching clients record");

            List<Map<String, Object>> mapList = core.findHistorial(id);

            if (mapList == null)
                return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
            LOGGER.info(LogUtils.restMarker, "REST -   ClienteController   - OUTPUT - findHistorial - Returning clients record");

            return new ResponseEntity(mapList,HttpStatus.OK);
        }catch (RestException exception){
            return new ExceptionService().handleRestException(exception);
        }
    }

    @GetMapping("/cliente/{id}")
    public ResponseEntity findById(@PathVariable Long id){

        try{
            LOGGER.info(LogUtils.restMarker, "REST -   ClienteController   - INPUT - findById - Searching by id");

            Cliente cliente = core.findById(id);

            LOGGER.info(LogUtils.restMarker, "REST -   ClienteController   - OUTPUT - findById - Returning cliente by id");
            return new ResponseEntity<>(cliente,HttpStatus.OK);
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

            return new ResponseEntity(mapList,HttpStatus.OK);
        }catch (RestException exception){
            return new ExceptionService().handleRestException(exception);
        }

    }
}
