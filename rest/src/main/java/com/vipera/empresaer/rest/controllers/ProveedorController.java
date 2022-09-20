package com.vipera.empresaer.rest.controllers;

import com.vipera.empresaer.core.components.proveedor.ProveedorCore;
import com.vipera.empresaer.core.exceptions.ExceptionService;
import com.vipera.empresaer.core.exceptions.types.RestException;
import com.vipera.empresaer.dao.models.Proveedor;
import com.vipera.empresaer.rest.models.ProveedorModel;
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
public class ProveedorController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProveedorController.class);
    @Autowired
    private ProveedorCore core;

    @GetMapping("/proveedor/all")
    public ResponseEntity findAll(){

        try{
            LOGGER.info(LogUtils.restMarker, "REST -   ProveedorController   - INPUT - findAll - Searching all");

            List all = core.findAll();

            LOGGER.info(LogUtils.restMarker, "REST -   ProveedorController   - OUTPUT - findAll - Returning all");
            return new ResponseEntity<>(all,HttpStatus.OK);
        }catch (RestException exception){
            return new ExceptionService().handleRestException(exception);
        }
    }

    @PostMapping("/proveedor/save")
    public ResponseEntity save(@RequestBody ProveedorModel model){

        try{
            Proveedor proveedor = new Proveedor();

            BeanUtils.copyProperties(model,proveedor);

            LOGGER.info(LogUtils.restMarker, "REST -   ProveedorController   - INPUT - save - Saving proveedor");
            Proveedor t = core.save(proveedor);

            if (t == null)
                return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);

            LOGGER.info(LogUtils.restMarker, "REST -   ProveedorController   - OUTPUT - save - Returning saved proveedor");

            return new ResponseEntity(t,HttpStatus.OK);
        }catch (RestException exception){
            return new ExceptionService().handleRestException(exception);
        }
    }

    @GetMapping("/proveedor/{id}")
    public ResponseEntity findById(@PathVariable Long id){

        try{
            LOGGER.info(LogUtils.restMarker, "REST -   ProveedorController   - INPUT - findById - Searching by id");

            Proveedor proveedor = core.findById(id);

            LOGGER.info(LogUtils.restMarker, "REST -   ProveedorController   - OUTPUT - findById - Returning proveedor by id");
            return new ResponseEntity<>(proveedor,HttpStatus.OK);
        }catch (RestException exception){
            return new ExceptionService().handleRestException(exception);
        }
    }


    @GetMapping("/proveedor/ingresos")
    public ResponseEntity findAllByIngresos(){

        try{
            LOGGER.info(LogUtils.restMarker, "REST -   ProveedorController   - INPUT - findAllByIngresos - Searching all by Ingresos");

            List<Map<String, Object>> list = core.findAllByIngresos();
            if (list == null)
                return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);


            LOGGER.info(LogUtils.restMarker, "REST -   ProveedorController   - OUTPUT - findAllByIngresos - Returning all by Ingresos");
            return new ResponseEntity(list,HttpStatus.OK);

        }catch (RestException exception){
            return new ExceptionService().handleRestException(exception);
        }
    }
}
