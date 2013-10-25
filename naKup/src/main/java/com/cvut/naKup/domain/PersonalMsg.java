package com.cvut.naKup.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
/**
 * Table of personal messages
 * @author vavat
 *
 */
@Entity
public class PersonalMsg extends NaKupEntity{
	
	private String text;
	
	@ManyToOne
	private User from;
	@ManyToOne
	private User forWho;
	
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public User getFrom() {
		return from;
	}

	public void setFrom(User from) {
		this.from = from;
	}

	public User getForWho() {
		return forWho;
	}

	public void setForWho(User forWho) {
		this.forWho = forWho;
	}
}
