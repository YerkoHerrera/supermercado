package com.nttdata.repositories;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nttdata.models.Carrito;
import com.nttdata.models.Producto;

@Repository 
public interface CarritoRepository extends JpaRepository<Carrito, Long> {


	List<Carrito> findAll();
	
	@Query(value= "DELETE carritos.producto FROM carritos Where carritos.producto = ?1", nativeQuery = true)
	Carrito eliminarProductoCarrito(@Valid Producto producto);

	@Query(value= "SELECT carrito. FROM ventas Where producto_id = ?1", nativeQuery = true)
	List<Producto> obtenerListaProductos(Long id);
	
	
	
}
