package com.naver.dbtjd122.domain;



//??¬ ??΄μ§? λ²νΈ?? ??΄μ§? ?Ή μΆλ ₯κ°μλ₯? ???₯? ?΄??€ 
public class Criteria {
	private int page;
	private int perPageNum;
	//??±?? ?Έ?€?΄?€ λ³??? κΈ°λ³Έκ°μ ? ?Ή? ? €κ³?
	public Criteria() {
		super();
	page= 1;
		
	perPageNum=10;
	}
	//??¬ ??΄μ§? λ²νΈ?? ??΄μ§? ?Ή ?°?΄?° κ°μλ₯? κ°?μ§?κ³? ?°?΄?° ??λ²νΈ μ°Ύμ?€? λ©μ?
	public int getPageStart(){
		int start =(page -1)* perPageNum +1;
		return start;
		
	}
	//? κ·Όμ λ©μ? 
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPerPageNum() {
		return perPageNum;
	}
	public void setPerPageNum(int perPageNum) {
		this.perPageNum = perPageNum;
	}
	@Override
	public String toString() {
		return "Criteria [page=" + page + ", perPageNum=" + perPageNum + "]";
	}
	
}
