package com.tz.online.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.tz.online.user.User;

@Entity
@Table(name="BSADDRESS")
public class Address implements Serializable {

	private static final long serialVersionUID = 7564776194312963061L;
	@Id
	@GeneratedValue
	private Long addressId;//地址ID
	@Column
	private String area;//区域
	@Column
	private String detailAddrdss;//详细地址
	@Column
	private String emailCode;//邮编
	@Column
	private String reciver;//收件人
	@Column
	private String tel;//手机号
	@Column
	private String isDefault;//是否默认收货地址：0否，1是
	@ManyToOne
	@JoinColumn(name="book_userId")
	private User user;//地址所属用户
	public Address() {
		super();
	}
	public Address(String area, String detailAddrdss, String emailCode, String reciver, String tel, String isDefault,
			User user) {
		super();
		this.area = area;
		this.detailAddrdss = detailAddrdss;
		this.emailCode = emailCode;
		this.reciver = reciver;
		this.tel = tel;
		this.isDefault = isDefault;
		this.user = user;
	}
	public Address(Long addressId, String area, String detailAddrdss, String emailCode, String reciver, String tel,
			String isDefault, User user) {
		super();
		this.addressId = addressId;
		this.area = area;
		this.detailAddrdss = detailAddrdss;
		this.emailCode = emailCode;
		this.reciver = reciver;
		this.tel = tel;
		this.isDefault = isDefault;
		this.user = user;
	}
	public Long getAddressId() {
		return addressId;
	}
	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getDetailAddrdss() {
		return detailAddrdss;
	}
	public void setDetailAddrdss(String detailAddrdss) {
		this.detailAddrdss = detailAddrdss;
	}
	public String getEmailCode() {
		return emailCode;
	}
	public void setEmailCode(String emailCode) {
		this.emailCode = emailCode;
	}
	public String getReciver() {
		return reciver;
	}
	public void setReciver(String reciver) {
		this.reciver = reciver;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getIsDefault() {
		return isDefault;
	}
	public void setIsDefault(String isDefault) {
		this.isDefault = isDefault;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Address [addressId=").append(addressId).append(", area=").append(area)
				.append(", detailAddrdss=").append(detailAddrdss).append(", emailCode=").append(emailCode)
				.append(", reciver=").append(reciver).append(", tel=").append(tel).append(", isDefault=")
				.append(isDefault).append(", user=").append(user).append("]");
		return builder.toString();
	}
	
}
