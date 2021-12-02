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
	
	@Query(value= "SELECT * FROM usuarios Where email = ?1 and password = ?2", nativeQuery = true)
	Usuario obtenerUsuarioLogin(String email, String password);

	@Query(value= "SELECT * FROM usuarios Where email = ?1", nativeQuery = true)
	Usuario findByEmail(String email);
	
	@Query(value= "SELECT * FROM usuarios Where nombre = ?1", nativeQuery = true)
	Usuario findByNombre(String nombre);
	
	
	@Query("SELECT u FROM Usuario u")
	List<Usuario> findAllUsuarios();
	
	@Query("SELECT u.nombre FROM Usuario u")
	List<String> findAllUsuariosNombres();
	
	@Query("SELECT u.nombre, u.apellido FROM Usuario u")
	List<Object[]> findAllUsuariosNombreApellido();
	
	@Query("SELECT u FROM Usuario u Where id = ?1")
	List<Usuario> obtenerUsuarioWhereId(Long id);
	
	//Query tradicional (se agregar nombre de la tabla, NO el objeto)
	@Query(value = "SELECT nombre, apellido FROM usuarios", nativeQuery = true)
	List<Object[]> findAllUsuariosNombreApellidoSQL();
	
	@Query(value= "SELECT * FROM usuarios Where rut = ?2 and id = ?1", nativeQuery = true)
	List<Usuario> obtenerUsuarioWhereIdSQL(Long id, String rut);

}
