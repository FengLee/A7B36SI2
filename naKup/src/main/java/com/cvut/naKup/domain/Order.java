package com.cvut.naKup.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Table of orders
 * @author vavat
 *
 */
@Entity
@Table(name="Orders")
public class Order extends NaKupEntity{
	@Column(nullable = false)
	private double weight;
	
	@ManyToOne
	private User from;
	@ManyToOne
	private User forWho;
	@OneToMany
	private List<Goods> goods;
	
	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
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
