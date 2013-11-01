package com.cvut.naKup.web.form;

public class RegistrationForm {
	
	private String firstName;
	private String lastName;
	private String login;
	private String password;
	private String street;
	private String city;
	private String psc;	
	private String picture;
	private String popis;
	private boolean customer;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPsc() {
		return psc;
	}
	public void setPsc(String psc) {
		this.psc = psc;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getPopis() {
		return popis;
	}
	public void setPopis(String popis) {
		this.popis = popis;
	}
	public boolean isCustomer() {
		return customer;
	}
	public void setCustomer(boolean customer) {
		this.customer = customer;
	}

}
