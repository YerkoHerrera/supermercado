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

import com.nttdata.models.Usuario;
import com.nttdata.services.UsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired //Inyección de dependencia entre services y luego repositories
	UsuarioService usuarioService;

	//desplegar inicialmente el jsp
	@RequestMapping("")
	public String usuario(@ModelAttribute("usuario") Usuario usuario,
			Model model) {
		//model.addAttribute("usuario", new Usuario());
		model.addAttribute("listaUsuarios", usuarioService.obtenerListaUsuarios());
		
		return "usuario.jsp";
	}
	
    @RequestMapping("/crear")
	public String crearUsuario(@Valid @ModelAttribute("usuario") Usuario usuario) {
		
    	Usuario usuario2 = usuarioService.findByEmail(usuario.getEmail());
    	
    	//Validacion de usuario vacio
    	if(usuario.getEmail().isEmpty() && usuario.getPassword().isEmpty()) {
    		System.out.println("El usuario no puede ser vacio");
    		return "redirect:/usuario";
    	}
    	
    	//Validacion de si el usuario existe en la bbdd
    	if(usuario2 != null) {
    		System.out.println("El usuario ya existe");
    		return "redirect:/usuario";
    	}
    	
    	System.out.println("Se agrego un usuario nuevo");
        usuarioService.insertarUsuario(usuario);
        	
        return "redirect:/usuario";
    	
	}
    
    // Es igual a la funcion crear pero esta redirige al login
    @RequestMapping("/registrar")
	public String registrarUsuario(@Valid @ModelAttribute("usuario") Usuario usuario) {
		
    	Usuario usuario2 = usuarioService.findByEmail(usuario.getEmail());
    	
    	//Validacion de usuario vacio
    	if(usuario.getEmail().isEmpty() && usuario.getPassword().isEmpty()) {
    		System.out.println("El usuario no puede ser vacio");
    		return "redirect:/login";
    	}
    	
    	//Validacion de si el usuario existe en la bbdd
    	if(usuario2 != null) {
    		System.out.println("El usuario ya existe");
    		return "redirect:/login";
    	}
    	
    	System.out.println("Se agrego un usuario nuevo");
        usuarioService.insertarUsuario(usuario);
        	
        return "redirect:/login";
	}
    
	@RequestMapping("/eliminar")
	public String eliminarUsuario(@RequestParam("id") Long id) {
		
		Usuario usuario = usuarioService.buscarUsuario(id);
		if(usuario != null) {
			usuarioService.eliminarUsuarioObjeto(usuario);
			
		}
		return "redirect:/usuario";
	}
	
	@RequestMapping("/{id}/editar")
    public String edit(@PathVariable("id") Long id, Model model) {
    	System.out.println("EDITING");
    	Usuario usuario = usuarioService.buscarUsuario(id);
    	if(usuario !=null) {
		    model.addAttribute("usuario", usuario);
		    System.out.println("HASTA AHORA VAMOS CON EL USAURIO: " + usuario.getId());
		    return "/editarUsuario.jsp";
		}
		
		return "redirect:/usuario";
    }
	
	@RequestMapping(value="/update/{id}", method=RequestMethod.PUT)
	public String update(@Valid @ModelAttribute("usuario") Usuario usuario, BindingResult result) {

        if (result.hasErrors()) {
            return "editarUsuario.jsp";
        } else {
        	usuarioService.updateUsuario(usuario);
            return "redirect:/usuario";
        }
    }

}
