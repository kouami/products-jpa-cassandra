package com.example.demo.web;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.Student;
import com.example.demo.repository.StudentRepository;

//https://springframework.guru/spring-boot-web-application-part-4-spring-mvc/

@Controller
public class StudentController {
	
	@Autowired
	private StudentRepository repo;
	
	@RequestMapping("/index")
	public String index(Model model) {
		model.addAttribute("students", repo.findAll());
		return "index";
	}
	
	@RequestMapping("/addDisplay")
	public String createDisplay(Student s) {
		
		return "create";
	}
	
	@RequestMapping("/create")
	public String create(Student s) {
		s.setDob(new Date());
		repo.saveAndFlush(s);
		
		return "redirect:/index";
	}
	
	@RequestMapping("/delete/student/{id}")
	public String delete(@PathVariable("id") Long id, Student s) {
		repo.delete(id);
		
		return "redirect:/index";
	}
	
	@RequestMapping("/detail/student/{id}")
	public String detail(@PathVariable("id") Long id, Model model) {
		return "redirect:/update/student/" + id;
	}
	
	@RequestMapping("/update/student/{id}")
	public String update(@PathVariable("id") Long id, Model model) {
		model.addAttribute("student", repo.findOne(id));
		return "update";
	}
	
	@RequestMapping("/update")
	public String updateStudent(Student student, Model model) {
		Student s = repo.findOne(student.getId());
		if(s != null) {
			s.setFirstName(student.getFirstName());
			s.setLastName(student.getLastName());
			repo.saveAndFlush(s);
		}
		
		return "redirect:/index";
	}
}
