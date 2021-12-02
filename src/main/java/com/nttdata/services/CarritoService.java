package com.nttdata.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.models.Carrito;
import com.nttdata.models.Producto;
import com.nttdata.repositories.CarritoRepository;

@Service
public class CarritoService {
	@Autowired
	CarritoRepository carritoRepository;
	
public void insertarCarrito(@Valid Carrito carrito) {
		
		carritoRepository.save(carrito);
	}

	public Object obtenerListaCarritos() {
		
		return carritoRepository.findAll();
	}

	
	public Carrito buscarCarrito(Long id) {
		
		return carritoRepository.findById(id).get();
		
	}
	
	public void eliminarCarrito(Long id) {
		
		carritoRepository.deleteById(id);
		
	}

	public void eliminarCarritoObjeto(Carrito carrito) {
		carritoRepository.delete(carrito);
		
	}

	public void editarCarritoObjeto(Carrito carrito) {
		carritoRepository.save(carrito);
		
	}

	public void updateCarrito(@Valid Carrito carrito) {
		if(carritoRepository.existsById(carrito.getId())){
			carritoRepository.save(carrito);
		}	
	}

	public Carrito agregarProductoCarrito(@Valid Carrito carrito) {
		return carritoRepository.save(carrito);
		
	}
	
	public Carrito eliminarProductoCarrito(@Valid Producto producto) {
		return carritoRepository.eliminarProductoCarrito(producto);
	}

	public List<Producto> obtenerListaProductos(Long id) {
		return carritoRepository.obtenerListaProductos(id);
	}

}
