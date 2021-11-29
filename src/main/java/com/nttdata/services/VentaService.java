package com.nttdata.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.models.Producto;
import com.nttdata.models.Venta;
import com.nttdata.repositories.ProductoRepository;
import com.nttdata.repositories.VentaRepository;

@Service
public class VentaService {
	@Autowired
	VentaRepository ventaRepository;
	
	@Autowired
	ProductoRepository productoRepository;

	public void insertarVenta(@Valid Venta venta) {
		
		ventaRepository.save(venta);
	}

	public Object obtenerListaVentas() {
		
		return ventaRepository.findAll();
	}

	
	public Venta buscarVenta(Long id) {
		
		return ventaRepository.findById(id).get();
		
	}
	
	public void eliminarVenta(Long id) {
		
		ventaRepository.deleteById(id);
		
	}

	public void eliminarVentaObjeto(Venta venta) {
		ventaRepository.delete(venta);
		
	}

	public void editarVentaObjeto(Venta venta) {
		ventaRepository.save(venta);
		
	}

	public void updateVenta(@Valid Venta venta) {
		if(ventaRepository.existsById(venta.getId())){
			ventaRepository.save(venta);
		}	
	}
	
	public List<Producto> obtenerListaCarrito(Long id){
		return ventaRepository.obtenerListaCarrito(id);
	}
}
