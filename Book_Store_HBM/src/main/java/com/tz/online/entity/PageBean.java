package com.tz.online.entity;

import java.util.List;

/**
 * 
 * 本类用来演示:分页组件
 *  
 * @author 代亚顺
 *
 * 2017年6月27日上午10:26:43
 */
public class PageBean<T> {
	
	//主要对象的集合
	private List<T> list;
	
	//以下是分页属性
	private Long pageNow;//当前页
	
	private Long pageSize;//每页显示多少条.
	
	private Long pageCount;//总共有多少页.
	
	public PageBean() {
		// TODO Auto-generated constructor stub
	}

	public PageBean(Long pageNow, Long pageSize, Long pageCount) {
		super();
		this.pageNow = pageNow;
		this.pageSize = pageSize;
		this.pageCount = pageCount;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public Long getPageNow() {
		return pageNow;
	}

	public void setPageNow(Long pageNow) {
		this.pageNow = pageNow;
	}

	public Long getPageSize() {
		return pageSize;
	}

	public void setPageSize(Long pageSize) {
		this.pageSize = pageSize;
	}

	public Long getPageCount() {
		return pageCount;
	}

	public void setPageCount(Long pageCount) {
		this.pageCount = pageCount;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PageBean [pageNow=");
		builder.append(pageNow);
		builder.append(", pageSize=");
		builder.append(pageSize);
		builder.append(", pageCount=");
		builder.append(pageCount);
		builder.append("]");
		return builder.toString();
	}
}
