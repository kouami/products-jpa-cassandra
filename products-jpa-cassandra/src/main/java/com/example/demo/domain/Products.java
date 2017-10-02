package com.example.demo.domain;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.data.cassandra.mapping.CassandraType;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.stereotype.Component;

import com.datastax.driver.core.DataType;

@Entity
@Table(name="products")
public class Products {
	
	@PrimaryKey
	private UUID id;
	
	@CassandraType(type = DataType.Name.TEXT)
	private String name;
	
	@CassandraType(type = DataType.Name.DOUBLE)
	private double price;
	
	@CassandraType(type = DataType.Name.UDT, userTypeName="product_details")
	private ProductDetails product_details;
	
	public Products(){}
	
	

	public Products(UUID id, String name, double price, ProductDetails productDetails) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.product_details = productDetails;
	}



	/**
	 * @return the id
	 */
	public UUID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(UUID id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * @return the productDetails
	 */
	public ProductDetails getProductDetails() {
		return product_details;
	}

	/**
	 * @param productDetails the productDetails to set
	 */
	public void setProductDetails(ProductDetails productDetails) {
		this.product_details = productDetails;
	}
}
