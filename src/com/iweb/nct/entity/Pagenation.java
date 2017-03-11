package com.iweb.nct.entity;

import java.util.List;

public class Pagenation {
	private int totalSize;	//总记录数
	private int totalPage;	//总页数
	private int pageSize;	//每页多少条记录
	private int currentPage; //当前页
	private List pageDate;
	
	public int getCurrentPage() {
		return currentPage;
	}

	public void setPageDate(List pageDate) {
		this.pageDate = pageDate;
	}

	public List getPageDate() {
		return pageDate;
	}

	public Pagenation(int totalSize, int pageSize, int currentPage){
		this.totalSize = totalSize;
		this.pageSize = pageSize;
		this.currentPage = currentPage;	
		this.totalPage = (int)Math.ceil(totalSize / (double)pageSize);
	}

	public int getTotalPage() {
		return totalPage;
	}

	public int getPageSize() {
		return pageSize;
	}	
}
