package com.vipera.empresaer.dao.repositories;

import com.vipera.empresaer.dao.models.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProveedorRepository extends JpaRepository<Proveedor,Long> {

    @Query("SELECT p2.nombre, sum(vp.precio*vp.cantidad) as Beneficio FROM VentaProducto vp" +
            "    INNER JOIN Producto p on vp.producto.id = p.id" +
            "    INNER JOIN Proveedor p2 on p.proveedor.id = p2.id" +
            "    GROUP BY p2.nombre ORDER BY Beneficio DESC")
    Optional<List<Object[]>> findAllByIngresos();
}
