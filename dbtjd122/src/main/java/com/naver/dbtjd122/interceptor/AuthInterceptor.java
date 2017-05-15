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
	
	//?μ²?? μ²λ¦¬?κΈ? ? ? ?ΈμΆλ? λ©μ?
	//λ©μ??? trueλ₯? λ¦¬ν΄?λ©? Controller? ?μ²?? μ²λ¦¬?? λ©μ?λ₯? ??
	//λ©μ??? falseλ₯? λ¦¬ν΄?λ©? Controller? ?μ²?? μ²λ¦¬?? λ©μ?λ₯? ???μ§?
	//??΅??€.
	@Override
	public boolean preHandle(HttpServletRequest arg0, 
			HttpServletResponse arg1, 
			Object arg2) throws Exception {
		//λ‘κ·Έ?Έ ?¬λΆ?λ₯? ??Έ?κΈ? ??΄? ?Έ?? κ°?? Έ?€κΈ?
		HttpSession session = arg0.getSession();
		//λ‘κ·Έ?Έ?΄ ?? κ²½μ°
		if(session.getAttribute("LOGIN") == null){
			//?μ²???΄μ§?? μ£Όμλ₯? session? ???₯
			//?μ²? μ£Όμλ₯? κ°?? Έ?€κΈ? 
			String uri =arg0.getRequestURI();
			//??Όλ―Έν° κ°?? Έ?€κΈ? 
			String query=arg0.getQueryString();
			//??Όλ―Έν°κ°????
			if(query != null&& !query.equals("null")){
				uri=uri+"?"+query;
				
		}
			//?Έ?????₯
			arg0.getSession().setAttribute("dest", uri);
			
			//λ‘κ·Έ?Έ ??΄μ§?λ‘? λ¦¬μ΄? ?Έ
			arg1.sendRedirect("/user/login");
			return false;
		}
		//λ‘κ·Έ?Έ?΄ ? κ²½μ°
		return true;
		
	}

}






