package com.vipera.empresaer.rest.responses.cliente;

public class ClienteMediaGastosResponse {

    private String nombre;
    private Double mediaGastos;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getMediaGastos() {
        return mediaGastos;
    }

    public void setMediaGastos(Double mediaGastos) {
        this.mediaGastos = mediaGastos;
    }
}
