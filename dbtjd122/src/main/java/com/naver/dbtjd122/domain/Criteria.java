package com.naver.dbtjd122.domain;



//?˜•?¬ ?˜?´ì§? ë²ˆí˜¸?? ?˜?´ì§? ?‹¹ ì¶œë ¥ê°œìˆ˜ë¥? ???¥?• ?´?˜?Š¤ 
public class Criteria {
	private int page;
	private int perPageNum;
	//?ƒ?„±??Š” ?¸?Š¤?„´?Š¤ ë³??ˆ˜?— ê¸°ë³¸ê°’ì„ ?• ?‹¹?• ? ¤ê³?
	public Criteria() {
		super();
	page= 1;
		
	perPageNum=10;
	}
	//?˜„?¬ ?˜?´ì§? ë²ˆí˜¸?? ?˜?´ì§? ?‹¹ ?°?´?„° ê°œìˆ˜ë¥? ê°?ì§?ê³? ?°?´?„° ?‹œ?‘ë²ˆí˜¸ ì°¾ì•„?˜¤?Š” ë©”ì„œ?“œ
	public int getPageStart(){
		int start =(page -1)* perPageNum +1;
		return start;
		
	}
	//? ‘ê·¼ì ë©”ì„œ?“œ 
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
