package com.prac;

public class Employee {
	
	private Integer id;
	private String name;
	private Integer age;
	private String dept;
	
	public Employee(Integer id, String name, Integer age, String dept) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.dept = dept;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}
	
	
	public static boolean isValidName(String name) {
		for(Character c : name.toCharArray()) {
			if(!Character.isLetter(c)) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean isValidAge(Integer i) {
		
		if(i>=18) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
	
	

}
