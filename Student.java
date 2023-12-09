package com.hccs.project2;

import org.springframework.stereotype.Component;

@Component
public class Student {
	private String first_name;
	private double gpa;
	private String email;
	private String gender;
	
	public Student() {
		
	}
	
	public Student(String first_name, double gpa, String email, String gender) {
		this.first_name = first_name;
		this.gpa = gpa;
		this.email = email;
		this.gender = gender;
	}
	
	public void setFirstName(String first_name) {
		this.first_name = first_name;
	}
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getFirstName() {
		return this.first_name;
	}
	public double getGpa() {
		return this.gpa;
	}
	public String getEmail() {
		return this.email;
	}
	public String getGender() {
		return this.gender;
	}
	@Override
	public String toString() {
		return this.first_name + " " + this.gpa + " " + this.email + " " + this.gender;
	}
}
