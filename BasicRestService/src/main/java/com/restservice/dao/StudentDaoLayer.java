package com.restservice.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.restservice.model.Student;
import com.restservice.repo.StudentRepo;

@Component
public class StudentDaoLayer {

	@Autowired
	private StudentRepo studentRepo;

	public Student findById(Long id) {
		Student student = studentRepo.fetchStudents(id);

		if (student.getId() == id) {
			return student;
		}
		return null;
	}

	public void CreateNewId(Student student) {
		if (student != null) {
			studentRepo.saveAndFlush(student);
		}
	}

	public void UpdateStudent(Student student) {
		studentRepo.save(student);
	}

	public void deleteStudentDetails(Long id) {
		studentRepo.deleteById(id);
	}

}
