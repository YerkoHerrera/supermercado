package com.nttdata.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name="ventas") 
public class Venta {
	
	@Id 
	@GeneratedValue(strategy= GenerationType.IDENTITY) 
	private Long id;
	private Integer codVenta;
	private String nombre;
	private String fecha;
	
	
	public Venta() {
		super();
	}


	public Venta(Long id, Integer codVenta, String nombre, String fecha) {
		super();
		this.id = id;
		this.codVenta = codVenta;
		this.nombre = nombre;
		this.fecha = fecha;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Integer getCodVenta() {
		return codVenta;
	}


	public void setCodVenta(Integer codVenta) {
		this.codVenta = codVenta;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getFecha() {
		return fecha;
	}


	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	
	
	
}
