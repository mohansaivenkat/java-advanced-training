package one_to_many_mapping;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class College {
	
	@Id
	private Integer college_id;
	private String name;
	private String location;
	private String pincode;
	
	
	@OneToMany
	private List<Student> student;
	
	
	
	public Integer getCollege_id() {
		return college_id;
	}
	public void setCollege_id(Integer college_id) {
		this.college_id = college_id;
	}
	
	public List<Student> getStudent() {
		return student;
	}
	public void setStudent(List<Student> student) {
		this.student = student;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	
	
	

}
