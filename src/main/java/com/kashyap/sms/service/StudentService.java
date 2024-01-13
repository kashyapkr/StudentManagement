package com.kashyap.sms.service;

import java.util.List;


import com.kashyap.sms.entity.Student;


public interface StudentService {
	List<Student> getAllStudent();	
	Student saveStudent(Student student);
	Student updateStudent(Student student);
	Student getById(Long id);
	void DeleteStudent(Long id);
	

}
