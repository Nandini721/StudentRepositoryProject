package com.restservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.restservice.model.Student;
import com.restservice.service.StudentService;

@RestController
public class StudentCRUDController {

	@Autowired
	private StudentService studentService;

	@GetMapping("/student/id/{id}")
	@ResponseStatus(HttpStatus.FOUND)
	public Student retrieveStudent(@PathVariable Long id) {

		Student student = studentService.getStudentDetails(id);

		return student;

	}

	@PostMapping("/addStudent")
	@ResponseStatus(HttpStatus.CREATED)
	public void createStudent(@RequestBody Student student) {
		studentService.addNewStudent(student);
	}

	@PostMapping("/updateStudent")
	@ResponseStatus(HttpStatus.OK)
	public Student updateStudent(@RequestBody Student student) {
		return studentService.updateStudentDetails(student);
	}

	@DeleteMapping("/DeleteStudent/id/{id}")
	public void deleteStudent(@PathVariable Long id) {
		studentService.deleteStudent(id);
	}
}
