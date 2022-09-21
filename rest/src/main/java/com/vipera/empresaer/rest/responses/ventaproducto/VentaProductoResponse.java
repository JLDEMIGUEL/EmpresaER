package com.vipera.empresaer.rest.responses.ventaproducto;

import com.vipera.empresaer.dao.models.Producto;
import com.vipera.empresaer.dao.models.Venta;

public class VentaProductoResponse {

    private Long id;

    private Venta venta;

    private Producto producto;

    private Integer cantidad;

    private Double precio;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }
}
