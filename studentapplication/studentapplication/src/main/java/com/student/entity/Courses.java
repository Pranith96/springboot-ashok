package com.student.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Courses {

	@Id
	private Integer courseId;
	private String courseName;
	private String author;

	@JsonIgnore
	@ManyToMany(mappedBy = "courses")
	private List<Student> students;

	public Integer getCourseId() {
		return courseId;
	}

	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public Courses(Integer courseId, String courseName, String author, List<Student> students) {
		this.courseId = courseId;
		this.courseName = courseName;
		this.author = author;
		this.students = students;
	}

	public Courses() {
	}

	@Override
	public String toString() {
		return "Courses [courseId=" + courseId + ", courseName=" + courseName + ", author=" + author + ", students="
				+ students + "]";
	}

}
