package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Team {
	
	@Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;
	private String name;
    
    @OneToMany(mappedBy = "team")
    private List<Employee> employeeList = new ArrayList<Employee>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Employee> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(List<Employee> employeeList) {
		this.employeeList = employeeList;
	}

	@Override
	public String toString() {
		return "Team [id=" + id + ", name=" + name + ", Nb Employees=" + employeeList.size() + "]";
	}
    
    
}
