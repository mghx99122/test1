package com.schmidt.dbwm.common;

public class AbstractQuery {
	
	
	//----------------------------- ��ҳʵ�� --------------------------------------//
	private int pageNumber = -1;
	private int pageSize = 10;
	//��ʼ�����ĵط�
	private int indexNum;
	//�ܵ�ҳ��
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
