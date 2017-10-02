package com.example.demo;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Bean;

import com.example.demo.domain.Products;
import com.example.demo.domain.ProductDetails;
import com.example.demo.repository.ProductRepository;

//pkill -f 'java.*cassandra' 
//@SpringBootApplication
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class},scanBasePackages={"com"})
public class ProductsJpaCassandraApplication {
	
	@Autowired
	private ProductRepository productRepository;

	
	public static void main(String[] args) {
		SpringApplication.run(ProductsJpaCassandraApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner init(){
		
		Products p1 = new Products();
		Products p2 = new Products();
		
		
		ProductDetails pd1 = new ProductDetails();
		ProductDetails pd2 = new ProductDetails();
		
		
		pd1.setSku("whatever");
		pd1.setProductDesc("This is a product description # 1");
		
		pd2.setSku("whatever");
		pd2.setProductDesc("This is a product description # 2");
		
		p1.setId(UUID.randomUUID());
		p1.setName("Product1");
		p1.setPrice(22.50);
		p1.setProductDetails(pd1);
		
		p2.setId(UUID.randomUUID());
		p2.setName("Product2");
		p2.setPrice(100.00);
		p2.setProductDetails(pd2);
		
		return (args) -> {
			productRepository.save(p1);
			productRepository.save(p2);
		};
	}
}
