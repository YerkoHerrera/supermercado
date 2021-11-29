package com.nttdata.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nttdata.models.Usuario;
import com.nttdata.services.UsuarioService;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@Autowired //Inyección de dependencia entre services y luego repositories
	UsuarioService usuarioService;
	
	@RequestMapping("")
	public String login(@Valid @ModelAttribute("login") Usuario usuario) {
    	
    	Usuario usuarioLogin = usuarioService.obtenerUsuarioLogin(usuario);

    	if(usuarioLogin != null) {
    		return "redirect:/home";
		}
		return "login.jsp";
	}

}
