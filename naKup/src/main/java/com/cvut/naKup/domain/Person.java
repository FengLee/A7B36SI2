package com.cvut.naKup.domain;

import javax.persistence.Entity;

/**
 * Test class.
 * pokus git
 * @author marek cech
 *
 */
@Entity
public class Person extends NaKupEntity {
	
	private String firstName;

    private String lastName;

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

}
