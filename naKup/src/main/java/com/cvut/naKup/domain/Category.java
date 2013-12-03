package com.cvut.naKup.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
/**
 * Table of categories
 * @author vavat
 *
 */
@Entity
public class Category extends NaKupEntity{

	@Column(length=50)
	private String name;
	
	@OneToMany
	private List<Category> subCategories;
	
	@ManyToOne
	private Category superCategory;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public List<Category> getSubCategories() {
		if(this.subCategories == null){
			this.subCategories = new ArrayList<Category>();
		}
		return subCategories;
	}

	public void setSubCategories(List<Category> subCategories) {
		this.subCategories = subCategories;
	}

	public Category getSuperCategory() {
		return superCategory;
	}

	public void setSuperCategory(Category superCategory) {
		this.superCategory = superCategory;
	}
	
}
