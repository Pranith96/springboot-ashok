package com.student.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer addressId;
	private String plotNo;
	private String location;
	private String city;
	private String state;
	private String country;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "studentId")
	private Student student;

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Integer getAddressId() {
		return addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}

	public String getPlotNo() {
		return plotNo;
	}

	public void setPlotNo(String plotNo) {
		this.plotNo = plotNo;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Address(Integer addressId, String plotNo, String location, String city, String state, String country,
			Student student) {
		this.addressId = addressId;
		this.plotNo = plotNo;
		this.location = location;
		this.city = city;
		this.state = state;
		this.country = country;
		this.student = student;
	}

	public Address() {
	}

	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", plotNo=" + plotNo + ", location=" + location + ", city=" + city
				+ ", state=" + state + ", country=" + country + ", student=" + student + "]";
	}

}
