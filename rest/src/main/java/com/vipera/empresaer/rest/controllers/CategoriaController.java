package com.vipera.empresaer.rest.controllers;

import com.vipera.empresaer.core.components.categoria.CategoriaCore;
import com.vipera.empresaer.dao.models.Categoria;
import com.vipera.empresaer.rest.models.CategoriaModel;
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
public class CategoriaController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CategoriaController.class);

    @Autowired
    private CategoriaCore core;

    @GetMapping("/categoria/all")
    public ResponseEntity findAll(){
        LOGGER.info(LogUtils.restMarker, "REST -   CategoriaController   - INPUT - findAll - Searching all");

        List all = core.findAll();

        LOGGER.info(LogUtils.restMarker, "REST -   CategoriaController   - OUTPUT - findAll - Returning all");
        return new ResponseEntity<>(all,HttpStatus.OK);
    }
    @PostMapping("/categoria/save")
    public ResponseEntity save(@RequestBody CategoriaModel model){
        Categoria categoria = new Categoria();

        BeanUtils.copyProperties(model,categoria);

        LOGGER.info(LogUtils.restMarker, "REST -   CategoriaController   - INPUT - save - Saving categoria");
        Categoria t = core.save(categoria);

        if (t == null)
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);

        LOGGER.info(LogUtils.restMarker, "REST -   CategoriaController   - OUTPUT - save - Returning saved categoria");

        return new ResponseEntity(t,HttpStatus.OK);
    }
}
