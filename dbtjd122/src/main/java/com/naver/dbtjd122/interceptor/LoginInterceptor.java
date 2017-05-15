package com.naver.dbtjd122.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor {
	// μ»¨νΈλ‘€λ¬? ?μ²??΄ μ²λ¦¬?κ³? ??? ?ΈμΆλ?λ©μ?
	// ??Έκ°? ?? ?? λ¬΄μ‘°κ»???¨?€
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {

	}

	// Controller? ?μ²??΄ μ²λ¦¬?κ³ λ ? ?ΈμΆλ? λ©μ?
	// ??Έκ°? λ°μ?μ§? ??? κ²½μ°?λ§νΈμΆ?
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// λ‘κ·Έ?Έ ??? λ¦¬ν΄?? ?°?΄?°λ₯? κ°?? Έ?¬κ²μ΄?€ .
		ModelMap modelMap = arg3.getModelMap();
		Object userVO = modelMap.get("userVO");
		HttpSession session = arg0.getSession();
		if (userVO == null) {
			// ?€?¨?
			session.setAttribute("fail", "??΄?κ°? ?κ±°λ λΉλ?λ²νΈ ??? Έ?€");
			arg1.sendRedirect("/user/login");
		} else {
			session.removeAttribute("fail");
			session.setAttribute("LOGIN", userVO);
			System.out.println(session);

			// ?? λ‘κ·Έ?Έ μ²΄ν¬?¬λΆ?λ₯? ??Έ?΄? μΏ ν€λ₯? λΈλΌ?°??? ???₯
			if (arg0.getParameter("useCookie") != null) {
				// μΏ ν€?¬?©? ????¨?€?€? 

				Cookie loginCookie = new Cookie("loginCookie", session.getId());
				loginCookie.setPath("/");

				// postHandle ?¬?? ?? ₯?κ³?
				// ?΄κ±? μΏ ν€? ? ?¨?κ°?
				loginCookie.setMaxAge(60 * 60 * 24 * 7);
				arg1.addCookie(loginCookie);
			} else {
				Cookie loginCookie = new Cookie("loginCookie", session.getId());
				// μΏ ν€?¬?©? ????¨?€?€? 
				loginCookie.setPath("/");
				// μΏ ν€? ? ?¨?κ°μ? ??€ =μΏ ν€?­? 
				loginCookie.setMaxAge(0);
				// μΏ ν€ ???₯
				arg1.addCookie(loginCookie);
			}
			// λ‘κ·Έ?Έ? ??? ?μ²?? ??΄? ?¨κ±΄μ? ??Έ ?κΈ°μ?΄ session? ???₯? dest κ°μκ°?? Έ?€κΈ?
			Object dest = arg0.getSession().getAttribute("dest");
			if (dest == null)
				// ????΄μ§?λ‘κ??μ²λ¦¬
				arg1.sendRedirect("/");

			else
				arg1.sendRedirect((String) dest);

		}
	}
	// Controller ? ?μ²??΄ μ²λ¦¬?κΈ? ? ? ?ΈμΆλ?λ©μ?

	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {
		// ?Έ?? λ‘κ·Έ?Έ? λ³΄κ? ?¨??€λ©? ?­? 
		HttpSession session = arg0.getSession();
		if (session.getAttribute("LOGIN") != null) {
			session.removeAttribute("LOGIN");
		}
		// true λ₯? λ¦¬ν΄?λ©? Controller λ‘μ²λ¦¬ν?¬ ?΄??κ³?
		// falseλ₯? λ¦¬ν΄?λ©? Controllerλ‘? κ°?μ§????€
		return true;
	}

}
