package com.java.business.HeadOffice.entity;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "member")
public class AddMember {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, unique = true)
	private Long memberid;

	@NotNull(message = "Customer name is required.")
	@Size(min = 2, max = 50, message = "Customer name must be between 2 and 50 characters.")
	@Column(name = "name", nullable = false)
	private String name;

	@NotNull(message = "Customer phone is required.")
	@Size(max = 10, message = "Phone Number must be of 10 digits only.")
	@Column(name = "phone", nullable = false, unique = true)
	private Long phone;

	@NotNull(message = "Customer email is required.")
	@Size(min = 5, max = 100, message = "Email must be between 11 and 100 characters.")
	@Column(name = "email", nullable = false, unique = true)
	private String email;

	@NotNull(message = "provide a dob")
	@Column(name = "dob")
	private String dob;

	@NotNull(message = "Customer password is required.")
	@Size(min = 6, max = 60, message = "Password must be between 6 and 60 characters.")
	@Column(name = "password", nullable = false)
	private String password;



	@NotNull(message = "Customer gender is required.")
	@Size(min = 4, max = 11, message = "Gender is required.")
	@Column(name = "gender", nullable = false)
	private String gender;

	@NotNull(message = "Customer aadharno is required.")
	@Size(min = 6, max = 12, message = "aadharno is required.")
	@Column(name = "aadharno", nullable = false, unique = true)
	private Long aadharno;

	@NotNull(message = "Customer pan_no is required.")
	@Size(min = 6, max = 12, message = "pano is required.")
	@Column(name = "pan_no", nullable = false, unique = true)
	private String panno;

	@NotNull(message = "Customer address is required.")
	@Column(name = "address", nullable = false, length = 500)
	private String address;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date", nullable = false)
	private Date date;

//	@Column(name = "role")
//	private String role;

	@Column(name = "description")
	private String description;

	public Long getMemberid() {
		return memberid;
	}

	public void setMemberid(Long memberid) {
		this.memberid = memberid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Long getAadharno() {
		return aadharno;
	}

	public void setAadharno(Long aadharno) {
		this.aadharno = aadharno;
	}

	public String getPanno() {
		return panno;
	}

	public void setPanno(String panno) {
		this.panno = panno;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public AddMember(Long memberid,
			@NotNull(message = "Customer name is required.") @Size(min = 2, max = 50, message = "Customer name must be between 2 and 50 characters.") String name,
			@NotNull(message = "Customer phone is required.") @Size(max = 10, message = "Phone Number must be of 10 digits only.") Long phone,
			@NotNull(message = "Customer email is required.") @Size(min = 5, max = 100, message = "Email must be between 11 and 100 characters.") String email,
			@NotNull(message = "provide a dob") String dob,
			@NotNull(message = "Customer password is required.") @Size(min = 6, max = 60, message = "Password must be between 6 and 60 characters.") String password,
			@NotNull(message = "Customer gender is required.") @Size(min = 4, max = 11, message = "Gender is required.") String gender,
			@NotNull(message = "Customer aadharno is required.") @Size(min = 6, max = 12, message = "aadharno is required.") Long aadharno,
			@NotNull(message = "Customer pan_no is required.") @Size(min = 6, max = 12, message = "pano is required.") String panno,
			@NotNull(message = "Customer address is required.") String address, Date date, String description) {
		super();
		this.memberid = memberid;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.dob = dob;
		this.password = password;
		this.gender = gender;
		this.aadharno = aadharno;
		this.panno = panno;
		this.address = address;
		this.date = date;
		this.description = description;
	}

	@Override
	public String toString() {
		return "AddMember [memberid=" + memberid + ", name=" + name + ", phone=" + phone + ", email=" + email + ", dob="
				+ dob + ", password=" + password + ", gender=" + gender + ", aadharno=" + aadharno + ", panno=" + panno
				+ ", address=" + address + ", date=" + date + ", description=" + description + "]";
	}

	public AddMember() {
		super();
	}



	// getter and setter


}
