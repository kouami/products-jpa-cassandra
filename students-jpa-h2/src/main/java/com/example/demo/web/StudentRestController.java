/**
 * 
 */
package com.example.demo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Student;
import com.example.demo.repository.StudentRepository;

/**
 * @author efoeakolly
 *
 */
@RestController
public class StudentRestController {
	
	@Autowired
	private StudentRepository repo;
	
	@RequestMapping(value="/students/{firstName}/{lastName}", method = RequestMethod.GET)
	public Student getStudentByFirstNameAndLastName(@PathVariable("firstName") String firstName, @PathVariable("lastName") String lastName) {
		System.out.println("FirstName = " + firstName + "\t" + "LastName = " + lastName);
		return repo.findByFirstNameAndLastName(firstName, lastName);
	}
	
	@RequestMapping(value="/students/{lastName}")
	public List<Student> getStudentsByFirstName(@PathVariable("lastName") String lastName) {
		return repo.findByLastName(lastName);
	}
	
	@RequestMapping(value="/students")
	public List<Student> getAllStudents() {
		return repo.findAll();
	}
}
