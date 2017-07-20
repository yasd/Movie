package com.tz.online.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name="BSIMAGE")
public class Image implements Serializable {

	private static final long serialVersionUID = 7564776194312963061L;
	@Id
	@GeneratedValue
	private Long imgId;
	@Column
	private String url;
	@OneToOne
	@JoinColumn(name="bookId",insertable=true,unique=true)
	private Book book;
	@Column
	private String info;
	public Image() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Image(String url, Book book, String info) {
		super();
		this.url = url;
		this.book = book;
		this.info = info;
	}
	public Image(Long imgId, String url, Book book, String info) {
		super();
		this.imgId = imgId;
		this.url = url;
		this.book = book;
		this.info = info;
	}
	public Long getImgId() {
		return imgId;
	}
	public void setImgId(Long imgId) {
		this.imgId = imgId;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Image [imgId=").append(imgId).append(", url=").append(url).append(", book=").append(book)
				.append(", info=").append(info).append("]");
		return builder.toString();
	}
	
	
}
