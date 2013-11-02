package com.cvut.naKup.domain;					
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

import com.cvut.naKup.provider.HashProvider;
import com.cvut.naKup.provider.SHA1Provider;
/**
 * Table user
 * @author vavat
 *
 */
@Entity
@Table(name="Users")
@Configurable(preConstruction=true)
public class User extends NaKupEntity{
	@Column(nullable = false)
	private String firstName;
	@Column(nullable = false)
	private String lastName;
	@Column(nullable = false)
	private String login;
	@Column(length = 40, nullable = false)
	private String salt;
	@Column(length = 40, nullable = false)
	private String password;
	@Column(nullable = false)
	private String street;
	@Column(nullable = false)
	private String city;
	@Column(nullable = false)
	private String psc;	
	private String picture;
	private String popis;
	@Column(nullable = false)
	private Authority authority;
	
	@OneToMany
	private List<PersonalMsg> messages;
	@OneToMany
	private List<Comment> comments;
	@OneToMany(mappedBy="forWho")
	private List<Order> orders;
	
	@Autowired
	private transient HashProvider hashProvider;	
	
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public HashProvider getHashProvider() {
		return hashProvider;
	}
	public void setHashProvider(HashProvider hashProvider) {
		this.hashProvider = hashProvider;
	}
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
	public String getPopis() {
		return popis;
	}
	public void setPopis(String popis) {
		this.popis = popis;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
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
		if(this.hashProvider == null){
			setHashProvider(new SHA1Provider());
		}
		this.salt = hashProvider.computeHash(System.nanoTime() + "");
        this.password = hashProvider.computeHash(password + salt);
	}
	/**
	 * Compare password from input with password in table 
	 * @param password string
	 * @return true if password is correct, false if incorrect
	 */
	public boolean hasPassword(String password){
        if(hashProvider.computeHash(password + salt).equals(this.password)){
            return true;
        }
        return false;
    }	
	public Authority getAuthority() {
		return authority;
	}
	public void setAuthority(Authority authority) {
		this.authority = authority;
	}
	public List<PersonalMsg> getMessages() {
		if(this.messages == null){
			this.messages = new ArrayList<PersonalMsg>();
		}
		return messages;
	}
	public void setMessages(List<PersonalMsg> messages) {
		this.messages = messages;
	}
	public List<Comment> getComments() {
		if(this.comments == null){
			this.comments = new ArrayList<Comment>();
		}
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	public List<Order> getOrders() {
		return orders;
	}
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	
			
}
