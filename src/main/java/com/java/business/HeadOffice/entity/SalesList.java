package com.java.business.HeadOffice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "saleslist")
public class SalesList {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "saleslist_id")
	private long saleslist_id;

	private String categoryid;

	private long productid;

	private int qty;
	
	private int shipped_qty;

	private double price;

	private double discount_percentage;

	private double discount_amt;

	private double tax_percentage;

	private double tax_amt;

	private double amount;
	
	private long hsn_code;
	  
	
	private long unit_id;


	public long getSaleslist_id() {
		return saleslist_id;
	}


	public void setSaleslist_id(long saleslist_id) {
		this.saleslist_id = saleslist_id;
	}


	public String getCategoryid() {
		return categoryid;
	}


	public void setCategoryid(String categoryid) {
		this.categoryid = categoryid;
	}


	public long getProductid() {
		return productid;
	}


	public void setProductid(long productid) {
		this.productid = productid;
	}


	public int getQty() {
		return qty;
	}


	public void setQty(int qty) {
		this.qty = qty;
	}


	public int getShipped_qty() {
		return shipped_qty;
	}


	public void setShipped_qty(int shipped_qty) {
		this.shipped_qty = shipped_qty;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public double getDiscount_percentage() {
		return discount_percentage;
	}


	public void setDiscount_percentage(double discount_percentage) {
		this.discount_percentage = discount_percentage;
	}


	public double getDiscount_amt() {
		return discount_amt;
	}


	public void setDiscount_amt(double discount_amt) {
		this.discount_amt = discount_amt;
	}


	public double getTax_percentage() {
		return tax_percentage;
	}


	public void setTax_percentage(double tax_percentage) {
		this.tax_percentage = tax_percentage;
	}


	public double getTax_amt() {
		return tax_amt;
	}


	public void setTax_amt(double tax_amt) {
		this.tax_amt = tax_amt;
	}


	public double getAmount() {
		return amount;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}


	public long getHsn_code() {
		return hsn_code;
	}


	public void setHsn_code(long hsn_code) {
		this.hsn_code = hsn_code;
	}


	public long getUnit_id() {
		return unit_id;
	}


	public void setUnit_id(long unit_id) {
		this.unit_id = unit_id;
	}


	public SalesList(long saleslist_id, String categoryid, long productid, int qty, int shipped_qty, double price,
			double discount_percentage, double discount_amt, double tax_percentage, double tax_amt, double amount,
			long hsn_code, long unit_id) {
		super();
		this.saleslist_id = saleslist_id;
		this.categoryid = categoryid;
		this.productid = productid;
		this.qty = qty;
		this.shipped_qty = shipped_qty;
		this.price = price;
		this.discount_percentage = discount_percentage;
		this.discount_amt = discount_amt;
		this.tax_percentage = tax_percentage;
		this.tax_amt = tax_amt;
		this.amount = amount;
		this.hsn_code = hsn_code;
		this.unit_id = unit_id;
	}


	@Override
	public String toString() {
		return "SalesList [saleslist_id=" + saleslist_id + ", categoryid=" + categoryid + ", productid=" + productid
				+ ", qty=" + qty + ", shipped_qty=" + shipped_qty + ", price=" + price + ", discount_percentage="
				+ discount_percentage + ", discount_amt=" + discount_amt + ", tax_percentage=" + tax_percentage
				+ ", tax_amt=" + tax_amt + ", amount=" + amount + ", hsn_code=" + hsn_code + ", unit_id=" + unit_id
				+ "]";
	}


	public SalesList() {
		super();
	}



	
	
	

}
