package com.schmidt.dbwm.common;

public class AbstractQuery {
	
	
	//----------------------------- 分页实现 --------------------------------------//
	private int pageNumber = -1;
	private int pageSize = 10;
	//开始检索的地方
	private int indexNum;
	//总的页数
	private int pageCount ;	
	
	public int getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getIndexNum() {
		return indexNum;
	}
	public void setIndexNum(int indexNum) {
		this.indexNum = indexNum;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
}
