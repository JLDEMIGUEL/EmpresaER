package com.vipera.empresaer.rest.requests;

public class VentaProductoRequest {

    private Long id;

    private VentaRequest venta;

    private ProductoRequest producto;

    private Integer cantidad;

    private Double precio;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public VentaRequest getVenta() {
        return venta;
    }

    public void setVenta(VentaRequest venta) {
        this.venta = venta;
    }

    public ProductoRequest getProducto() {
        return producto;
    }

    public void setProducto(ProductoRequest producto) {
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
