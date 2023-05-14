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

@Entity
@Table(name = "purchase")
public class Purchase {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "purchase_id")
	private long purchase_id;;

	private long companyid;

	private String purchase_date;

	private String payment_type;

	private long phone_number;

	@Column(length = 200)
	private String description;
	
	private int invoice_no;

	private long total_qty;

	private double total_discount;

	private double total_tax;

	private double total_amount;

	private double roundoff;
	private double roundoff_amount;

	private double received;

	private double balance;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_purchase_id", referencedColumnName = "purchase_id")
	private List<PurchaseList> purchaselist;



	public Purchase(List<PurchaseList> purchaselist) {
		super();
		this.purchaselist = purchaselist;
	}



	public long getPurchase_id() {
		return purchase_id;
	}



	public void setPurchase_id(long purchase_id) {
		this.purchase_id = purchase_id;
	}



	public long getCompanyid() {
		return companyid;
	}



	public void setCompanyid(long companyid) {
		this.companyid = companyid;
	}



	public String getPurchase_date() {
		return purchase_date;
	}



	public void setPurchase_date(String purchase_date) {
		this.purchase_date = purchase_date;
	}



	public String getPayment_type() {
		return payment_type;
	}



	public void setPayment_type(String payment_type) {
		this.payment_type = payment_type;
	}



	public long getPhone_number() {
		return phone_number;
	}



	public void setPhone_number(long phone_number) {
		this.phone_number = phone_number;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public int getInvoice_no() {
		return invoice_no;
	}



	public void setInvoice_no(int invoice_no) {
		this.invoice_no = invoice_no;
	}






	public long getTotal_qty() {
		return total_qty;
	}



	public void setTotal_qty(long total_qty) {
		this.total_qty = total_qty;
	}



	public double getTotal_discount() {
		return total_discount;
	}



	public void setTotal_discount(double total_discount) {
		this.total_discount = total_discount;
	}



	public double getTotal_tax() {
		return total_tax;
	}



	public void setTotal_tax(double total_tax) {
		this.total_tax = total_tax;
	}



	public double getTotal_amount() {
		return total_amount;
	}



	public void setTotal_amount(double total_amount) {
		this.total_amount = total_amount;
	}



	public double getRoundoff() {
		return roundoff;
	}



	public void setRoundoff(double roundoff) {
		this.roundoff = roundoff;
	}



	public double getRoundoff_amount() {
		return roundoff_amount;
	}



	public void setRoundoff_amount(double roundoff_amount) {
		this.roundoff_amount = roundoff_amount;
	}



	public double getReceived() {
		return received;
	}



	public void setReceived(double received) {
		this.received = received;
	}



	public double getBalance() {
		return balance;
	}



	public void setBalance(double balance) {
		this.balance = balance;
	}



	public List<PurchaseList> getPurchaselist() {
		return purchaselist;
	}



	public void setPurchaselist(List<PurchaseList> purchaselist) {
		this.purchaselist = purchaselist;
	}



	@Override
	public String toString() {
		return "Purchase [purchase_id=" + purchase_id + ", companyid=" + companyid + ", purchase_date=" + purchase_date
				+ ", payment_type=" + payment_type + ", phone_number=" + phone_number + ", description=" + description
				+ ", invoice_no=" + invoice_no + ", total_qty=" + total_qty + ", total_discount=" + total_discount
				+ ", total_tax=" + total_tax + ", total_amount=" + total_amount + ", roundoff=" + roundoff
				+ ", roundoff_amount=" + roundoff_amount + ", received=" + received + ", balance=" + balance
				+ ", purchaselist=" + purchaselist + "]";
	}



	


	public Purchase(long purchase_id, long companyid, String purchase_date, String payment_type, long phone_number,
			String description, int invoice_no, long total_qty, double total_discount, double total_tax,
			double total_amount, double roundoff, double roundoff_amount, double received, double balance,
			List<PurchaseList> purchaselist) {
		super();
		this.purchase_id = purchase_id;
		this.companyid = companyid;
		this.purchase_date = purchase_date;
		this.payment_type = payment_type;
		this.phone_number = phone_number;
		this.description = description;
		this.invoice_no = invoice_no;
		this.total_qty = total_qty;
		this.total_discount = total_discount;
		this.total_tax = total_tax;
		this.total_amount = total_amount;
		this.roundoff = roundoff;
		this.roundoff_amount = roundoff_amount;
		this.received = received;
		this.balance = balance;
		this.purchaselist = purchaselist;
	}



	public Purchase() {
		super();
	}



}
