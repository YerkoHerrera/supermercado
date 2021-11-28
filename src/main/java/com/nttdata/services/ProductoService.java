package com.nttdata.services;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.models.Producto;
import com.nttdata.repositories.ProductoRepository;

@Service
public class ProductoService {
	@Autowired
	ProductoRepository productoRepository;

	public void insertarProducto(@Valid Producto producto) {
		
		productoRepository.save(producto);
	}

	public Object obtenerListaProductos() {
		
		return productoRepository.findAll();
	}

	
	public Producto buscarProducto(Long id) {
		
		return productoRepository.findById(id).get();
		
	}
	
	public void eliminarProducto(Long id) {
		
		productoRepository.deleteById(id);
		
	}

	public void eliminarProductoObjeto(Producto producto) {
		productoRepository.delete(producto);
		
	}

	public void editarProductoObjeto(Producto producto) {
		productoRepository.save(producto);
		
	}

	public void updateProducto(@Valid Producto producto) {
		if(productoRepository.existsById(producto.getId())){
			productoRepository.save(producto);
		}	
	}
}
