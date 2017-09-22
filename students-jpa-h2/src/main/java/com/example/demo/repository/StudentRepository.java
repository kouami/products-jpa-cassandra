/**
 * 
 */
package com.example.demo.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.Student;

/**
 * @author efoeakolly
 *
 */
public interface StudentRepository extends JpaRepository<Student, Long>{
	
	/**
	 * 
	 * @param name
	 * @return
	 */
	public List<Student> findByLastName(String firstName);
	
	/**
	 * 
	 * @param firstName
	 * @param lastName
	 * @return
	 */
	public Student findByFirstNameAndLastName(String firstName, String lastName);
	
	/**
	 * 
	 * @param dob
	 * @return
	 */
	public Student findByDob(Date dob);
}
