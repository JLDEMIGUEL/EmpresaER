package com.vipera.empresaer.dao.models;


import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Direccion extends BaseEntity{
    @Column
    private String calle;
    @Column
    private Integer numero;
    @Column
    private String comuna;
    @Column
    private String ciudad;

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getComuna() {
        return comuna;
    }

    public void setComuna(String comuna) {
        this.comuna = comuna;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
}
