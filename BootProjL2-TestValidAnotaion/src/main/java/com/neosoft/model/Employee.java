package com.neosoft.model;

import com.neosoft.annotation.EmailAnnotation;
public class Employee {
	
	private int id;
	@EmailAnnotation(message = "email is not valid")
	private String email;
	public Employee(int id, String email) {
		super();
		this.id = id;
		this.email = email;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", email=" + email + "]";
	}
	
	

}
