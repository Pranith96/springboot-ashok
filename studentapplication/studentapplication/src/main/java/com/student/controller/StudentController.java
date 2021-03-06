package com.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.student.entity.Student;
import com.student.exceptions.StudentNotFoundException;
import com.student.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	StudentService studentService;

	@PostMapping("/save")
	public ResponseEntity<String> createStudent(@RequestBody Student student) {
		String response = studentService.addStudent(student);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	@GetMapping("/get/all")
	public ResponseEntity<List<Student>> getStudents() {
		List<Student> response = studentService.getAllStudent();
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@GetMapping("/get/{studentId}")
	public ResponseEntity<Student> getStudent(@PathVariable("studentId") Integer studentId) throws StudentNotFoundException {
		Student response = studentService.getStudentById(studentId);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@GetMapping("/get/name/{studentName}")
	public ResponseEntity<Student> getStudentByName(@PathVariable("studentName") String studentName) {
		Student response = studentService.getStudentDetailsByName(studentName);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@GetMapping("/login/{loginId}/{password}")
	public ResponseEntity<Student> loginStudent(@PathVariable("loginId") String loginId,
			@PathVariable("password") String password) {
		Student response = studentService.loginDetails(loginId, password);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@GetMapping("/get/name/details")
	public ResponseEntity<Student> getStudentDetails(@RequestParam("studentName") String studentName) {
		Student response = studentService.getStudentDetailsByName(studentName);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@GetMapping("/get/details")
	public ResponseEntity<Student> fetchStudentDetails(@RequestParam("studentName") String studentName,
			@RequestParam("loginId") String loginId) {
		Student response = studentService.getDetails(studentName, loginId);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@PutMapping("/update")
	public ResponseEntity<String> updateDetails(@RequestBody Student student) {
		String response = studentService.updateStudentDetails(student);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@PutMapping("/update/studentName/{studentId}/{studentName}")
	public ResponseEntity<String> updateStudentnameDetails(@PathVariable("studentId") Integer studentId,
			@PathVariable("studentName") String studentName) {
		String response = studentService.updateStudentName(studentId, studentName);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	

	@DeleteMapping("/delete/{studentId}")
	public ResponseEntity<String> deleteStudent(@PathVariable("studentId") Integer studentId) {
		String response = studentService.deleteStudentById(studentId);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
}