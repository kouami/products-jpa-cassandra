/**
 * 
 */
package com.example.demo.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;

import com.example.demo.domain.Products;

/**
 * @author efoeakolly
 *
 */
public interface ProductRepository extends CassandraRepository<Products> {
}
