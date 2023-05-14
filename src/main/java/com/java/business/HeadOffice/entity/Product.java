package com.java.business.HeadOffice.entity;

import java.io.File;
import java.util.Arrays;
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
import javax.validation.constraints.Size;

@Entity
@Table(name="product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long productid;
	
    @NotNull(message="Send me the category id")
	@Column(name="categoryid", nullable = false)
	private long categoryid;
	
	@Size(min=1, max=400)
	@Column(name="productdescription", nullable =true)
	private String productdescription;
	
	@NotNull(message="Code Already Exist")
	@Column(name="hsn_code", nullable = false, unique = true)
	private String hsn_code;
	
	
	@NotNull(message="Please enter the product name")
	@Size(min=1, max=80)
	@Column(name="productname",nullable=false)
	private String productname;
	
	
	@Column(name="image_data")
	private byte[] imageData; 
	
	
	private long unit_id;
	
	@Column(name="stock")
	private long stock;
	
	
	
	

	public long getProductid() {
		return productid;
	}

	public void setProductid(long productid) {
		this.productid = productid;
	}

	public long getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(long categoryid) {
		this.categoryid = categoryid;
	}

	public String getProductdescription() {
		return productdescription;
	}

	public void setProductdescription(String productdescription) {
		this.productdescription = productdescription;
	}

	public String getHsn_code() {
		return hsn_code;
	}

	public void setHsn_code(String hsn_code) {
		this.hsn_code = hsn_code;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	

	public byte[] getImageData() {
		return imageData;
	}

	public void setImageData(byte[] imageData) {
		this.imageData = imageData;
	}

	public long getUnit_id() {
		return unit_id;
	}

	public void setUnit_id(long unit_id) {
		this.unit_id = unit_id;
	}

	public long getStock() {
		return stock;
	}

	public void setStock(long stock) {
		this.stock = stock;
	}

	

	public Product() {
		super();
	}

	

	@Override
	public String toString() {
		return "Product [productid=" + productid + ", categoryid=" + categoryid + ", productdescription="
				+ productdescription + ", hsn_code=" + hsn_code + ", productname=" + productname + ", imageData="
				+ Arrays.toString(imageData) + ", unit_id=" + unit_id + ", stock=" + stock + "]";
	}

	public Product(long productid, @NotNull(message = "Send me the category id") long categoryid,
			@Size(min = 1, max = 400) String productdescription,
			@NotNull(message = "Code Already Exist") String hsn_code,
			@NotNull(message = "Please enter the product name") @Size(min = 1, max = 80) String productname,
			byte[] imageData, long unit_id, long stock) {
		super();
		this.productid = productid;
		this.categoryid = categoryid;
		this.productdescription = productdescription;
		this.hsn_code = hsn_code;
		this.productname = productname;
		this.imageData = imageData;
		this.unit_id = unit_id;
		this.stock = stock;
	}

	public void setImagePath(String string) {
		// TODO Auto-generated method stub
		
	}

	






}

	
	
	
	

	
	
	
	
