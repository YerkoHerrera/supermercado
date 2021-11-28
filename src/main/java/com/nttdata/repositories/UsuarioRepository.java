package com.nttdata.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nttdata.models.Usuario;

//Interfaz que extiende de crudrepository, una especie de clase que añade funciones
@Repository 
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	List<Usuario> findAll();
	
	@Query(value= "SELECT * FROM usuarios Where email = ?1 and contrasena = ?2", nativeQuery = true)
	Usuario obtenerUsuarioLogin(String email, String contrasena);

}
