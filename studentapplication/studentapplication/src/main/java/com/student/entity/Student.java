package com.student.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "student_table")
public class Student {

	@Id
	@Column(name = "student_id")
	private Integer studentId;
	@Column(name = "student_name")
	private String studentName;
	@Column(name = "student_mobilenumber")
	private String mobileNumber;
	@Column(name = "student_address")
	private String address;
	@Column(name = "student_login_id", unique = true)
	private String loginId;
	@Column(name = "password")
	private String password;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "addresId")
	private Address studentAddress;

	@ManyToOne(cascade = CascadeType.ALL, targetEntity = College.class)
	@JoinColumn(name = "collegeId")
	private College college;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "student_course", joinColumns = { @JoinColumn(name = "student_id") }, inverseJoinColumns = {
			@JoinColumn(name = "courseId") })
	private List<Courses> courses;

	public College getCollege() {
		return college;
	}

	public void setCollege(College college) {
		this.college = college;
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Address getStudentAddress() {
		return studentAddress;
	}

	public void setStudentAddress(Address studentAddress) {
		this.studentAddress = studentAddress;
	}

	public Student(Integer studentId, String studentName, String mobileNumber, String address, String loginId,
			String password, Address studentAddress, College college, List<Courses> courses) {
		this.studentId = studentId;
		this.studentName = studentName;
		this.mobileNumber = mobileNumber;
		this.address = address;
		this.loginId = loginId;
		this.password = password;
		this.studentAddress = studentAddress;
		this.college = college;
		this.courses = courses;
	}

	public List<Courses> getCourses() {
		return courses;
	}

	public void setCourses(List<Courses> courses) {
		this.courses = courses;
	}

	public Student() {
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", mobileNumber=" + mobileNumber
				+ ", address=" + address + ", loginId=" + loginId + ", password=" + password + ", studentAddress="
				+ studentAddress + ", college=" + college + ", courses=" + courses + "]";
	}

}
