package com.naver.dbtjd122.domain;



//형재 페이지 번호와 페이지 당 출력개수를 저장할클래스 
public class Criteria {
	private int page;
	private int perPageNum;
	//생성자는 인스턴스 변수에 기본값을 할당할려고
	public Criteria() {
		super();
	page= 1;
		
	perPageNum=10;
	}
	//현재 페이지 번호와 페이지 당 데이터 개수를 가지고 데이터 시작번호 찾아오는 메서드
	public int getPageStart(){
		int start =(page -1)* perPageNum +1;
		return start;
		
	}
	//접근자 메서드 
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
