package com.restservice.repo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.restservice.model.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {

	@Query(value = "SELECT s.* FROM STUDENT s where  s.student_id=?1", nativeQuery = true)
	public Student fetchStudents(Long id);

}
