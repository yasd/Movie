package com.tz.online.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="BSBOOK")
public class Book implements Serializable {

	private static final long serialVersionUID = 7564776194312963061L;
	@Id
	@GeneratedValue(generator="BOOKID",strategy=GenerationType.AUTO)
	@SequenceGenerator(name="BOOKID", sequenceName="bs_bookId", allocationSize=1)
	private Long bookId;
	@Column
	private String isbn;//编号
	@Column
	private String author;
	@Column
	private String name;
	@Column
	private String publisher;//出版社
	@Column
	@Temporal(TemporalType.DATE)
	private Date publiher;//出版日期
	@Column
	private double oldPrice;//原价
	@Column
	private double newPrice;//新价格
	@Column
	private String author_loc;//作者地区
	
	@Column(name="suit")
	@Enumerated(EnumType.STRING)
	private Suit suit;//是否是套装
	
	@Column(name="category")
	@Enumerated(EnumType.STRING)
	private Category category;//图书类别
	
	@Column
	private String info;
	@Column
	private String imgurl;
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Book(String isbn, String author, String name, String publisher, Date publiher, double oldPrice,
			double newPrice, String author_loc, Suit suit, Category category, String info, String imgurl) {
		super();
		this.isbn = isbn;
		this.author = author;
		this.name = name;
		this.publisher = publisher;
		this.publiher = publiher;
		this.oldPrice = oldPrice;
		this.newPrice = newPrice;
		this.author_loc = author_loc;
		this.suit = suit;
		this.category = category;
		this.info = info;
		this.imgurl = imgurl;
	}
	public Long getBookId() {
		return bookId;
	}
	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public Date getPubliher() {
		return publiher;
	}
	public void setPubliher(Date publiher) {
		this.publiher = publiher;
	}
	public double getOldPrice() {
		return oldPrice;
	}
	public void setOldPrice(double oldPrice) {
		this.oldPrice = oldPrice;
	}
	public double getNewPrice() {
		return newPrice;
	}
	public void setNewPrice(double newPrice) {
		this.newPrice = newPrice;
	}
	public String getAuthor_loc() {
		return author_loc;
	}
	public void setAuthor_loc(String author_loc) {
		this.author_loc = author_loc;
	}
	public Suit getSuit() {
		return suit;
	}
	public void setSuit(Suit suit) {
		this.suit = suit;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getImgurl() {
		return imgurl;
	}
	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Book [bookId=").append(bookId).append(", isbn=").append(isbn).append(", author=").append(author)
				.append(", name=").append(name).append(", publisher=").append(publisher).append(", publiher=")
				.append(publiher).append(", oldPrice=").append(oldPrice).append(", newPrice=").append(newPrice)
				.append(", author_loc=").append(author_loc).append(", suit=").append(suit).append(", category=")
				.append(category).append(", info=").append(info).append(", imgurl=").append(imgurl).append("]");
		return builder.toString();
	}
	
	
	
	}
