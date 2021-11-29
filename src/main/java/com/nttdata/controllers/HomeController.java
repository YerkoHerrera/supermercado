package com.nttdata.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nttdata.models.Producto;
import com.nttdata.services.CarritoService;
import com.nttdata.services.ProductoService;

@Controller
@RequestMapping("/home")
public class HomeController {
	
	//Es importantisimo agregar los servicios de categoria para que se muestren en la vista
	@Autowired
	ProductoService productoService;
	
	@Autowired
	CarritoService carritoService;
	
	@RequestMapping("")
	public String home(@ModelAttribute("producto") Producto producto,
			Model model) {
		model.addAttribute("listaProductos", productoService.obtenerListaProductos());
		return "home.jsp";
	}
	
	@RequestMapping("/agregar")
	public String agregarProducto(@Valid @ModelAttribute("producto") Producto producto) {
		carritoService.insertarProductoCarrito(producto);
		return "redirect:/home";
	}
	
	@RequestMapping("/buscar")
	public String buscarProductos(@PathVariable("busqueda") String busqueda,
			Model model) {
		List <Producto> resultado = productoService.obtenerProductoBusqueda(busqueda);
		if(resultado !=null) {
			model.addAttribute("listaProductos", resultado);
			return "/carrito.jsp";
		}
		return "redirect:/home";
	}
	
	

}
