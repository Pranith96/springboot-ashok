package com.student.service;

import java.util.List;

import com.student.entity.Student;
import com.student.exceptions.StudentNotFoundException;

public interface StudentService {

	String addStudent(Student student);

	List<Student> getAllStudent();

	Student getStudentById(Integer studentId) throws StudentNotFoundException;

	Student getStudentDetailsByName(String studentName);

	Student loginDetails(String loginId, String password);

	Student getDetails(String studentName, String loginId);

	String updateStudentDetails(Student student);

	String updateStudentName(Integer studentId, String studentName);

	String deleteStudentById(Integer studentId);

}
