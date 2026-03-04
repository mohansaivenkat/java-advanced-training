package com.capgemini.basicsofspringbootmapping.dto;

public class StudentDto {

    private String name;
    private String college;
    private Double marks;
    private String gender;
    
    private String email;
    private String phone;
    
    

    public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCollege() {
        return college;
    }
    public void setCollege(String college) {
        this.college = college;
    }
    public Double getMarks() {
        return marks;
    }
    public void setMarks(Double marks) {
        this.marks = marks;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }

}
