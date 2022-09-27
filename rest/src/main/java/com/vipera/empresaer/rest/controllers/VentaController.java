package com.vipera.empresaer.rest.controllers;

import com.vipera.empresaer.core.components.venta.VentaCore;
import com.vipera.empresaer.core.exceptions.ExceptionService;
import com.vipera.empresaer.core.exceptions.types.RestException;
import com.vipera.empresaer.dao.models.Venta;
import com.vipera.empresaer.rest.converters.venta.VentaRequestToVentaConverter;
import com.vipera.empresaer.rest.converters.venta.VentaToVentaResponseConverter;
import com.vipera.empresaer.rest.requests.VentaRequest;
import com.vipera.empresaer.rest.responses.venta.VentaResponse;
import com.vipera.empresaer.rest.utils.logs.LogUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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

            List<Venta> all = core.findAll();

            LOGGER.info(LogUtils.restMarker, "REST -   VentaController   - OUTPUT - findAll - Returning all");

            List allResponse = new ArrayList<>();
            all.forEach(venta -> {
                allResponse.add(new VentaToVentaResponseConverter().convert(venta));
            });
            return new ResponseEntity<>(allResponse,HttpStatus.OK);
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

            VentaResponse ventaResponse = new VentaToVentaResponseConverter().convert(venta);

            return new ResponseEntity<>(ventaResponse,HttpStatus.OK);
        }catch (RestException exception){
            return new ExceptionService().handleRestException(exception);
        }
    }

    @PostMapping("/venta/save")
    public ResponseEntity save(@RequestBody VentaRequest model){

        try{
            Venta venta = new VentaRequestToVentaConverter().convert(model);

            LOGGER.info(LogUtils.restMarker, "REST -   VentaController   - INPUT - save - Saving venta");
            Venta ventaSaved = core.save(venta);

            if (ventaSaved == null)
                return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);

            LOGGER.info(LogUtils.restMarker, "REST -   VentaController   - OUTPUT - save - Returning saved venta");

            VentaResponse ventaResponse = new VentaToVentaResponseConverter().convert(ventaSaved);

            return new ResponseEntity(ventaResponse,HttpStatus.OK);
        }catch (RestException exception){
            return new ExceptionService().handleRestException(exception);
        }

    }
}
