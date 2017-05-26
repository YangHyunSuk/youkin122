package com.naver.dbtjd122.domain;


//페이징 처리를 위해 필요한 데이터를 저장하는클래스 
public class PageMaker {
//현제페이지번호와 페이지당 데이터 출력개수
private Criteria criteria;
//페이지당 페이지번호출력개수
private int displayPageNum = 10;
//데이터전체개수
private int totalCount;
//시작하는 페이지 번호와 끝나는 번호페이지

private int startPage, endPage;
//이전과 다음링크출력여부
private boolean prev,next;



public Criteria getCriteria() {
	return criteria;
}
public void setCriteria(Criteria criteria) {
	this.criteria = criteria;
}
public int getDisplayPageNum() {
	return displayPageNum;
}
public void setDisplayPageNum(int displayPageNum) {
	this.displayPageNum = displayPageNum;
}
public int getTotalCount() {
	return totalCount;
}
public void setTotalCount(int totalCount) {
	this.totalCount = totalCount;
//totalcount 의 값이 설정되면
	//나머지 데이터를 계산하는 메서드를 호출 
calcData();
}
public void calcData(){
	//현재페이지 번호 			criteria.page
	//페이지당 데이터 출력개수criteria.perPageNum
	//전체데이터 개수 		totalCount
	//페이지 번호출력개수 displayPagenNum

	int imsi =criteria.getPage()/displayPageNum;
	if(criteria.getPage()%displayPageNum==0){
		imsi=imsi-1;
	}
startPage=imsi*displayPageNum+1;
endPage=startPage+displayPageNum-1;
//전체 페이지 개수 보다 endpage가 더크면안된다
//전체 페이지 개수구하기ㅏ
int pageCount =totalCount/criteria.getPerPageNum();
if(totalCount%criteria.getPerPageNum()!=0){
	pageCount=pageCount+1;
}
if(endPage>pageCount){
	endPage=pageCount;
}
//startPage가 1이면 false 그렇지 않으면 true
prev=startPage==1?false:true;
//endPage가 전체 페이지 개수와 같으면 false 그렇지 않으면 true
next=endPage==pageCount?false:true;

}

public int getStartPage() {
	return startPage;
}
public void setStartPage(int startPage) {
	this.startPage = startPage;
}
public int getEndPage() {
	return endPage;
}
public void setEndPage(int endPage) {
	this.endPage = endPage;
}
public boolean isPrev() {
	return prev;
}
public void setPrev(boolean prev) {
	this.prev = prev;
}
public boolean isNext() {
	return next;
}
public void setNext(boolean next) {
	this.next = next;
}
@Override
public String toString() {
	return "PageMaker [criteria=" + criteria + ", displayPageNum=" + displayPageNum + ", totalCount=" + totalCount
			+ ", startPage=" + startPage + ", endPage=" + endPage + ", prev=" + prev + ", next=" + next + "]";
}



}
