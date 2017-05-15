package com.naver.dbtjd122.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor {
	// ì»¨íŠ¸ë¡¤ëŸ¬?˜ ?š”ì²??´ ì²˜ë¦¬?˜ê³? ?‚œ?›„?— ?˜¸ì¶œë˜?Š”ë©”ì„œ?“œ
	// ?˜ˆ?™¸ê°? ?ˆ?˜ ?—†?˜ ë¬´ì¡°ê»??‚˜?˜¨?‹¤
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {

	}

	// Controller?˜ ?š”ì²??´ ì²˜ë¦¬?˜ê³ ë‚œ ?›„ ?˜¸ì¶œë˜?Š” ë©”ì„œ?“œ
	// ?˜ˆ?™¸ê°? ë°œìƒ?•˜ì§? ?•Š?? ê²½ìš°?—ë§Œí˜¸ì¶?
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// ë¡œê·¸?¸ ?‹œ?„?›„ ë¦¬í„´?˜?Š” ?°?´?„°ë¥? ê°?? ¸?˜¬ê²ƒì´?‹¤ .
		ModelMap modelMap = arg3.getModelMap();
		Object userVO = modelMap.get("userVO");
		HttpSession session = arg0.getSession();
		if (userVO == null) {
			// ?‹¤?Œ¨?‹œ
			session.setAttribute("fail", "?•„?´?””ê°? ?—†ê±°ë‚˜ ë¹„ë?ë²ˆí˜¸ ??? ¸?‹¤");
			arg1.sendRedirect("/user/login");
		} else {
			session.removeAttribute("fail");
			session.setAttribute("LOGIN", userVO);
			System.out.println(session);

			// ??™ ë¡œê·¸?¸ ì²´í¬?—¬ë¶?ë¥? ?™•?¸?•´?„œ ì¿ í‚¤ë¥? ë¸Œë¼?š°???— ???¥
			if (arg0.getParameter("useCookie") != null) {
				// ì¿ í‚¤?‚¬?š©?• ?ˆ˜?ˆ?Š”?Œ¨?Š¤?„¤? •

				Cookie loginCookie = new Cookie("loginCookie", session.getId());
				loginCookie.setPath("/");

				// postHandle ?Ÿ¬?—?„œ ?…? ¥?•˜ê³?
				// ?´ê±? ì¿ í‚¤?˜ ?œ ?š¨?‹œê°?
				loginCookie.setMaxAge(60 * 60 * 24 * 7);
				arg1.addCookie(loginCookie);
			} else {
				Cookie loginCookie = new Cookie("loginCookie", session.getId());
				// ì¿ í‚¤?‚¬?š©?• ?ˆ˜?ˆ?Š”?Œ¨?Š¤?„¤? •
				loginCookie.setPath("/");
				// ì¿ í‚¤?˜ ?œ ?š¨?‹œê°„ì? ?—†?‹¤ =ì¿ í‚¤?‚­? œ
				loginCookie.setMaxAge(0);
				// ì¿ í‚¤ ???¥
				arg1.addCookie(loginCookie);
			}
			// ë¡œê·¸?¸?— ?•„?š”?•œ ?š”ì²??— ?˜?•´?„œ ?˜¨ê±´ì? ?™•?¸ ?•˜ê¸°ìœ„?•´ session?— ???¥?•œ dest ê°’ì„ê°?? ¸?˜¤ê¸?
			Object dest = arg0.getSession().getAttribute("dest");
			if (dest == null)
				// ?‹œ?‘?˜?´ì§?ë¡œê??„œì²˜ë¦¬
				arg1.sendRedirect("/");

			else
				arg1.sendRedirect((String) dest);

		}
	}
	// Controller ?˜ ?š”ì²??´ ì²˜ë¦¬?˜ê¸? ? „?— ?˜¸ì¶œë˜?Š”ë©”ì„œ?“œ

	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {
		// ?„¸?…˜?— ë¡œê·¸?¸? •ë³´ê? ?‚¨?•˜?‹¤ë©? ?‚­? œ
		HttpSession session = arg0.getSession();
		if (session.getAttribute("LOGIN") != null) {
			session.removeAttribute("LOGIN");
		}
		// true ë¥? ë¦¬í„´?•˜ë©? Controller ë¡œì²˜ë¦¬í•˜?Ÿ¬ ?´?™?•˜ê³?
		// falseë¥? ë¦¬í„´?•˜ë©? Controllerë¡? ê°?ì§??•Š?Š”?‹¤
		return true;
	}

}
