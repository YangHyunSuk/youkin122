package com.naver.dbtjd122.domain;


//??΄μ§? μ²λ¦¬λ₯? ??΄ ??? ?°?΄?°λ₯? ???₯???΄??€ 
public class PageMaker {
//?? ??΄μ§?λ²νΈ?? ??΄μ§??Ή ?°?΄?° μΆλ ₯κ°μ
private Criteria criteria;
//??΄μ§??Ή ??΄μ§?λ²νΈμΆλ ₯κ°μ
private int displayPageNum = 10;
//?°?΄?°? μ²΄κ°?
private int totalCount;
//???? ??΄μ§? λ²νΈ?? ??? λ²νΈ??΄μ§?

private int startPage, endPage;
//?΄? κ³? ?€?λ§ν¬μΆλ ₯?¬λΆ?
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
//totalcount ? κ°μ΄ ?€? ?λ©?
	//?λ¨Έμ? ?°?΄?°λ₯? κ³μ°?? λ©μ?λ₯? ?ΈμΆ? 
calcData();
}
public void calcData(){
	//??¬??΄μ§? λ²νΈ 			criteria.page
	//??΄μ§??Ή ?°?΄?° μΆλ ₯κ°μcriteria.perPageNum
	//? μ²΄λ°?΄?° κ°μ 		totalCount
	//??΄μ§? λ²νΈμΆλ ₯κ°μ displayPagenNum

	int imsi =criteria.getPage()/displayPageNum;
	if(criteria.getPage()%displayPageNum==0){
		imsi=imsi-1;
	}
startPage=imsi*displayPageNum+1;
endPage=startPage+displayPageNum-1;
//? μ²? ??΄μ§? κ°μ λ³΄λ€ endpageκ°? ??¬λ©΄μ??€
//? μ²? ??΄μ§? κ°μκ΅¬νκΈ°γ
int pageCount =totalCount/criteria.getPerPageNum();
if(totalCount%criteria.getPerPageNum()!=0){
	pageCount=pageCount+1;
}
if(endPage>pageCount){
	endPage=pageCount;
}
//startPageκ°? 1?΄λ©? false κ·Έλ μ§? ??Όλ©? true
prev=startPage==1?false:true;
//endPageκ°? ? μ²? ??΄μ§? κ°μ?? κ°μΌλ©? false κ·Έλ μ§? ??Όλ©? true
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
