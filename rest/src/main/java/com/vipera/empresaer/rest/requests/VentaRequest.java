package com.vipera.empresaer.rest.requests;

public class VentaRequest {

    private Long id;

    //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private String fecha;

    private Double descuento;

    private ClienteRequest cliente;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Double getDescuento() {
        return descuento;
    }

    public void setDescuento(Double descuento) {
        this.descuento = descuento;
    }


    public ClienteRequest getCliente() {
        return cliente;
    }

    public void setCliente(ClienteRequest cliente) {
        this.cliente = cliente;
    }
}
