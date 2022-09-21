package com.vipera.empresaer.dao.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class VentaProducto extends BaseEntity{
    @ManyToOne
    @JoinColumn(name = "venta_id")
    private Venta venta;
    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto;
    @Column
    private Integer cantidad;
    @Column
    private Double precio;

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
        return this.precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }
}
