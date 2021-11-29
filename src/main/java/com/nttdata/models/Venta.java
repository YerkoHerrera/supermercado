package com.nttdata.models;

import java.util.Date;

import javax.persistence.Column;
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
	@Column(updatable = false)
	private Date createAt;
	private Date updateAt;


	public Venta() {
		super();
	}


	public Venta(Long id, Date createAt, Date updateAt) {
		super();
		this.id = id;
		this.createAt = createAt;
		this.updateAt = updateAt;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Date getCreateAt() {
		return createAt;
	}


	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}


	public Date getUpdateAt() {
		return updateAt;
	}


	public void setUpdateAt(Date updateAt) {
		this.updateAt = updateAt;
	}
	
}
