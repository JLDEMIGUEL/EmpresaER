package com.vipera.empresaer.rest.models;

import com.vipera.empresaer.dao.models.Categoria;
import com.vipera.empresaer.dao.models.Proveedor;
import com.vipera.empresaer.dao.models.VentaProducto;

import java.util.Set;

public class ProductoModel {

    private Long id;

    private String nombre;

    private Double precio;

    private Integer stock;

    private Proveedor proveedor;

    private Categoria categoria;

    private Set<VentaProducto> ventas;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Set<VentaProducto> getVentas() {
        return ventas;
    }

    public void setVentas(Set<VentaProducto> ventas) {
        this.ventas = ventas;
    }
}
