package com.cvut.naKup.web.form;

import com.cvut.naKup.domain.Category;
import com.cvut.naKup.domain.Goods;

/**
 * DTO for forms of {@link Goods}.
 * 
 * @author marek
 */
public class ProductForm {

	private String name;
	private double cost;
	private String picture;
	private String text;
	private Category category;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	
}
