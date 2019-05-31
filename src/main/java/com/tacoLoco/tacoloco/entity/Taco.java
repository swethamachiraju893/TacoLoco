package com.tacoLoco.tacoloco.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tacos")
public class Taco {
	
	@Id
	@GeneratedValue
	private Long id;
	private String tacoName;
	private double price;
	
	protected Taco() {
		
	}
	
	public Taco(Long id, String tacoName, double price) {
		super();
		this.id = id;
		this.tacoName = tacoName;
		this.price = price;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTacoName() {
		return tacoName;
	}
	public void setTacoName(String tacoName) {
		this.tacoName = tacoName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
}
