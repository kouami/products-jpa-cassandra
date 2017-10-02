package com.example.demo.domain;

import org.springframework.data.cassandra.mapping.CassandraType;
import org.springframework.data.cassandra.mapping.UserDefinedType;
import org.springframework.stereotype.Component;

import com.datastax.driver.core.DataType;


@UserDefinedType("product_details") 
public class ProductDetails {
	
	@CassandraType(type=DataType.Name.TEXT)
	private String sku;
	
	@CassandraType(type=DataType.Name.TEXT)
	private String productDesc;

	/**
	 * @return the sku
	 */
	public String getSku() {
		return sku;
	}

	/**
	 * @param sku the sku to set
	 */
	public void setSku(String sku) {
		this.sku = sku;
	}

	/**
	 * @return the productDesc
	 */
	public String getProductDesc() {
		return productDesc;
	}

	/**
	 * @param productDesc the productDesc to set
	 */
	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}
}
