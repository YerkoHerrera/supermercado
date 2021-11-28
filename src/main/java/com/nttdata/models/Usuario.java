package com.nttdata.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity // Representación de la entidad modelo 
@Table(name="usuarios") //Nombre de la tabla en la bbdd
public class Usuario {
	
	@Id //Clave primaria
	@GeneratedValue(strategy= GenerationType.IDENTITY) //Auto incrementable
	private Long id;
	
	private String nombre;
	private String apellido;
	private String limite;
	private String codigoPostal;
	private String email;
	private String contrasena;
	
	@OneToOne(mappedBy ="usuario", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Carrito carrito;
	
	public Usuario() {
		super();
	}

	public Usuario(Long id, String nombre, String apellido, String limite, String codigoPostal, String email,
			String contrasena) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.limite = limite;
		this.codigoPostal = codigoPostal;
		this.email = email;
		this.contrasena = contrasena;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getLimite() {
		return limite;
	}

	public void setLimite(String limite) {
		this.limite = limite;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	
}
