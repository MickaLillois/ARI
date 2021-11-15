package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Project {
	
	@Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;
    private String name;
    
    @ManyToMany(mappedBy = "projectList")
    private List<Employee> employeeList = new ArrayList<Employee>();

    public Project() {
    	
    }
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
		return "Project [id=" + id + ", name=" + name + ", Nb Employees=" + employeeList.size() + "]";
	}
    
    
    

}
