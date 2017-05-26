package com.naver.dbtjd122;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.naver.dbtjd122.domain.LoginDTO;
import com.naver.dbtjd122.domain.UserDTO;
import com.naver.dbtjd122.domain.UserVO;
import com.naver.dbtjd122.service.UserService;

@Controller
// 모든요청처리메서드의 주소앞에 url 앞에 /user 붙임
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;

	// user /login 요청이 왔을시 처리user.jsp로 이동
	// 요청과 동일한 이름의 jsp 파일로 갈떄는 리턴을 할필요가없다

	@RequestMapping("/login")
	public void login() {
	}

	@RequestMapping("/loginpost")
	// 인터센터를사용하지않는 로그인 처리
	public void login(LoginDTO loginDTO, HttpSession session, Model model) {
		UserVO vo = userService.login(loginDTO);
		//vo값이 있을때
		if (vo != null) {
			//UseCookie 값이 있을때
			if (loginDTO.isUseCookie()) {
				String id = loginDTO.getId();
				String sessionKey = session.getId();
				// 일주일후
				Date sessionLimit = new Date(System.currentTimeMillis() + 1000 + 60 * 60 * 24 * 30);
				userService.updateSession(id, sessionKey, sessionLimit);

				System.out.println(loginDTO.isUseCookie());

			}
			// 로그인 여부를 vo에 저장
			model.addAttribute("userVO", vo);
		}

	}

	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("LOGIN");
		return "redirect:/";

	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register() {

		return "/user/register";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(UserDTO dto, HttpServletRequest request, RedirectAttributes attr) {
		userService.register(dto, request);
		attr.addFlashAttribute("msg", "회원가입성공");
		return "redirect:/";
	}

	@RequestMapping("/kakao")
	public String zazao(HttpServletRequest request) {
		return "/user/kakao";

	}
}
