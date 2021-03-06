package com.nttdata.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nttdata.models.Usuario;
import com.nttdata.services.UsuarioService;

@Controller
public class LoginController {
	
	@Autowired //Inyección de dependencia entre services y luego repositories
	UsuarioService usuarioService;
	
	// Redirige a localhost:8080/login
	@RequestMapping("")
	public String index() {
   
    	return "redirect:/login";
	}
	
	@RequestMapping("/login")
	public String login(@Valid @ModelAttribute("login") Usuario usuario,
			Model model, HttpSession session) {
    	
    	Usuario usuarioLogin = usuarioService.findByEmail(usuario.getEmail());

    	if(usuarioLogin != null) {
    		
    		model.addAttribute("nombre_usuario", usuarioLogin.getNombre());
    		session.getAttribute(usuarioLogin.getNombre());
    		System.out.println(usuarioLogin.getNombre() + " " + model.getAttribute("nombre_usuario"));
    		return "home.jsp";
		}
		return "login.jsp";
	}
	
	@RequestMapping("/registro")
	public String registro(@ModelAttribute("usuario") Usuario usuario,
			Model model) {
		model.addAttribute("usuario", new Usuario());
    	return "signin.jsp";
	}

}
