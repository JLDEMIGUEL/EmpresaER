package com.vipera.empresaer.rest.controllers;

import com.vipera.empresaer.core.components.producto.ProductoCore;
import com.vipera.empresaer.core.exceptions.ExceptionService;
import com.vipera.empresaer.core.exceptions.types.RestException;
import com.vipera.empresaer.dao.models.Producto;
import com.vipera.empresaer.rest.converters.producto.MapToPreciosCompConverter;
import com.vipera.empresaer.rest.converters.producto.ProductoRequestToProductoConverter;
import com.vipera.empresaer.rest.converters.producto.ProductoToProductoResponseConverter;
import com.vipera.empresaer.rest.requests.ProductoRequest;
import com.vipera.empresaer.rest.responses.producto.ProductoPreciosCompResponse;
import com.vipera.empresaer.rest.responses.producto.ProductoResponse;
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
public class ProductoController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductoController.class);

    @Autowired
    private ProductoCore core;

    @GetMapping("/producto/{id}")
    public ResponseEntity findById(@PathVariable Long id){

        try{
            LOGGER.info(LogUtils.restMarker, "REST -   ProductoController   - INPUT - findById - Searching by id");

            Producto producto = core.findById(id);

            LOGGER.info(LogUtils.restMarker, "REST -   ProductoController   - OUTPUT - findById - Returning producto by id");

            ProductoResponse productoResponse = new ProductoToProductoResponseConverter().convert(producto);

            return new ResponseEntity<>(productoResponse,HttpStatus.OK);
        }catch (RestException exception){
            return new ExceptionService().handleRestException(exception);
        }
    }

    @GetMapping("/producto/all")
    public ResponseEntity findAll(){

        try{
            LOGGER.info(LogUtils.restMarker, "REST -   ProductoController   - INPUT - findAll - Searching all");

            List<Producto> all = core.findAll();

            LOGGER.info(LogUtils.restMarker, "REST -   ProductoController   - OUTPUT - findAll - Returning all");

            List allResponse = new ArrayList<>();
            all.forEach(producto -> {
                allResponse.add(new ProductoToProductoResponseConverter().convert(producto));
            });

            return new ResponseEntity<>(allResponse,HttpStatus.OK);
        }catch (RestException exception){
            return new ExceptionService().handleRestException(exception);
        }
    }

    @GetMapping("/producto/all/categoria/{categoriaId}")
    public ResponseEntity findAllByCategoriaId(@PathVariable Long categoriaId){

        try{
            LOGGER.info(LogUtils.restMarker, "REST -   ProductoController   - INPUT - findAllByCategoriaId - Searching all products of category :"+categoriaId);

            List<Producto> all = core.findAllByCategoriaId(categoriaId);

            if(all == null){
                return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
            }

            LOGGER.info(LogUtils.restMarker, "REST -   ProductoController   - OUTPUT - findAllByCategoriaId - Returning products of category :"+categoriaId);

            List allResponse = new ArrayList<>();
            all.forEach(producto -> {
                allResponse.add(new ProductoToProductoResponseConverter().convert(producto));
            });

            return new ResponseEntity<>(allResponse,HttpStatus.OK);
        }catch (RestException exception){
            return new ExceptionService().handleRestException(exception);
        }
    }

    @GetMapping("/producto/all/precios")
    public ResponseEntity findAllPreciosComparison(){

        try{
            LOGGER.info(LogUtils.restMarker, "REST -   ProductoController   - INPUT - findAllPreciosComparison - Searching prices comparison");

            List<Map<String, Object>> all = core.findAllPreciosComparison();

            if(all == null){
                return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
            }

            LOGGER.info(LogUtils.restMarker, "REST -   ProductoController   - OUTPUT - findAllPreciosComparison - Returning prices comparison");

            List<ProductoPreciosCompResponse> responseList = new ArrayList<>();
            all.forEach(map -> responseList.add(new MapToPreciosCompConverter().convert(map)));

            return new ResponseEntity<>(responseList,HttpStatus.OK);
        }catch (RestException exception){
            return new ExceptionService().handleRestException(exception);
        }
    }


    @PostMapping("/producto/save")
    public ResponseEntity save(@RequestBody ProductoRequest model){

        try{
            Producto producto = new ProductoRequestToProductoConverter().convert(model);

            LOGGER.info(LogUtils.restMarker, "REST -   ProductoController   - INPUT - save - Saving producto");
            Producto productoSaved = core.save(producto);

            if (productoSaved == null)
                return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);

            LOGGER.info(LogUtils.restMarker, "REST -   ProductoController   - OUTPUT - save - Returning saved producto");

            ProductoResponse productoResponse = new ProductoToProductoResponseConverter().convert(productoSaved);

            return new ResponseEntity(productoResponse,HttpStatus.OK);
        }catch (RestException exception){
            return new ExceptionService().handleRestException(exception);
        }
    }


}
