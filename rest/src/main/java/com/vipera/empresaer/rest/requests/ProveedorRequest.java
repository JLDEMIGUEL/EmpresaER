package com.vipera.empresaer.rest.requests;

public class ProveedorRequest {

    private Long id;

    private String nombre;

    private String web;

    private String telefono;

    private DireccionRequest direccion;

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

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public DireccionRequest getDireccion() {
        return direccion;
    }

    public void setDireccion(DireccionRequest direccion) {
        this.direccion = direccion;
    }
}
