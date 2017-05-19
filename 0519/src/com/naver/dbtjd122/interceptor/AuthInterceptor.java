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
	
	//요청을 처리하기 전에 호출되는 메서드
	//메서드에서 true를 리턴하면 Controller의 요청을 처리하는 메서드를 수행
	//메서드에서 false를 리턴하면 Controller의 요청을 처리하는 메서드를 수행하지
	//않습니다.
	@Override
	public boolean preHandle(HttpServletRequest arg0, 
			HttpServletResponse arg1, 
			Object arg2) throws Exception {
		//로그인 여부를 확인하기 위해서 세션을 가져오기
		HttpSession session = arg0.getSession();
		//로그인이 안된 경우
		if(session.getAttribute("LOGIN") == null){
			//요청페이지의 주소를 session에 저장
			//요청 주소를 가져오기 
			String uri =arg0.getRequestURI();
			//파라미터 가져오기 
			String query=arg0.getQueryString();
			//파라미터가없을시
			if(query != null&& !query.equals("null")){
				uri=uri+"?"+query;
				
		}
			//세션에저장
			arg0.getSession().setAttribute("dest", uri);
			
			//로그인 페이지로 리이렉트
			arg1.sendRedirect("/dbtjd122/user/login");
			return false;
		}
		//로그인이 된 경우
		return true;
		
	}

}






