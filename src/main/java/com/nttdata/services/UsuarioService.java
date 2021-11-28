package com.nttdata.services;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.models.Usuario;
import com.nttdata.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	@Autowired //Inyección de dependencia entre services y luego repositories
	UsuarioRepository usuarioRepository;

	public void insertarUsuario(@Valid Usuario usuario) {
		
		usuarioRepository.save(usuario);
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
		if(usuarioRepository.existsById(usuario.getId())){
			usuarioRepository.save(usuario);
		}		
	}

	public Usuario obtenerUsuarioLogin(@Valid Usuario usuario) {
		System.out.println("TEST");
		return usuarioRepository.obtenerUsuarioLogin(usuario.getEmail(), usuario.getContrasena());
	}


}
