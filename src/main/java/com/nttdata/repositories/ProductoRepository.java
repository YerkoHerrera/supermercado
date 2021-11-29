package com.nttdata.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nttdata.models.Producto;

@Repository 
public interface ProductoRepository extends CrudRepository<Producto, Long> {
	List<Producto> findAll();
	
	@Query("SELECT p FROM Producto p Where nombre = ?1")
	List<Producto> obtenerProductoBusqueda(String busqueda);
}
