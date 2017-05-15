package com.naver.dbtjd122.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class AuthInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest arg0, 
			HttpServletResponse arg1,
			Object arg2, 
			Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void postHandle(HttpServletRequest arg0,
			HttpServletResponse arg1, 
			Object arg2, 
			ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}
	
	//?š”ì²??„ ì²˜ë¦¬?•˜ê¸? ? „?— ?˜¸ì¶œë˜?Š” ë©”ì„œ?“œ
	//ë©”ì„œ?“œ?—?„œ trueë¥? ë¦¬í„´?•˜ë©? Controller?˜ ?š”ì²??„ ì²˜ë¦¬?•˜?Š” ë©”ì„œ?“œë¥? ?ˆ˜?–‰
	//ë©”ì„œ?“œ?—?„œ falseë¥? ë¦¬í„´?•˜ë©? Controller?˜ ?š”ì²??„ ì²˜ë¦¬?•˜?Š” ë©”ì„œ?“œë¥? ?ˆ˜?–‰?•˜ì§?
	//?•Š?Šµ?‹ˆ?‹¤.
	@Override
	public boolean preHandle(HttpServletRequest arg0, 
			HttpServletResponse arg1, 
			Object arg2) throws Exception {
		//ë¡œê·¸?¸ ?—¬ë¶?ë¥? ?™•?¸?•˜ê¸? ?œ„?•´?„œ ?„¸?…˜?„ ê°?? ¸?˜¤ê¸?
		HttpSession session = arg0.getSession();
		//ë¡œê·¸?¸?´ ?•ˆ?œ ê²½ìš°
		if(session.getAttribute("LOGIN") == null){
			//?š”ì²??˜?´ì§??˜ ì£¼ì†Œë¥? session?— ???¥
			//?š”ì²? ì£¼ì†Œë¥? ê°?? ¸?˜¤ê¸? 
			String uri =arg0.getRequestURI();
			//?ŒŒ?¼ë¯¸í„° ê°?? ¸?˜¤ê¸? 
			String query=arg0.getQueryString();
			//?ŒŒ?¼ë¯¸í„°ê°??—†?„?‹œ
			if(query != null&& !query.equals("null")){
				uri=uri+"?"+query;
				
		}
			//?„¸?…˜?—???¥
			arg0.getSession().setAttribute("dest", uri);
			
			//ë¡œê·¸?¸ ?˜?´ì§?ë¡? ë¦¬ì´? ‰?Š¸
			arg1.sendRedirect("/user/login");
			return false;
		}
		//ë¡œê·¸?¸?´ ?œ ê²½ìš°
		return true;
		
	}

}






