package com.tz.online.order;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.tz.online.entity.Address;
import com.tz.online.user.User;
@Entity
@Table(name="BSORDER")
public class Order implements Serializable {

	private static final long serialVersionUID = 7564776194312963061L;
	
	@Id
	@GeneratedValue
	private Long orderId;//订单ID标识
	@Column
	private String orderNum;//订单标号
	@Column
	@Temporal(TemporalType.DATE)
	private Date createDate;//下单日期
	@OneToMany(cascade={CascadeType.ALL},mappedBy="order")
	private Set<OrderItem> items;//订单中的商品明细
	@ManyToOne
	@JoinColumn(name="userId")
	private User user;//订单所属用户
	@ManyToOne
	@JoinColumn(name="book_addrdssId")
	private Address address;//订单的发货地址
	@Column
	@Enumerated(EnumType.STRING)
	private OrderStatus orderStatus;//订单状态
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Order(String orderNum, Date createDate, Set<OrderItem> items, User user, Address address,
			OrderStatus orderStatus) {
		super();
		this.orderNum = orderNum;
		this.createDate = createDate;
		this.items = items;
		this.user = user;
		this.address = address;
		this.orderStatus = orderStatus;
	}
	public Order(Long orderId, String orderNum, Date createDate, Set<OrderItem> items, User user, Address address,
			OrderStatus orderStatus) {
		super();
		this.orderId = orderId;
		this.orderNum = orderNum;
		this.createDate = createDate;
		this.items = items;
		this.user = user;
		this.address = address;
		this.orderStatus = orderStatus;
	}
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public String getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Set<OrderItem> getItems() {
		return items;
	}
	public void setItems(Set<OrderItem> items) {
		this.items = items;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public OrderStatus getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Order [orderId=").append(orderId).append(", orderNum=").append(orderNum).append(", createDate=")
				.append(createDate).append(", items=").append(items).append(", user=").append(user).append(", address=")
				.append(address).append(", orderStatus=").append(orderStatus).append("]");
		return builder.toString();
	}
	
	
}
