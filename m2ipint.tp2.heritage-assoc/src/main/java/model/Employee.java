package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Employee {

	@Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;
    private String lastname;
    private String firstname;
	private int age;
	
	@ManyToOne
	private Company aCompany;
	
    public Company getaCompany() {
		return aCompany;
	}
	public void setaCompany(Company aCompany) {
		this.aCompany = aCompany;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLastName() {
		return lastname;
	}
	public void setLastName(String lastname) {
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
				+ ", aCompany=" + aCompany + "]";
	}
	
}
