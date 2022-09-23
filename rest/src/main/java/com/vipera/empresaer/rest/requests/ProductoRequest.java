package com.vipera.empresaer.rest.requests;

public class ProductoRequest {

    private Long id;

    private String nombre;

    private Double precio;

    private Integer stock;

    private ProveedorRequest proveedor;

    private CategoriaRequest categoria;


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

    public ProveedorRequest getProveedor() {
        return proveedor;
    }

    public void setProveedor(ProveedorRequest proveedor) {
        this.proveedor = proveedor;
    }

    public CategoriaRequest getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaRequest categoria) {
        this.categoria = categoria;
    }
}
