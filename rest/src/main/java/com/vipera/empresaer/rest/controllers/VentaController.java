package com.vipera.empresaer.rest.controllers;

import com.vipera.empresaer.core.components.venta.VentaCore;
import com.vipera.empresaer.core.exceptions.ExceptionService;
import com.vipera.empresaer.core.exceptions.types.RestException;
import com.vipera.empresaer.dao.models.Venta;
import com.vipera.empresaer.rest.models.VentaModel;
import com.vipera.empresaer.rest.utils.LogUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VentaController {

    private static final Logger LOGGER = LoggerFactory.getLogger(VentaController.class);
    @Autowired
    private VentaCore core;


    @GetMapping("/venta/all")
    public ResponseEntity findAll(){

        try{
            LOGGER.info(LogUtils.restMarker, "REST -   VentaController   - INPUT - findAll - Searching all");

            List all = core.findAll();

            LOGGER.info(LogUtils.restMarker, "REST -   VentaController   - OUTPUT - findAll - Returning all");
            return new ResponseEntity<>(all,HttpStatus.OK);

        }catch (RestException exception){
            return new ExceptionService().handleRestException(exception);
        }
    }

    @GetMapping("/venta/{id}")
    public ResponseEntity findById(@PathVariable Long id){

        try{
            LOGGER.info(LogUtils.restMarker, "REST -   VentaController   - INPUT - findById - Searching by id");

            Venta venta = core.findById(id);

            LOGGER.info(LogUtils.restMarker, "REST -   VentaController   - OUTPUT - findById - Returning venta by id");
            return new ResponseEntity<>(venta,HttpStatus.OK);
        }catch (RestException exception){
            return new ExceptionService().handleRestException(exception);
        }
    }

    @PostMapping("/venta/save")
    public ResponseEntity save(@RequestBody VentaModel model){

        try{
            Venta venta = new Venta();

            BeanUtils.copyProperties(model,venta);

            LOGGER.info(LogUtils.restMarker, "REST -   VentaController   - INPUT - save - Saving venta");
            Venta t = core.save(venta);

            if (t == null)
                return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);

            LOGGER.info(LogUtils.restMarker, "REST -   VentaController   - OUTPUT - save - Returning saved venta");

            return new ResponseEntity(t,HttpStatus.OK);
        }catch (RestException exception){
            return new ExceptionService().handleRestException(exception);
        }

    }
}
