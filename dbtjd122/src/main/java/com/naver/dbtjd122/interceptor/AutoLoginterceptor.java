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
		 * java web?—?„œ ì¿ í‚¤ì°¾ê¸° Cookie[] cookie =arg0.getCookies(); for(Cookie
		 * cookie:cookies){ if(cookie.getName().equals("loginCookie")){
		 * 
		 * } }
		 */
		// ?Š¤?”„ë§ì—?„œ ?Š¹? •ì¶”í‚¤ ì°¾ê¸°
		Cookie cookie = WebUtils.getCookie(arg0, "loginCookie");
		HttpSession session =arg0.getSession();			
	
			//ë¡œê·¸?¸ ê°’ì— session autologin ê°’ì´ 1?´ê³? ì¿ í‚¤ê°’ì´ ?„?´ ?•„?‹?•Œ    ë¡œê·¸?•„?›ƒ?„ë§Œë“œ?Š”ê²?
		if (session.getAttribute("autologin") == null&&cookie != null) {
			UserVO vo = userDAO.checkUser(cookie.getValue());	
			// ë¡œê·¸?¸ ?‹œì¼œì¤¬?˜ê±?
			session.setAttribute("LOGIN", vo);
			///??™ë¡œê·¸?¸?„ ?……?ˆ˜?–‰?•˜ë©? autologin?— ê°’ì„???¥
			session.setAttribute("autologin", 1);
		}
		return true;
	}
}
