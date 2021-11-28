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

import com.nttdata.models.Venta;
import com.nttdata.services.VentaService;

@Controller
@RequestMapping("/venta")
public class VentaController {
	@Autowired
	VentaService ventaService;

	@RequestMapping("")
	public String venta(@ModelAttribute("venta") Venta venta,
			Model model) {
		model.addAttribute("listaVentas", ventaService.obtenerListaVentas());
		return "venta.jsp";
	}
	
	@RequestMapping("/eliminar")
	public String eliminarVenta(@RequestParam("id") Long id) {
		
		Venta venta = ventaService.buscarVenta(id);
		if(venta != null) {
			ventaService.eliminarVentaObjeto(venta);
			
		}
		return "redirect:/venta";
	}
	
	@RequestMapping("/{id}/editar")
	public String editarVenta(@PathVariable("id") Long id, Model model) {
		
		Venta venta = ventaService.buscarVenta(id);
		if(venta != null) {
			model.addAttribute("venta", venta);
			return "/editarVenta.jsp";
			
		}
		return "redirect:/venta";
	}
	
	@RequestMapping(value="/update/{id}", method=RequestMethod.PUT)
    public String update(@Valid @ModelAttribute("venta") Venta venta, BindingResult result) {
        if (result.hasErrors()) {
            return "/venta/editarVenta.jsp";
        } else {
        	ventaService.updateVenta(venta);
            return "redirect:/venta";
        }
    }
	
	@RequestMapping("/login")
	public String login(@Valid @ModelAttribute("venta") Venta venta) {
		
		ventaService.insertarVenta(venta);
		
		return "redirect:/venta";
	}
}
