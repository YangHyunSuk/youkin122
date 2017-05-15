package com.naver.dbtjd122.domain;


//?˜?´ì§? ì²˜ë¦¬ë¥? ?œ„?•´ ?•„?š”?•œ ?°?´?„°ë¥? ???¥?•˜?Š”?´?˜?Š¤ 
public class PageMaker {
//?˜„? œ?˜?´ì§?ë²ˆí˜¸?? ?˜?´ì§??‹¹ ?°?´?„° ì¶œë ¥ê°œìˆ˜
private Criteria criteria;
//?˜?´ì§??‹¹ ?˜?´ì§?ë²ˆí˜¸ì¶œë ¥ê°œìˆ˜
private int displayPageNum = 10;
//?°?´?„°? „ì²´ê°œ?ˆ˜
private int totalCount;
//?‹œ?‘?•˜?Š” ?˜?´ì§? ë²ˆí˜¸?? ??‚˜?Š” ë²ˆí˜¸?˜?´ì§?

private int startPage, endPage;
//?´? „ê³? ?‹¤?Œë§í¬ì¶œë ¥?—¬ë¶?
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
//totalcount ?˜ ê°’ì´ ?„¤? •?˜ë©?
	//?‚˜ë¨¸ì? ?°?´?„°ë¥? ê³„ì‚°?•˜?Š” ë©”ì„œ?“œë¥? ?˜¸ì¶? 
calcData();
}
public void calcData(){
	//?˜„?¬?˜?´ì§? ë²ˆí˜¸ 			criteria.page
	//?˜?´ì§??‹¹ ?°?´?„° ì¶œë ¥ê°œìˆ˜criteria.perPageNum
	//? „ì²´ë°?´?„° ê°œìˆ˜ 		totalCount
	//?˜?´ì§? ë²ˆí˜¸ì¶œë ¥ê°œìˆ˜ displayPagenNum

	int imsi =criteria.getPage()/displayPageNum;
	if(criteria.getPage()%displayPageNum==0){
		imsi=imsi-1;
	}
startPage=imsi*displayPageNum+1;
endPage=startPage+displayPageNum-1;
//? „ì²? ?˜?´ì§? ê°œìˆ˜ ë³´ë‹¤ endpageê°? ?”?¬ë©´ì•ˆ?œ?‹¤
//? „ì²? ?˜?´ì§? ê°œìˆ˜êµ¬í•˜ê¸°ã…
int pageCount =totalCount/criteria.getPerPageNum();
if(totalCount%criteria.getPerPageNum()!=0){
	pageCount=pageCount+1;
}
if(endPage>pageCount){
	endPage=pageCount;
}
//startPageê°? 1?´ë©? false ê·¸ë ‡ì§? ?•Š?œ¼ë©? true
prev=startPage==1?false:true;
//endPageê°? ? „ì²? ?˜?´ì§? ê°œìˆ˜?? ê°™ìœ¼ë©? false ê·¸ë ‡ì§? ?•Š?œ¼ë©? true
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
