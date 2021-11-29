package com.student.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.student.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

	// Optional<Student> findByStudentName(String studentName);

	Optional<Student> findByLoginIdAndPassword(String loginId, String password);

	Optional<Student> findByStudentNameAndLoginId(String studentName, String loginId);

	@Query("select s from Student s where s.studentName=:studentName")
	Optional<Student> fetchStudentName(String studentName);

	@Modifying
	@Query("update Student s set s.studentName = :studentName where s.studentId = :studentId")
	void updateStudentName(Integer studentId, String studentName);

}
