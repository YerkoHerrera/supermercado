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

import com.nttdata.models.Categoria;
import com.nttdata.services.CategoriaService;

@Controller
@RequestMapping("/categoria")
public class CategoriaController {
	@Autowired
	CategoriaService categoriaService;

	@RequestMapping("")
	public String categoria(@ModelAttribute("categoria") Categoria categoria,
			Model model) {
		model.addAttribute("listaCategorias", categoriaService.obtenerListaCategorias());
		return "categoria.jsp";
	}
	
	@RequestMapping("/eliminar")
	public String eliminarCategoria(@RequestParam("id") Long id) {
		
		Categoria categoria = categoriaService.buscarCategoria(id);
		if(categoria != null) {
			categoriaService.eliminarCategoriaObjeto(categoria);
			
		}
		return "redirect:/categoria";
	}
	
	@RequestMapping("/{id}/editar")
	public String editarCategoria(@PathVariable("id") Long id, Model model) {
		
		Categoria categoria = categoriaService.buscarCategoria(id);
		if(categoria != null) {
			model.addAttribute("categoria", categoria);
			return "/editarCategoria.jsp";
			
		}
		return "redirect:/categoria";
	}
	
	@RequestMapping(value="/update/{id}", method=RequestMethod.PUT)
    public String update(@Valid @ModelAttribute("categoria") Categoria categoria, BindingResult result) {
        if (result.hasErrors()) {
            return "/categoria/editarCategoria.jsp";
        } else {
        	categoriaService.updateCategoria(categoria);
            return "redirect:/categoria";
        }
    }
	
	@RequestMapping("/crear")
	public String crearCategoria(@Valid @ModelAttribute("categoria") Categoria categoria) {
		
		categoriaService.insertarCategoria(categoria);
		
		return "redirect:/categoria";
	}

}
