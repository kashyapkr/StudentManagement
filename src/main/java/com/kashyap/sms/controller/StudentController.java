package com.kashyap.sms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.kashyap.sms.entity.Student;
import com.kashyap.sms.service.StudentService;

@Controller
public class StudentController {
	
	@Autowired
	private StudentService service;
	
	@GetMapping("/students")
	public String listStudents(Model  model) {
		model.addAttribute("students", service.getAllStudent());
		return "students";
		
	}
	
	@GetMapping("/students/new")
	public String createStudent(Model model) {
		Student student = new Student();
		model.addAttribute("student",student);
		return "createStudent";
	}
	
	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("student") Student student) {
		service.saveStudent(student);
		return "redirect:/students";
		
	}
	
	@GetMapping("/students/edit/{id}")
	public String editStudent(@PathVariable Long id,Model model) {
		model.addAttribute("student",service.getById(id));
		return "edit_student";
		
	}
	
	@PostMapping("/students/{id}")
	public String updateStudent(@PathVariable Long id,@ModelAttribute("student") Student student,Model model) {
		Student byId = service.getById(id);
		byId.setId(id);
		byId.setFirstName(student.getFirstName());
		byId.setLastName(student.getLastName());
		byId.setEmail(student.getEmail());
		service.updateStudent(byId);
		return "redirect:/students";
		
	}
	
	@GetMapping("/students/delete/{id}")
	public String deleteStudent(@PathVariable Long id) {
		service.DeleteStudent(id);
		return "redirect:/students";
		
		
	}
}
