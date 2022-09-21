package com.vipera.empresaer.dao.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

@Entity
public class Venta extends BaseEntity{
    @Column
    private Date fecha;
    @Column
    private Double descuento;
    @Column
    private Double precioFinal;
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @OneToMany(mappedBy = "venta")
    private Set<VentaProducto> ventas;

    @JsonIgnore
    public Set<VentaProducto> getVentas() {
        return ventas;
    }

    public void setVentas(Set<VentaProducto> ventas) {
        this.ventas = ventas;
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
        if(ventas == null) return null;
        Double precio = 0.0;
        Iterator<VentaProducto> it = ventas.iterator();
        VentaProducto venta;
        while(it.hasNext()){
            venta=it.next();
            precio+=venta.getPrecio()*venta.getCantidad();
        }

        return (double) Math.round(precio * (1-descuento) * 100)/100;
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
}
