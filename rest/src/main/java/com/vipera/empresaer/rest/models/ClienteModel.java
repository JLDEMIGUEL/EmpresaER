package com.vipera.empresaer.rest.models;

import com.vipera.empresaer.dao.models.Direccion;
import com.vipera.empresaer.dao.models.Venta;

import java.util.Set;

public class ClienteModel {

    private Long id;

    private String nombre;

    private Direccion direccion;

    private String telefono;

    private Set<Venta> ventas;

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

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Set<Venta> getVentas() {
        return ventas;
    }

    public void setVentas(Set<Venta> ventas) {
        this.ventas = ventas;
    }
}
