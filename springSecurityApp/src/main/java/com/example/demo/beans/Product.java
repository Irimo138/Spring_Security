package com.example.demo.beans;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Product {

	@Id
	private int id;
	private String name;
	private int price;
	private String currency;
	
	public Product() {};
	
	public Product(String name, int price, String currency) {
		this.name = name;
		this.price = price;
		this.currency = currency;
	}
}
