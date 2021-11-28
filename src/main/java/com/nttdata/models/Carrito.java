package com.nttdata.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="carritos")
public class Carrito {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	//Relacion de un carrito a un usuario comprador
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="usuario_id")
	private Usuario usuario;
	
	//Relacion de un carrito con multiples productos en stock
	@OneToMany(mappedBy ="carrito",fetch = FetchType.LAZY)
	private List<Producto> productos;
	
	//Fecha de compra
	@Column(updatable = false)
	private Date createdAt;

	public Carrito() {
		super();
	}
	
	public Carrito(Long id, Usuario usuario, List<Producto> productos) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.productos = productos;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

}
