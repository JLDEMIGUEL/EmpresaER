package com.vipera.empresaer.dao.repositories;

import com.vipera.empresaer.dao.models.VentaProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VentaProductoRepository extends JpaRepository<VentaProducto,Long> {
}
