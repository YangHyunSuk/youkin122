package com.naver.dbtjd122.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import com.naver.dbtjd122.dao.UserDAO;
import com.naver.dbtjd122.domain.UserVO;

public class AutoLoginterceptor implements HandlerInterceptor {
	@Autowired
	private UserDAO userDAO;

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {

	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
	}

	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {
		/*
		 * java web에서 쿠키찾기 Cookie[] cookie =arg0.getCookies(); for(Cookie
		 * cookie:cookies){ if(cookie.getName().equals("loginCookie")){
		 * 
		 * } }
		 */
		// 스프링에서 특정추키 찾기
		Cookie cookie = WebUtils.getCookie(arg0, "loginCookie");
		HttpSession session =arg0.getSession();			
	
			//로그인 값에 session autologin 값이 1이고 쿠키값이 널이 아닐때    로그아웃을만드는것
		if (session.getAttribute("autologin") == null&&cookie != null) {
			UserVO vo = userDAO.checkUser(cookie.getValue());	
			// 로그인 시켜줬던거
			session.setAttribute("LOGIN", vo);
			///자동로그인을 ㅅ수행하면 autologin에 값을저장
			session.setAttribute("autologin", 1);
		}
		return true;
	}
}
