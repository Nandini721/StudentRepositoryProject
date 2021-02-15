package com.restservice.serviceimpl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restservice.dao.StudentDaoLayer;
import com.restservice.exception.CustomNotFoundExceptionHandling;
import com.restservice.model.Student;
import com.restservice.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentDaoLayer studentDaoLayer;

	StudentServiceImpl studentServiceImpl;

	@Override
	public Student updateStudentDetails(Student student) {

		Student existing = studentDaoLayer.findById(student.getId());

		if (existing == null) {
			throw new CustomNotFoundExceptionHandling("unable to find data for shared id" + student.getId());
		}

		copyNonNullProperties(student, existing);
		studentDaoLayer.UpdateStudent(existing);

		return existing;

	}

	public static void copyNonNullProperties(Object src, Object target) {
		BeanUtils.copyProperties(src, target, getNullPropertyNames(src));
	}

	public static String[] getNullPropertyNames(Object source) {
		final BeanWrapper src = new BeanWrapperImpl(source);
		java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

		Set<String> emptyNames = new HashSet<String>();
		for (java.beans.PropertyDescriptor pd : pds) {
			Object srcValue = src.getPropertyValue(pd.getName());
			if (srcValue == null)
				emptyNames.add(pd.getName());
		}
		String[] result = new String[emptyNames.size()];
		return emptyNames.toArray(result);
	}

	@Override
	public void addNewStudent(Student student) {

		studentDaoLayer.CreateNewId(student);
	}

	@Override
	public void deleteStudent(Long id) {
		studentDaoLayer.deleteStudentDetails(id);

	}

	@Override
	public Student getStudentDetails(Long id) {

		Student students = studentDaoLayer.findById(id);

		if (students == null) {
			throw new CustomNotFoundExceptionHandling("unable to find data for shared id" + id);
		}

		return students;
	}

}
