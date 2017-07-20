package com.tz.online.order;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.alibaba.fastjson.annotation.JSONField;
@Entity
@Table(name="BSORDERITEM")
public class OrderItem implements Serializable {

	private static final long serialVersionUID = 7564776194312963061L;

	@Id
	@GeneratedValue
	private Long itemId;//商品明细标识
	@Column
	private String book_isbn;
	@Column
	private String book_name;
	@Column
	private String book_author;
	@Column
	private double ccc;
	@Column
	private int count;//购买数量
	@Column
	private double allPrice;//此明细的总价格
	@ManyToOne
	@JoinColumn(name="orderId")
	private Order order;//此明细的所属订单
	public OrderItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrderItem(Long itemId, String book_isbn, String book_name, String book_author, int ccc, int count,
			double allPrice, Order order) {
		super();
		this.itemId = itemId;
		this.book_isbn = book_isbn;
		this.book_name = book_name;
		this.book_author = book_author;
		this.ccc = ccc;
		this.count = count;
		this.allPrice = allPrice;
		this.order = order;
	}
	public OrderItem(String book_isbn, String book_name, String book_author, int ccc, int count, double allPrice,
			Order order) {
		super();
		this.book_isbn = book_isbn;
		this.book_name = book_name;
		this.book_author = book_author;
		this.ccc = ccc;
		this.count = count;
		this.allPrice = allPrice;
		this.order = order;
	}
	
	public Long getItemId() {
		return itemId;
	}
	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}
	public String getBook_isbn() {
		return book_isbn;
	}
	public void setBook_isbn(String book_isbn) {
		this.book_isbn = book_isbn;
	}
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	public String getBook_author() {
		return book_author;
	}
	public void setBook_author(String book_author) {
		this.book_author = book_author;
	}
	public double getCcc() {
		return ccc;
	}
	public void setCcc(double ccc) {
		this.ccc = ccc;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public double getAllPrice() {
		return allPrice;
	}
	public void setAllPrice(double allPrice) {
		this.allPrice = allPrice;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OrderItem [itemId=").append(itemId).append(", book_isbn=").append(book_isbn)
				.append(", book_name=").append(book_name).append(", book_author=").append(book_author).append(", ccc=")
				.append(ccc).append(", count=").append(count).append(", allPrice=").append(allPrice).append(", order=")
				.append(order).append("]");
		return builder.toString();
	}
	

	
	
	
}
