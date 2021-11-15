package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Address {

	@Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;
    private String street;
    private String zipCode;
    private String city;
    private String country;
	private int streetNumber;
	
	@OneToOne
	private Employee anEmp;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getStreetNumber() {
		return streetNumber;
	}
	public void setStreetNumber(int streetNumber) {
		this.streetNumber = streetNumber;
	}
	public Employee getAnEmp() {
		return anEmp;
	}
	public void setAnEmp(Employee anEmp) {
		this.anEmp = anEmp;
	}
	@Override
	public String toString() {
		return "Address [id=" + id + ", street=" + street + ", zipCode=" + zipCode + ", city=" + city + ", country="
				+ country + ", streetNumber=" + streetNumber + "]";
	}
	
}
