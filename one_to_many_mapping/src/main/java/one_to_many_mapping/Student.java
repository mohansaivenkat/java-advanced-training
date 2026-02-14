package one_to_many_mapping;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student {
	
	@Id
	private Integer s_id;
	private String name;
	private String branch;
	
	public Integer getStudent_id() {
		return s_id;
	}
	public void setStudent_id(Integer student_id) {
		this.s_id = student_id;
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
	
	 
}
