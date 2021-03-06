package com.student.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.entity.Student;
import com.student.exceptions.StudentNoContentException;
import com.student.exceptions.StudentNotFoundException;
import com.student.repository.StudentRepository;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository studentRepository;

	@Override
	public String addStudent(Student student) {
		student.getStudentAddress().setStudent(student);
		Student response = studentRepository.save(student);
		if (response == null) {
			return "data not saved";
		}
		return "data saved successfully";
	}

	@Override
	public List<Student> getAllStudent() {
		List<Student> response = studentRepository.findAll();
		if (response.isEmpty() || null == response) {
			throw new StudentNoContentException("Data not exists");
		}
		return response;
	}

	@Override
	public Student getStudentById(Integer studentId) throws StudentNotFoundException {
		Optional<Student> response = studentRepository.findById(studentId);
		if (!response.isPresent()) {
			throw new StudentNotFoundException("Student id not exists");
		}
		return response.get();
	}

	@Override
	public Student getStudentDetailsByName(String studentName) {
		Optional<Student> response = studentRepository.fetchStudentName(studentName);
		return response.get();
	}

	@Override
	public Student loginDetails(String loginId, String password) {
		Optional<Student> response = studentRepository.findByLoginIdAndPassword(loginId, password);
		return response.get();
	}

	@Override
	public Student getDetails(String studentName, String loginId) {
		Optional<Student> response = studentRepository.findByStudentNameAndLoginId(studentName, loginId);
		return response.get();
	}

	@Override
	public String updateStudentDetails(Student student) {
		Optional<Student> response = studentRepository.findById(student.getStudentId());
		if (!response.isPresent()) {
			throw new StudentNotFoundException("Student id not exists for update");
		}
		if (null != student.getStudentName()) {
			response.get().setStudentName(student.getStudentName());
		}
		if (null != student.getAddress()) {
			response.get().setAddress(student.getAddress());
		}
		if (null != student.getLoginId()) {
			response.get().setLoginId(student.getLoginId());
		}
		if (null != student.getMobileNumber()) {
			response.get().setMobileNumber(student.getMobileNumber());
		}
		if (null != student.getPassword()) {
			response.get().setPassword(student.getPassword());
		}
		studentRepository.save(response.get());
		return "student Details updated";
	}

	@Override
	public String updateStudentName(Integer studentId, String studentName) {
		studentRepository.updateStudentName(studentId, studentName);
		return "updated student name";
	}

	@Override
	public String deleteStudentById(Integer studentId) {
		Optional<Student> response = studentRepository.findById(studentId);
		if (response.isPresent()) {
			studentRepository.deleteById(studentId);
		} else {
			return "id not exists to delete";
		}
		return "deleted successfully";
	}

}
