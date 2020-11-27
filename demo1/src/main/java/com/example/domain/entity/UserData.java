  
package com.example.domain.entity;

public class UserData {
	private int empid;
	private String name;
	private String branch;
	private int age;
	private int hobid;
	private String hobname;
	
	public int getEmpId() {
		return empid;
	}
	public void setEmpId(int empid) {
		this.empid = empid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getHobid() {
		return hobid;
	}
	public void setHobid(int hobid) {
		this.hobid = hobid;
	}
	public String getHobname() {
		return hobname;
	}
	public void setHobname(String hobname) {
		this.hobname = hobname;
	}
}