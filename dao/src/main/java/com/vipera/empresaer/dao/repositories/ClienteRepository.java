package com.vipera.empresaer.dao.repositories;

import com.vipera.empresaer.dao.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Long> {


    @Query("select p.nombre, vp.precio, vp.cantidad,v.fecha from Producto p, VentaProducto vp, Venta v " +
            "WHERE vp.producto.id = p.id AND vp.venta.id = v.id AND v.cliente.id = ?1")
    Optional<List<Object[]>> findHistorial(Long id);


    @Query("SELECT c.nombre, avg(vp.precio*vp.cantidad) as MediaGastos From VentaProducto vp " +
            "INNER JOIN Venta v on vp.venta.id = v.id " +
            "INNER JOIN Cliente c on v.cliente.id = c.id " +
            "GROUP BY c.id ORDER BY MediaGastos DESC")
    Optional<List<Object[]>> findMediaGastos();
}
