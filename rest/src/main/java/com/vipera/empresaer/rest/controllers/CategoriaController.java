package com.vipera.empresaer.rest.controllers;

import com.vipera.empresaer.core.components.categoria.CategoriaCore;
import com.vipera.empresaer.core.exceptions.ExceptionService;
import com.vipera.empresaer.core.exceptions.types.RestException;
import com.vipera.empresaer.dao.models.Categoria;
import com.vipera.empresaer.rest.converters.categoria.CategoriaRequestToCategoriaConverter;
import com.vipera.empresaer.rest.converters.categoria.CategoriaToCategoriaResponseConverter;
import com.vipera.empresaer.rest.requests.CategoriaRequest;
import com.vipera.empresaer.rest.responses.categoria.CategoriaResponse;
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
public class CategoriaController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CategoriaController.class);

    @Autowired
    private CategoriaCore core;

    @GetMapping("/categoria/all")
    public ResponseEntity findAll(){

        try{
            LOGGER.info(LogUtils.restMarker, "REST -   CategoriaController   - INPUT - findAll - Searching all");

            List<Categoria> all = core.findAll();

            LOGGER.info(LogUtils.restMarker, "REST -   CategoriaController   - OUTPUT - findAll - Returning all");

            List<CategoriaResponse> allResponse = new ArrayList();
            all.forEach(categoria->{
                allResponse.add(new CategoriaToCategoriaResponseConverter().convert(categoria));
            });

            return new ResponseEntity<>(allResponse,HttpStatus.OK);
        }catch (RestException exception){
            return new ExceptionService().handleRestException(exception);
        }
    }

    @GetMapping("/categoria/{id}")
    public ResponseEntity findById(@PathVariable Long id){

        try{
            LOGGER.info(LogUtils.restMarker, "REST -   CategoriaController   - INPUT - findById - Searching by id");

            Categoria categoria = core.findById(id);

            LOGGER.info(LogUtils.restMarker, "REST -   CategoriaController   - OUTPUT - findById - Returning categoria by id");

            CategoriaResponse categoriaResponse = new CategoriaToCategoriaResponseConverter().convert(categoria);

            return new ResponseEntity<>(categoriaResponse,HttpStatus.OK);
        }catch (RestException exception){
            return new ExceptionService().handleRestException(exception);
        }
    }


    @PostMapping("/categoria/save")
    public ResponseEntity save(@RequestBody CategoriaRequest model){

        try{
            Categoria categoria = new CategoriaRequestToCategoriaConverter().convert(model);

            LOGGER.info(LogUtils.restMarker, "REST -   CategoriaController   - INPUT - save - Saving categoria");
            Categoria categoriaSaved = core.save(categoria);

            if (categoriaSaved == null)
                return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);

            LOGGER.info(LogUtils.restMarker, "REST -   CategoriaController   - OUTPUT - save - Returning saved categoria");

            CategoriaResponse categoriaResponse = new CategoriaToCategoriaResponseConverter().convert(categoriaSaved);

            return new ResponseEntity(categoriaResponse,HttpStatus.OK);
        }catch (RestException exception){
            return new ExceptionService().handleRestException(exception);
        }
    }
}
