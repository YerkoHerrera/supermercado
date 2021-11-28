package com.nttdata.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.nttdata.models.Producto;


public interface ProductoRepository extends CrudRepository<Producto, Long> {
	List<Producto> findAll();
}
