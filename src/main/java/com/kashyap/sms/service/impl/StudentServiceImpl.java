package com.kashyap.sms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kashyap.sms.entity.Student;
import com.kashyap.sms.repository.StudentRepository;
import com.kashyap.sms.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentRepository repository;
	
	@Override
	public List<Student> getAllStudent() {
		return repository.findAll();
	}

	@Override
	public Student saveStudent(Student student) {
		return repository.save(student);
	}


	@Override
	public Student updateStudent(Student student) {
		return repository.save(student);
	}

	@Override
	public Student getById(Long id) {
		return repository.findById(id).get();
	}

	@Override
	public void DeleteStudent(Long id) {
		repository.deleteById(id);
	}
	

}
