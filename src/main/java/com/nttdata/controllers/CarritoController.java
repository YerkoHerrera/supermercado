package com.nttdata.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nttdata.models.Carrito;
import com.nttdata.models.Producto;
import com.nttdata.services.CarritoService;
import com.nttdata.services.ProductoService;
import com.nttdata.services.UsuarioService;
import com.nttdata.services.VentaService;

@Controller
@RequestMapping("/carrito")
public class CarritoController {
	
	//El carrito requiere de los servicios de usuario y productos
	@Autowired 
	UsuarioService usuarioService;
	
	@Autowired 
	ProductoService productoService;
	
	@Autowired 
	CarritoService carritoService;
	
	@Autowired 
	VentaService ventaService;
	
	@RequestMapping("")
	public String carrito(@ModelAttribute("carrito") Carrito carrito,
			Model model) {
		
		model.addAttribute("listaProductos", ventaService.obtenerListaCarrito(1L));
		
		return "carrito.jsp";
	}
	
	
	/*@RequestMapping("/agregar")
	public String agregarProducto(@RequestParam("id") Long id, Carrito carrito) {
		
		Producto producto = productoService.buscarProducto(id);
		if(producto != null) {
			Carrito carritoProducto = carritoService.agregarProductoCarrito(producto);
			
		}
		return "redirect:/producto";
	}*/
	
	@RequestMapping("/eliminar")
	public String eliminarProducto(@RequestParam("id") Long id) {
		
		Producto producto = productoService.buscarProducto(id);
		if(producto != null) {
			Carrito carrito = carritoService.eliminarProductoCarrito(producto);
			
		}
		return "redirect:/producto";
	}
	

}
