package com.vipera.empresaer.rest.controllers;


import com.vipera.empresaer.core.components.ventaproducto.VentaProductoCore;
import com.vipera.empresaer.core.exceptions.ExceptionService;
import com.vipera.empresaer.core.exceptions.types.RestException;
import com.vipera.empresaer.dao.models.VentaProducto;
import com.vipera.empresaer.rest.converters.ventaProducto.VentaProductoRequestToVentaProductoConverter;
import com.vipera.empresaer.rest.converters.ventaProducto.VentaProductoToVentaProductoResponseConverter;
import com.vipera.empresaer.rest.requests.VentaProductoRequest;
import com.vipera.empresaer.rest.responses.ventaproducto.VentaProductoResponse;
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
public class VentaProductoController {

    private static final Logger LOGGER = LoggerFactory.getLogger(VentaProductoController.class);
    @Autowired
    private VentaProductoCore core;

    @GetMapping("/ventaproducto/all")
    public ResponseEntity findAll(){

        try{
            LOGGER.info(LogUtils.restMarker, "REST -   VentaProductoController   - INPUT - findAll - Searching all");

            List<VentaProducto> all = core.findAll();

            LOGGER.info(LogUtils.restMarker, "REST -   VentaProductoController   - OUTPUT - findAll - Returning all");

            List allResponse = new ArrayList<>();
            all.forEach(ventaProducto -> {
                allResponse.add(new VentaProductoToVentaProductoResponseConverter().convert(ventaProducto));
            });
            return new ResponseEntity<>(allResponse,HttpStatus.OK);
        }catch (RestException exception){
            return new ExceptionService().handleRestException(exception);
        }
    }

    @GetMapping("/ventaproducto/{id}")
    public ResponseEntity findById(@PathVariable Long id){

        try{
            LOGGER.info(LogUtils.restMarker, "REST -   VentaProductoController   - INPUT - findById - Searching by id");

            VentaProducto ventaProducto = core.findById(id);

            LOGGER.info(LogUtils.restMarker, "REST -   VentaProductoController   - OUTPUT - findById - Returning ventaProducto by id");

            VentaProductoResponse ventaProductoResponse = new VentaProductoToVentaProductoResponseConverter().convert(ventaProducto);
            return new ResponseEntity<>(ventaProductoResponse,HttpStatus.OK);
        }catch (RestException exception){
            return new ExceptionService().handleRestException(exception);
        }
    }
    @PostMapping("/ventaproducto/save")
    public ResponseEntity save(@RequestBody VentaProductoRequest model){

        try{
            VentaProducto ventaProducto = new VentaProductoRequestToVentaProductoConverter().convert(model);

            LOGGER.info(LogUtils.restMarker, "REST -   VentaProductoController   - INPUT - save - Saving ventaProducto");

            VentaProducto ventaProductoSaved = core.save(ventaProducto);

            if (ventaProductoSaved == null)
                return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);

            LOGGER.info(LogUtils.restMarker, "REST -   VentaProductoController   - OUTPUT - save - Returning saved ventaProducto");

            VentaProductoResponse ventaProductoResponse = new VentaProductoToVentaProductoResponseConverter().convert(ventaProductoSaved);

            return new ResponseEntity(ventaProductoResponse,HttpStatus.OK);
        }catch (RestException exception){
            return new ExceptionService().handleRestException(exception);
        }
    }
}
