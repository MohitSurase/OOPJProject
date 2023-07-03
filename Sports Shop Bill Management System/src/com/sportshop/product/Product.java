package com.sportshop.product;

import java.util.Objects;

public class Product  {
	
	private int id;
	private String name;
	private double price;

	
	public Product() {
		
	}
	public Product(int id, String name, double price) {
		this.id = id;
		this.name = name;
		this.price = price;

	}

//	public static ArrayList<Product> getProductList() {
//		return productList;
//	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {

		return String.format("%-5d%-15s%-7.2f", this.id, this.name, this.price);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return id == other.id;
	}
}