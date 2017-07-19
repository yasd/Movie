package com.tz.online.user;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Entity
@Table(name="BSUSER")
public class User implements Serializable {

	private static final long serialVersionUID = 7564776194312963061L;

	@Id
	@GeneratedValue(generator="USERID",strategy=GenerationType.AUTO)
	@SequenceGenerator(name="USERID", sequenceName="bs_userId", allocationSize=1)
	private Long userId;
	@Column(length=200,nullable=false,name="username")
	private String userName;
	@Column(length=200,nullable=false,name="password")
	private String passWord;
	@Column(name="email")
	private String email;
	@Column(name="phone")
	private String phone;
	@Column(name="company")
	private String company;
	@Column(name="address")
	private String address;
	public User() {
		super();
	}
	public User(String userName, String passWord, String email, String phone, String company, String address) {
		super();
		this.userName = userName;
		this.passWord = passWord;
		this.email = email;
		this.phone = phone;
		this.company = company;
		this.address = address;
	}
	public User(Long userId, String userName, String passWord, String email, String phone, String company,
			String address) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.passWord = passWord;
		this.email = email;
		this.phone = phone;
		this.company = company;
		this.address = address;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [userId=").append(userId).append(", userName=").append(userName).append(", passWord=")
				.append(passWord).append(", email=").append(email).append(", phone=").append(phone).append(", company=")
				.append(company).append(", address=").append(address).append("]");
		return builder.toString();
	}
	
	
}
