package com.nttdata.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nttdata.models.Carrito;
import com.nttdata.models.Producto;
import com.nttdata.models.Usuario;
import com.nttdata.services.CarritoService;
import com.nttdata.services.ProductoService;
import com.nttdata.services.UsuarioService;

@Controller
@RequestMapping("/home")
public class HomeController {
	
	//Es importantisimo agregar los servicios de categoria para que se muestren en la vista
	@Autowired
	ProductoService productoService;
	
	@Autowired
	CarritoService carritoService;
	
	@Autowired
	UsuarioService usuarioService;
	
	@RequestMapping("")
	public String home(@ModelAttribute("producto") Producto producto,
			Model model) {
		model.addAttribute("listaProductos", productoService.obtenerListaProductos());
		return "home.jsp";
	}
	
	@RequestMapping("/agregar")
	public String agregarProducto(@RequestParam("id") Long id) {
		Producto producto = productoService.buscarProducto(id);
		Usuario usuario = usuarioService.buscarUsuario(1L);
		
		if(usuario.getCarrito() != null) {
			// Se agregar un objeto a la lista de productos del carrito de un usuario especifico
			usuario.getCarrito().getProductos().add(producto);
			// Le pasamos el carrito del usuario
			carritoService.agregarProductoCarrito(usuario.getCarrito());
			System.out.println("Se agrego un producto");
			return "/carrito.jsp";
		}else {
			// Si no tiene un carro se crea aqui
			Carrito carritoNuevo = new Carrito();
			carritoNuevo.setUsuario(usuario);
			usuario.setCarrito(carritoNuevo);
			carritoService.insertarCarrito(carritoNuevo);
			System.out.println("Se creo un carrito para el usuario");
		}
		
		return "redirect:/home";
	}

	@RequestMapping("/buscar")
	public String buscarProductos(@RequestParam("nombre") String nombre,
			Model model) {
		List <Producto> resultado = productoService.obtenerProductoBusqueda(nombre);
		if(resultado !=null) {
			model.addAttribute("listaProductos", productoService.obtenerProductoBusqueda(nombre));
			model.addAttribute("nombre", resultado);
			return "/homeBusqueda.jsp";
		}
		return "redirect:/home";
	}

}
