package com.vipera.empresaer.rest.controllers;

import com.vipera.empresaer.core.components.proveedor.ProveedorCore;
import com.vipera.empresaer.core.exceptions.ExceptionService;
import com.vipera.empresaer.core.exceptions.types.RestException;
import com.vipera.empresaer.dao.models.Proveedor;
import com.vipera.empresaer.rest.converters.proveedor.MapToProveedorIngresosConverter;
import com.vipera.empresaer.rest.converters.proveedor.ProveedorRequestToProveedorConverter;
import com.vipera.empresaer.rest.converters.proveedor.ProveedorToProveedorResponseConverter;
import com.vipera.empresaer.rest.requests.ProveedorRequest;
import com.vipera.empresaer.rest.responses.proveedor.ProveedorIngresosResponse;
import com.vipera.empresaer.rest.responses.proveedor.ProveedorResponse;
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
public class ProveedorController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProveedorController.class);
    @Autowired
    private ProveedorCore core;

    @GetMapping("/proveedor/all")
    public ResponseEntity findAll(){

        try{
            LOGGER.info(LogUtils.restMarker, "REST -   ProveedorController   - INPUT - findAll - Searching all");

            List<Proveedor> all = core.findAll();

            LOGGER.info(LogUtils.restMarker, "REST -   ProveedorController   - OUTPUT - findAll - Returning all");

            List allResponse = new ArrayList<>();
            all.forEach(proveedor -> {
                allResponse.add(new ProveedorToProveedorResponseConverter().convert(proveedor));
            });
            return new ResponseEntity<>(allResponse,HttpStatus.OK);
        }catch (RestException exception){
            return new ExceptionService().handleRestException(exception);
        }
    }

    @PostMapping("/proveedor/save")
    public ResponseEntity save(@RequestBody ProveedorRequest model){

        try{
            Proveedor proveedor = new ProveedorRequestToProveedorConverter().convert(model);

            LOGGER.info(LogUtils.restMarker, "REST -   ProveedorController   - INPUT - save - Saving proveedor");
            Proveedor proveedorSaved = core.save(proveedor);

            if (proveedorSaved == null)
                return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);

            LOGGER.info(LogUtils.restMarker, "REST -   ProveedorController   - OUTPUT - save - Returning saved proveedor");

            ProveedorResponse proveedorResponse = new ProveedorToProveedorResponseConverter().convert(proveedorSaved);

            return new ResponseEntity(proveedorResponse,HttpStatus.OK);
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

            ProveedorResponse proveedorResponse = new ProveedorToProveedorResponseConverter().convert(proveedor);

            return new ResponseEntity(proveedorResponse,HttpStatus.OK);
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

            List<ProveedorIngresosResponse> responseList = new ArrayList<>();
            list.forEach(map -> responseList.add(new MapToProveedorIngresosConverter().convert(map)));

            return new ResponseEntity(responseList,HttpStatus.OK);

        }catch (RestException exception){
            return new ExceptionService().handleRestException(exception);
        }
    }
}
