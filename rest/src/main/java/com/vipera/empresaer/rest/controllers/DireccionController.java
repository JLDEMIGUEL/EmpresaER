package com.vipera.empresaer.rest.controllers;


import com.vipera.empresaer.core.components.direccion.DireccionCore;
import com.vipera.empresaer.core.exceptions.ExceptionService;
import com.vipera.empresaer.core.exceptions.types.RestException;
import com.vipera.empresaer.dao.models.Direccion;
import com.vipera.empresaer.rest.converters.direccion.DireccionRequestToDireccionConverter;
import com.vipera.empresaer.rest.converters.direccion.DireccionToDireccionResponseConverter;
import com.vipera.empresaer.rest.requests.DireccionRequest;
import com.vipera.empresaer.rest.responses.direccion.DireccionResponse;
import com.vipera.empresaer.rest.utils.LogUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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

            List<Direccion> all = core.findAll();

            LOGGER.info(LogUtils.restMarker, "REST -   DireccionController   - OUTPUT - findAll - Returning all");


            List allResponse = new ArrayList<>();
            all.forEach(direccion -> {
                allResponse.add(new DireccionToDireccionResponseConverter().convert(direccion));
            });

            return new ResponseEntity<>(allResponse,HttpStatus.OK);

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

            DireccionResponse direccionResponse = new DireccionToDireccionResponseConverter().convert(direccion);
            return new ResponseEntity<>(direccionResponse,HttpStatus.OK);
        }catch (RestException exception){
            return new ExceptionService().handleRestException(exception);
        }
    }

    @PostMapping("/direccion/save")
    public ResponseEntity save(@RequestBody DireccionRequest model){


        try{
            Direccion direccion = new DireccionRequestToDireccionConverter().convert(model);

            LOGGER.info(LogUtils.restMarker, "REST -   DireccionController   - INPUT - save - Saving direccion");
            Direccion direccionSaved= core.save(direccion);

            if (direccionSaved == null)
                return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);

            LOGGER.info(LogUtils.restMarker, "REST -   DireccionController   - OUTPUT - save - Returning saved direccion");

            DireccionResponse direccionResponse = new DireccionToDireccionResponseConverter().convert(direccionSaved);
            return new ResponseEntity<>(direccionResponse,HttpStatus.OK);
        }catch (RestException exception){
            return new ExceptionService().handleRestException(exception);
        }
    }
}
