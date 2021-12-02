package com.nttdata.services;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.nttdata.models.Usuario;
import com.nttdata.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	
	//Inyección de dependencia entre services y luego repositories
	@Autowired 
	UsuarioRepository usuarioRepository;
	
	@Autowired 
	RoleService roleService;
	
	@Autowired 
	BCryptPasswordEncoder passwordEncoder;

	public void insertarUsuario(@Valid Usuario usuario) {
		
		usuario.setRoles(roleService.findByNombre("ROLE_USER"));
		usuarioRepository.save(usuario);
	}
	
	public Usuario registrarUsuario(@Valid Usuario usuario) {
		System.out.println("Viene el usuario: " + usuario.getId() + " " + usuario.getNombre());
		usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
		return usuarioRepository.save(usuario);
	}

	public Object obtenerListaUsuarios() {
		
		return usuarioRepository.findAll();
	}
	
	public Usuario buscarUsuario(Long id) {
		
		return usuarioRepository.findById(id).get();	
	}
	
	public void eliminarUsuario(Long id) {
		usuarioRepository.deleteById(id);
	}

	public void eliminarUsuarioObjeto(Usuario usuario) {
		usuarioRepository.delete(usuario);
	}

	public void editarUsuarioObjeto(Usuario usuario) {
		usuarioRepository.save(usuario);
	}

	public void updateUsuario(@Valid Usuario usuario) {
		System.out.println("ESTA POR ENTRAR AL IF");
		System.out.println("EL USUARIO QUE VA A ENTRAT TIENE ID: " + usuario.getId());
		if(usuarioRepository.existsById(usuario.getId())){
			System.out.println("ENTRO AL IF");
			usuarioRepository.save(usuario);
		}		
	}

	public Usuario obtenerUsuarioLogin(@Valid Usuario usuario) {
		System.out.println("TEST");
		return usuarioRepository.obtenerUsuarioLogin(usuario.getEmail(), usuario.getPassword());
	}

	public Usuario findByEmail(String email) {
		return usuarioRepository.findByEmail(email);
	}


}
