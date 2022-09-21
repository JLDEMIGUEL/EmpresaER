package com.vipera.empresaer.rest.requests;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.vipera.empresaer.dao.models.Cliente;
import com.vipera.empresaer.dao.models.VentaProducto;

import java.util.Date;
import java.util.Set;

public class VentaRequest {

    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date fecha;

    private Double descuento;

    private Double precioFinal;

    private Cliente cliente;

    private Set<VentaProducto> ventas;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Double getDescuento() {
        return descuento;
    }

    public void setDescuento(Double descuento) {
        this.descuento = descuento;
    }

    public Double getPrecioFinal() {
        return precioFinal;
    }

    public void setPrecioFinal(Double precioFinal) {
        this.precioFinal = precioFinal;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Set<VentaProducto> getVentas() {
        return ventas;
    }

    public void setVentas(Set<VentaProducto> ventas) {
        this.ventas = ventas;
    }
}
