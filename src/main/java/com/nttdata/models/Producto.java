package com.nttdata.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="productos")
public class Producto {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private Integer valorBase;
	private String descripcion;
	
	//Relación de muchos productos a una sola categoria
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="categoria_id")
	private Categoria categoria;
	
	//Releacion many to many entre carritos y productos
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
		name="ventas", //Tabla intermedia que sirve como registro de ventas
		joinColumns = @JoinColumn(name="producto_id"),
		inverseJoinColumns = @JoinColumn(name="carrito_id")
	)
	private List<Carrito> carritos;

	public Producto() {
		super();
	}

	public Producto(Long id, String nombre, Integer valorBase, String descripcion, Categoria categoria,
			List<Carrito> carritos) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.valorBase = valorBase;
		this.descripcion = descripcion;
		this.categoria = categoria;
		this.carritos = carritos;
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

	public Integer getValorBase() {
		return valorBase;
	}

	public void setValorBase(Integer valorBase) {
		this.valorBase = valorBase;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public List<Carrito> getCarritos() {
		return carritos;
	}

	public void setCarritos(List<Carrito> carritos) {
		this.carritos = carritos;
	}
	
}
