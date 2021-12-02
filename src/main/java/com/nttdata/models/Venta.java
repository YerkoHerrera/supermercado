package com.nttdata.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity 
@Table(name="ventas") 
public class Venta {
	
	@Id 
	@GeneratedValue(strategy= GenerationType.IDENTITY) 
	private Long id;
	@Column(updatable = false)
	private Date createdAt;
	private Date updatedAt;


	public Venta() {
		super();
	}


	public Venta(Long id, Date createAt, Date updateAt) {
		super();
		this.id = id;
		this.createdAt = createAt;
		this.updatedAt = updateAt;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Date getCreateAt() {
		return createdAt;
	}


	public void setCreateAt(Date createAt) {
		this.createdAt = createAt;
	}


	public Date getUpdateAt() {
		return updatedAt;
	}


	public void setUpdateAt(Date updateAt) {
		this.updatedAt = updateAt;
	}
	
	@PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
}
