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
	public String agregarProducto(@RequestParam("id") Long id, Model model) {
		
		//Primero busca el producto agregado
		Producto producto = productoService.buscarProducto(id);
		
		/*
		 	Busca el usuario que ha iniciado sesion (Por ahora es temporal)
			Lo ideal es que se ingrese con una sesion que se mantenga activa y
			llamarla desde aqui.
		*/
		Usuario usuario = usuarioService.buscarUsuario(1L);
		
		if(usuario.getCarrito() == null) {
			
			// Si no tiene un carrito se crea aqui
			Carrito carritoNuevo = new Carrito();
			carritoNuevo.setUsuario(usuario);
			carritoService.insertarCarrito(carritoNuevo);	
			usuario.setCarrito(carritoNuevo);
			System.out.println("Se creo un carrito para el usuario");
			
			//Luego de crearse se incluye el producto
			carritoService.agregarProductoCarrito(usuario.getCarrito());	
			System.out.println("Se agrego un producto");
			/*
		 	Busca el carrito (Por ahora es temporal)
			Lo ideal es que se ingrese con una sesion que se mantenga activa y
			llamar al carrto desde aqui.
			 */
			model.addAttribute("carrito", usuario.getCarrito());
			return "redirect:/carrito";
			
		}else {
			
			// Se agregar un objeto a la lista de productos del carrito de un usuario especifico
			usuario.getCarrito().getProductos().add(producto);
			// Le pasamos el carrito del usuario
			carritoService.agregarProductoCarrito(usuario.getCarrito());	
			System.out.println("Se agrego un producto");
			model.addAttribute("carrito", usuario.getCarrito());
			/*
		 	Busca el carrito (Por ahora es temporal)
			Lo ideal es que se ingrese con una sesion que se mantenga activa y
			llamar al carrto desde aqui.
			 */
			model.addAttribute("carrito", usuario.getCarrito());
			return "redirect:/carrito";
			
		}	
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
