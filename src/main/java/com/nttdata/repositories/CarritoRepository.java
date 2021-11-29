package com.nttdata.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nttdata.models.Carrito;

@Repository 
public interface CarritoRepository extends JpaRepository<Carrito, Long> {
	
	Carrito eliminarProductoCarrito = null;
	Carrito agregarProductoCarrito = null;

	List<Carrito> findAll();
	
	
	
}
