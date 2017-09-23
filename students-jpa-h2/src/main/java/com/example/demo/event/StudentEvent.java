/**
 * 
 */
package com.example.demo.event;

import org.springframework.context.ApplicationEvent;

import com.example.demo.domain.Student;

/**
 * @author efoeakolly
 *
 */
public class StudentEvent extends ApplicationEvent {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Student student;

	public StudentEvent(Object source, Student s) {
		super(source);
		this.student = s;
	}

	/**
	 * @return the student
	 */
	public Student getStudent() {
		return student;
	}

	/**
	 * @param student the student to set
	 */
	public void setStudent(Student student) {
		this.student = student;
	}
	
}
