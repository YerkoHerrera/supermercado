package com.nttdata.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nttdata.models.Producto;
import com.nttdata.models.Venta;

@Repository 
public interface VentaRepository extends CrudRepository<Venta, Long> {
	List<Venta> findAll();
	
	@Query(value= "SELECT ventas.producto FROM ventas Where ventas.usuario.id = ?1", nativeQuery = true)
	List<Producto> obtenerListaCarrito(Long id);
}
