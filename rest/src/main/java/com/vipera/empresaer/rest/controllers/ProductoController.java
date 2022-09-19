package com.vipera.empresaer.rest.controllers;

import com.vipera.empresaer.core.components.producto.ProductoCore;
import com.vipera.empresaer.dao.models.Producto;
import com.vipera.empresaer.rest.models.ProductoModel;
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
public class ProductoController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductoController.class);

    @Autowired
    private ProductoCore core;

    @GetMapping("/producto/all")
    public ResponseEntity findAll(){
        LOGGER.info(LogUtils.restMarker, "REST -   ProductoController   - INPUT - findAll - Searching all");

        List all = core.findAll();

        LOGGER.info(LogUtils.restMarker, "REST -   ProductoController   - OUTPUT - findAll - Returning all");
        return new ResponseEntity<>(all,HttpStatus.OK);
    }

    @GetMapping("/producto/all/categoria/{categoriaId}")
    public ResponseEntity findAllByCategoriaId(@PathVariable String categoriaId){
        LOGGER.info(LogUtils.restMarker, "REST -   ProductoController   - INPUT - findAllByCategoriaId - Searching all products of category :"+categoriaId);

        List all = core.findAllByCategoriaId(categoriaId);

        if(all == null){
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }

        LOGGER.info(LogUtils.restMarker, "REST -   ProductoController   - OUTPUT - findAllByCategoriaId - Returning products of category :"+categoriaId);
        return new ResponseEntity<>(all,HttpStatus.OK);
    }

    @GetMapping("/producto/all/precios")
    public ResponseEntity findAllPreciosComparison(){
        LOGGER.info(LogUtils.restMarker, "REST -   ProductoController   - INPUT - findAllPreciosComparison - Searching prices comparison");

        List<Map<String, Object>> all = core.findAllPreciosComparison();

        if(all == null){
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }

        LOGGER.info(LogUtils.restMarker, "REST -   ProductoController   - OUTPUT - findAllPreciosComparison - Returning prices comparison");
        return new ResponseEntity<>(all,HttpStatus.OK);
    }

    @PostMapping("/producto/save")
    public ResponseEntity save(@RequestBody ProductoModel model){
        Producto producto = new Producto();

        BeanUtils.copyProperties(model,producto);

        LOGGER.info(LogUtils.restMarker, "REST -   ProductoController   - INPUT - save - Saving producto");
        Producto t = core.save(producto);

        if (t == null)
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);

        LOGGER.info(LogUtils.restMarker, "REST -   ProductoController   - OUTPUT - save - Returning saved producto");

        return new ResponseEntity(t,HttpStatus.OK);
    }


}
