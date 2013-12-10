package com.cvut.naKup.web.form;

import com.cvut.naKup.domain.Category;
import com.cvut.naKup.domain.Goods;

/**
 * DTO for forms of {@link Goods}.
 * 
 * @author Marek Cech
 */
public class ProductForm {

	/**
	 * Name of product.
	 */
	private String name;
	
	/**
	 * Cost of product.
	 */
	private double cost;
	
	/**
	 * Path to picture of product.
	 */
	private String picture;
	
	/**
	 * Description of product.
	 */
	private String text;
	
	/**
	 * {@link Category} of product.
	 */
	private Category category;
	
	/**
	 * Getter of product name.
	 * 
	 * @return {@link String} with product name.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Setter of product name.
	 * 
	 * @param name Product name to set.
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Getter of product cost.marek
	 * 
	 * @return product cost.
	 */
	public double getCost() {
		return cost;
	}
	
	/**
	 * Setter of product cost.
	 * 
	 * @param cost Product cost to set.
	 */
	public void setCost(double cost) {
		this.cost = cost;
	}
	
	/**
	 * Getter of picture path.
	 * 
	 * @return path to picture
	 */
	public String getPicture() {
		return picture;
	}
	
	/**
	 * Setter of product path.
	 * 
	 * @param picture Path to picture to set. 
	 */
	public void setPicture(String picture) {
		this.picture = picture;
	}
	
	/**
	 * Getter of product description.
	 * 
	 * @return product description
	 */
	public String getText() {
		return text;
	}
	
	/**
	 * Setter of product description.
	 * 
	 * @param text Product description to set.
	 */
	public void setText(String text) {
		this.text = text;
	}
	
	/**
	 * Getter of product {@link Category}.
	 * 
	 * @return product {@link Category}
	 */
	public Category getCategory() {
		return category;
	}
	
	/**
	 * Setter of product {@link Category}.
	 * 
	 * @param category product {@link Category}
	 */
	public void setCategory(Category category) {
		this.category = category;
	}
	
}
