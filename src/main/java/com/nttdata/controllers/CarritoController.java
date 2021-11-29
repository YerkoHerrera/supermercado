package com.nttdata.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nttdata.models.Carrito;
import com.nttdata.services.ProductoService;
import com.nttdata.services.UsuarioService;

@Controller
@RequestMapping("/carrito")
public class CarritoController {
	
	//El carrito requiere de los servicios de usuario y productos
	@Autowired 
	UsuarioService usuarioService;
	
	@Autowired 
	ProductoService productoService;
	
	@RequestMapping("")
	public String carrito(@ModelAttribute("carrito") Carrito carrito,
			Model model) {
		
		model.addAttribute("listaProductos", productoService.obtenerListaProductos());
		model.addAttribute("listaUsuarios", usuarioService.obtenerListaUsuarios());
		
		return "carrito.jsp";
	}
	
	
	

}
