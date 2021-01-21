package com.fee.bean;

public class StudentBean {
	private int rollno;
	private String name, email, sex, course;
	private int fee;

	public StudentBean() {
	}

	
	public StudentBean(int rollno, String name, String email, String sex, String course, int fee) {
		super();
		this.rollno = rollno;
		this.name = name;
		this.email = email;
		this.sex = sex;
		this.course = course;
		this.fee = fee;
	}

	public int getRollno() {
		return rollno;
	}

	public void setRollno(int rollno) {
		this.rollno = rollno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public int getFee() {
		return fee;
	}

	public void setFee(int fee) {
		this.fee = fee;
	}

}