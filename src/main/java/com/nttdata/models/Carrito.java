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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
	
	
	//Releacion many to many entre carritos y productos
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
		name="ventas",//Tabla intermedia que sirve como registro de ventas
		joinColumns = @JoinColumn(name="carrito_id"),
		inverseJoinColumns = @JoinColumn(name="producto_id")
	)
	private List<Producto> productos;
	
	//Fecha de compra
	@Column(updatable = false)
	private Date createdAt;

	public Carrito() {
		super();
	}

	public Carrito(Long id, Usuario usuario, List<Producto> productos, Date createdAt) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.productos = productos;
		this.createdAt = createdAt;
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

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

}
