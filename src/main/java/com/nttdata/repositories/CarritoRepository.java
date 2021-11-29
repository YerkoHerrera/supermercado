package com.nttdata.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nttdata.models.Carrito;

@Repository 
public interface CarritoRepository extends CrudRepository<Carrito, Long> {
	List<Carrito> findAll();
}
