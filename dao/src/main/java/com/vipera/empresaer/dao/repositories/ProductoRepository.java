package com.vipera.empresaer.dao.repositories;

import com.vipera.empresaer.dao.models.Categoria;
import com.vipera.empresaer.dao.models.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductoRepository extends JpaRepository<Producto,Long> {


    @Query("SELECT p FROM Producto p WHERE p.categoria.id = ?1 ")
    Optional<List<Producto>> findAllByCategoriaId(Long categoria);

    @Query("SELECT p.precio as PrecioActual, v.precio as PrecioCompra, p.stock,v.cantidad, p.nombre, p.categoria.nombre FROM Producto p INNER JOIN VentaProducto v on p.id = v.producto.id")
    Optional<List<Object[]>> findAllPreciosComparison();

}
