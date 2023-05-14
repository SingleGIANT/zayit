package com.java.business.HeadOffice.entity;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="category")
public class Category {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="category_id")
	private long category_id;
	

	
    @NotNull(message="Category Already Exist")
	@Column(name="category", nullable=false, unique = true)
    private String category;
    
 



	public long getCategory_id() {
		return category_id;
	}


	public void setCategory_id(long category_id) {
		this.category_id = category_id;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	


	public Category(long category_id, @NotNull(message = "Category Already Exist") String category) {
		super();
		this.category_id = category_id;
		this.category = category;
		
	}


	public Category() {
		super();
	}


	@Override
	public String toString() {
		return "Category [category_id=" + category_id + ", category=" + category + "]";
	}



	
	
}
