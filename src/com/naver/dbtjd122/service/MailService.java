package com.naver.dbtjd122.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface MailService {
	//메일 보내기위한 리퀘스트 및 리스판스 
public void sendMail(HttpServletRequest request,HttpServletResponse response);
//프록시
public void download(HttpServletRequest request, HttpServletResponse response);
//홈2 작성메세지 보내기
public void home2mail(HttpServletRequest request, HttpServletResponse response);
}
