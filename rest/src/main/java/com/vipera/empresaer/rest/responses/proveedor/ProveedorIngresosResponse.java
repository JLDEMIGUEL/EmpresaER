package com.vipera.empresaer.rest.responses.proveedor;

public class ProveedorIngresosResponse {

    private String nombre;
    private Double ingresos;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getIngresos() {
        return ingresos;
    }

    public void setIngresos(Double ingresos) {
        this.ingresos = ingresos;
    }
}
