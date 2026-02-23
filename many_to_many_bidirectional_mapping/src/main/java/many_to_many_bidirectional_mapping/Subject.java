package many_to_many_bidirectional_mapping;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Subject {

	@Id
	private Integer sub_id;
	private String name;
	private Integer numOfDays;
	
	@ManyToMany(mappedBy = "subject")
	private List<Student> students;
	
	
	
	
	public Subject(Integer sub_id, String name, Integer numOfDays) {
		super();
		this.sub_id = sub_id;
		this.name = name;
		this.numOfDays = numOfDays;
	}
	public Integer getSub_id() {
		return sub_id;
	}
	public void setSub_id(Integer sub_id) {
		this.sub_id = sub_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getNumOfDays() {
		return numOfDays;
	}
	public void setNumOfDays(Integer i) {
		this.numOfDays = i;
	}
	
	
	
	
	
}

