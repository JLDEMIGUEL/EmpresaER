package com.vipera.empresaer.dao.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.Set;


@Entity
public class Cliente extends  NamedEntity{

    @OneToOne
    private Direccion direccion;
    @Column
    private String telefono;

    @OneToMany(mappedBy = "cliente")
    private Set<Venta> compras;

    @JsonIgnore
    public Set<Venta> getCompras() {
        return compras;
    }

    public void setCompras(Set<Venta> ventas) {
        this.compras = ventas;
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
}
