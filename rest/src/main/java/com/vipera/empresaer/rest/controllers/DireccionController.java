package com.vipera.empresaer.rest.controllers;


import com.vipera.empresaer.core.components.direccion.DireccionCore;
import com.vipera.empresaer.core.exceptions.ExceptionService;
import com.vipera.empresaer.core.exceptions.types.RestException;
import com.vipera.empresaer.dao.models.Direccion;
import com.vipera.empresaer.rest.models.DireccionModel;
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
public class DireccionController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DireccionController.class);

    @Autowired
    private DireccionCore core;

    @GetMapping("/direccion/all")
    public ResponseEntity findAll(){

        try{
            LOGGER.info(LogUtils.restMarker, "REST -   DireccionController   - INPUT - findAll - Searching all");

            List all = core.findAll();

            LOGGER.info(LogUtils.restMarker, "REST -   DireccionController   - OUTPUT - findAll - Returning all");
            return new ResponseEntity<>(all,HttpStatus.OK);

        }catch (RestException exception){
            return new ExceptionService().handleRestException(exception);
        }
    }

    @GetMapping("/direccion/{id}")
    public ResponseEntity findById(@PathVariable Long id){

        try{
            LOGGER.info(LogUtils.restMarker, "REST -   DireccionController   - INPUT - findById - Searching by id");

            Direccion direccion = core.findById(id);

            LOGGER.info(LogUtils.restMarker, "REST -   DireccionController   - OUTPUT - findById - Returning direccion by id");
            return new ResponseEntity<>(direccion,HttpStatus.OK);
        }catch (RestException exception){
            return new ExceptionService().handleRestException(exception);
        }
    }

    @PostMapping("/direccion/save")
    public ResponseEntity save(@RequestBody DireccionModel model){


        try{
            Direccion direccion = new Direccion();

            BeanUtils.copyProperties(model,direccion);

            LOGGER.info(LogUtils.restMarker, "REST -   DireccionController   - INPUT - save - Saving direccion");
            Direccion t = core.save(direccion);

            if (t == null)
                return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);

            LOGGER.info(LogUtils.restMarker, "REST -   DireccionController   - OUTPUT - save - Returning saved direccion");

            return new ResponseEntity(t,HttpStatus.OK);
        }catch (RestException exception){
            return new ExceptionService().handleRestException(exception);
        }
    }
}
