package com.java.business.HeadOffice.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="outsource")
public class OutSource {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long companyid;
   
	@NotNull(message="company name should not be empty")
	@Size(min=1,max=40)
    @Column(name="companyname",nullable=false)
    private String companyname;

	@NotNull(message="GST/UIN should not be empty")
	@Size(min=1,max=40)
	@Column(name="gstin",nullable=false)
	private String gstin ;

	@NotNull(message="email should mnot be empty")
	@Column(name="email", nullable=false)
	private String email ;

	@NotNull(message="Enter the details name")
	@Column(name="dealername", nullable=false)
	private String dealername;

	@NotNull(message="Enter the Address")
	@Column(name="address", nullable=false)
	private String address;

	@NotNull(message="Enter the date")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="date")
	private Date date;

	@NotNull(message="Enter the contact number")
	@Size(min=10, max=10)
	@Column(name="contact", nullable=false)
	private Long contact;

	@NotNull(message="Enter the Tax Id")
	@Column(name="taxid", nullable=false)
	private String taxid;

	
	@NotNull(message="Enter the AccountNumber")
	@Column(name="accountnumber", nullable=false)
	private long accountnumber;

	@NotNull(message="Enter the city")
	@Column(name="city",nullable=false)
	private String city;

	@NotNull(message="Enter the country")
	@Column(name="country", nullable=false)
	private String country;

	@NotNull(message="Enter the district")
	@Column(name="district", nullable=false)
	private String district;

	@NotNull(message="Enter the state")
	@Column(name="state", nullable=false)
	private String state;
	
	@NotNull(message="Enter the Zipcode")
	@Column(name="zipcode", nullable=false)
	private String zipcode;

	public long getCompanyid() {
		return companyid;
	}

	public void setCompanyid(long companyid) {
		this.companyid = companyid;
	}

	public String getCompanyname() {
		return companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

	public String getGstin() {
		return gstin;
	}

	public void setGstin(String gstin) {
		this.gstin = gstin;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDealername() {
		return dealername;
	}

	public void setDealername(String dealername) {
		this.dealername = dealername;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Long getContact() {
		return contact;
	}

	public void setContact(Long contact) {
		this.contact = contact;
	}

	public String getTaxid() {
		return taxid;
	}

	public void setTaxid(String taxid) {
		this.taxid = taxid;
	}

	public long getAccountnumber() {
		return accountnumber;
	}

	public void setAccountnumber(long accountnumber) {
		this.accountnumber = accountnumber;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public OutSource(long companyid,
			@NotNull(message = "company name should not be empty") @Size(min = 1, max = 40) String companyname,
			@NotNull(message = "GST/UIN should not be empty") @Size(min = 1, max = 40) String gstin,
			@NotNull(message = "email should mnot be empty") String email,
			@NotNull(message = "Enter the details name") String dealername,
			@NotNull(message = "Enter the Address") String address, @NotNull(message = "Enter the date") Date date,
			@NotNull(message = "Enter the contact number") @Size(min = 10, max = 10) Long contact,
			@NotNull(message = "Enter the Tax Id") String taxid,
			@NotNull(message = "Enter the AccountNumber") long accountnumber,
			@NotNull(message = "Enter the city") String city, @NotNull(message = "Enter the country") String country,
			@NotNull(message = "Enter the district") String district,
			@NotNull(message = "Enter the state") String state,
			@NotNull(message = "Enter the Zipcode") String zipcode) {
		super();
		this.companyid = companyid;
		this.companyname = companyname;
		this.gstin = gstin;
		this.email = email;
		this.dealername = dealername;
		this.address = address;
		this.date = date;
		this.contact = contact;
		this.taxid = taxid;
		this.accountnumber = accountnumber;
		this.city = city;
		this.country = country;
		this.district = district;
		this.state = state;
		this.zipcode = zipcode;
	}

	public OutSource() {
		super();
	}

	@Override
	public String toString() {
		return "OutSource [companyid=" + companyid + ", companyname=" + companyname + ", gstin=" + gstin + ", email="
				+ email + ", dealername=" + dealername + ", address=" + address + ", date=" + date + ", contact="
				+ contact + ", taxid=" + taxid + ", accountnumber=" + accountnumber + ", city=" + city + ", country="
				+ country + ", district=" + district + ", state=" + state + ", zipcode=" + zipcode + "]";
	}
	
	
	
}
