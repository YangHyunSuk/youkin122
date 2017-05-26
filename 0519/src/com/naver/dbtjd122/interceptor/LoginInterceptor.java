package com.naver.dbtjd122.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor {
	// 컨트롤러의 요청이 처리되고 난후에 호출되는메서드
	// 예외가 있던 없던 무조껀나온다
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {

	}

	// Controller의 요청이 처리되고난 후 호출되는 메서드
	// 예외가 발생하지 않은 경우에만호출
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// 로그인 시도후 리턴되는 데이터를 가져올것이다 .
		ModelMap modelMap = arg3.getModelMap();
		Object userVO = modelMap.get("userVO");
		HttpSession session = arg0.getSession();
		if (userVO == null) {
			// 실패시
			session.setAttribute("fail", "아이디가 없거나 비밀번호 틀렸다");
			arg1.sendRedirect("/dbtjd122/user/login");		

		} else {
			session.removeAttribute("fail");
			session.setAttribute("LOGIN", userVO);
			System.out.println(session);

			// 자동 로그인 체크여부를 확인해서 쿠키를 브라우저에 저장
			if (arg0.getParameter("useCookie") != null) {
				// 쿠키사용할수있는패스설정

				Cookie loginCookie = new Cookie("loginCookie", session.getId());
				loginCookie.setPath("/dbtjd122");

				// postHandle 러에서 입력하고
				// 이건 쿠키의 유효시간
				loginCookie.setMaxAge(60 * 60 * 24 * 7);
				arg1.addCookie(loginCookie);
			} else {
				Cookie loginCookie = new Cookie("loginCookie", session.getId());
				// 쿠키사용할수있는패스설정
				loginCookie.setPath("/dbtjd122");
				// 쿠키의 유효시간은 없다 =쿠키삭제
				loginCookie.setMaxAge(0);
				// 쿠키 저장
				arg1.addCookie(loginCookie);
			}
			// 로그인에 필요한 요청에 의해서 온건지 확인 하기위해 session에 저장한 dest 값을가져오기
			Object dest = arg0.getSession().getAttribute("dest");
			if (dest == null)
				// 시작페이지로가서처리
				arg1.sendRedirect("/dbtjd122");

			else
				arg1.sendRedirect((String) dest);

		}
	}
	
	// Controller 의 요청이 처리되기 전에 호출되는메서드

	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {
		// 세션에 로그인정보가 남았다면 삭제
		HttpSession session = arg0.getSession();
		if (session.getAttribute("LOGIN") != null) {
			session.removeAttribute("LOGIN");
		}
		// true 를 리턴하면 Controller 로처리하러 이동하고
		// false를 리턴하면 Controller로 가지않는다
		return true;
	}
}
