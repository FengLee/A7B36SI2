package com.cvut.naKup.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
/**
 * Table of comments
 * @author vavat
 *
 */
@Entity
public class Comment {
	@Column(nullable = false)
	private String comment;
	
	@ManyToOne
	private User from;
	@ManyToOne
	private User forWho;
	
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
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
