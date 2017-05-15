package com.naver.dbtjd122.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface MailService {
	//ë©”ì¼ ë³´ë‚´ê¸°ìœ„?•œ ë¦¬í?˜ìŠ¤?Š¸ ë°? ë¦¬ìŠ¤?Œ?Š¤ 
public void sendMail(HttpServletRequest request,HttpServletResponse response);
//?”„ë¡ì‹œ
public void download(HttpServletRequest request, HttpServletResponse response);
//?™ˆ2 ?‘?„±ë©”ì„¸ì§? ë³´ë‚´ê¸?
public void home2mail(HttpServletRequest request, HttpServletResponse response);
}
