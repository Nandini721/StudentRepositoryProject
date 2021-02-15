package com.restservice.service;

import org.springframework.stereotype.Component;

import com.restservice.model.Student;

@Component
public interface StudentService {

	void addNewStudent(Student student);

	void deleteStudent(Long id);

	Student getStudentDetails(Long id);

	Student updateStudentDetails(Student student);

}
