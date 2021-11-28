package com.nttdata.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.nttdata.models.Producto;
import com.nttdata.services.ProductoService;

@Controller
@RequestMapping("/producto")
public class ProductoController {
	
	@Autowired
	ProductoService productoService;

	@RequestMapping("")
	public String producto(@ModelAttribute("producto") Producto producto,
			Model model) {
		model.addAttribute("listaProductos", productoService.obtenerListaProductos());
		return "producto.jsp";
	}
	
	@RequestMapping("/eliminar")
	public String eliminarProducto(@RequestParam("id") Long id) {
		
		Producto producto = productoService.buscarProducto(id);
		if(producto != null) {
			productoService.eliminarProductoObjeto(producto);
			
		}
		return "redirect:/producto";
	}
	
	@RequestMapping("/{id}/editar")
	public String editarProducto(@PathVariable("id") Long id, Model model) {
		
		Producto producto = productoService.buscarProducto(id);
		if(producto != null) {
			model.addAttribute("producto", producto);
			return "/editarProducto.jsp";
			
		}
		return "redirect:/producto";
	}
	
	@RequestMapping(value="/update/{id}", method=RequestMethod.PUT)
    public String update(@Valid @ModelAttribute("producto") Producto producto, BindingResult result) {
        if (result.hasErrors()) {
            return "/producto/editarProducto.jsp";
        } else {
        	productoService.updateProducto(producto);
            return "redirect:/producto";
        }
    }
	
	@RequestMapping("/crear")
	public String crearUsuario(@Valid @ModelAttribute("producto") Producto producto) {
		
		productoService.insertarProducto(producto);
		
		return "redirect:/producto";
	}
}
