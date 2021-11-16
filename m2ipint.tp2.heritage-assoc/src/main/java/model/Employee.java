package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Employee {

	@Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;
    private String lastname;
    private String firstname;
	private int age;
	
	@ManyToOne
	private Company company;
	
	@ManyToOne
	private Team team;
	
	@OneToOne
	private Address anAddress;
	
	@ManyToMany
	private List<Project> projectList = new ArrayList<Project>();
	
    public Company getCompany() {
		return company;
	}
	public void setCompany(Company aCompany) {
		this.company = aCompany;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", lastname=" + lastname + ", firstname=" + firstname + ", age=" + age
				+ ", company=" + company + ", address=" + anAddress + ", team=" + team + "]";
	}
	public Address getAnAddress() {
		return anAddress;
	}
	public void setAnAddress(Address anAddress) {
		this.anAddress = anAddress;
	}
	public List<Project> getProjectList() {
		return projectList;
	}
	public void setProjectList(List<Project> projectList) {
		this.projectList = projectList;
	}
	public Team getTeam() {
		return team;
	}
	public void setTeam(Team team) {
		this.team = team;
	}
	public void addAddress(Address anAddress) {
		this.anAddress = anAddress;
		anAddress.setAnEmp(this);
	}
	
	public void addProject(Project aProj) {
		this.projectList.add(aProj);
		aProj.getEmployeeList().add(this);
	}
	public void addTeam(Team aTeam) {
		this.team = aTeam;
		aTeam.getEmployeeList().add(this);
	}
}
