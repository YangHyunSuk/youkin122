package com.naver.dbtjd122.domain;

import java.sql.Date;

public class BoardVO {
private int bno;
private String title;
private String content;
private String writer;
private Date regdate;
private int readcnt;
private String ip;
private int replyCnt;

public int getReplyCnt() {
	return replyCnt;
}
public void setReplyCnt(int replyCnt) {
	this.replyCnt = replyCnt;
}
public int getBno() {
	return bno;
}
public void setBno(int bno) {
	this.bno = bno;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}
public String getWriter() {
	return writer;
}
public void setWriter(String writer) {
	this.writer = writer;
}
public Date getRegdate() {
	return regdate;
}
public void setRegdate(Date regdate) {
	this.regdate = regdate;
}
public int getReadcnt() {
	return readcnt;
}
public void setReadcnt(int readcnt) {
	this.readcnt = readcnt;
}
public String getIp() {
	return ip;
}
public void setIp(String ip) {
	this.ip = ip;
}
@Override
public String toString() {
	return "BoardVO [bno=" + bno + ", title=" + title + ", content=" + content + ", writer=" + writer + ", regdate="
			+ regdate + ", readcnt=" + readcnt + ", ip=" + ip + "]";
}

}
