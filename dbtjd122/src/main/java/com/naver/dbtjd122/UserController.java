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
//λͺ¨λ ?μ²?μ²λ¦¬λ©μ?? μ£Όμ?? url ?? /user λΆμ 
@RequestMapping("/user")
public class UserController {
@Autowired
private UserService userService;


//user /login ?μ²??΄ ??? μ²λ¦¬user.jspλ‘? ?΄? 
//?μ²?κ³? ??Ό? ?΄λ¦μ jsp ??Όλ‘? κ°λ? λ¦¬ν΄? ? ??κ°???€

@RequestMapping("/login")
public void  login(){}

@RequestMapping("loginpost")
//?Έ?°?Ό?°λ₯Όμ¬?§??μ§??? λ‘κ·Έ?Έ μ²λ¦¬
public void login(
		LoginDTO loginDTO,
		HttpSession session,
		Model model){
		UserVO vo =userService.login(loginDTO);
		if(loginDTO.isUseCookie()){
		String id=loginDTO.getId();
		String sessionKey=session.getId();
//?Όμ£ΌμΌ?
	Date sessionLimit=new Date(System.currentTimeMillis()+1000+60*60*24*30);
	userService.updateSession(id, sessionKey, sessionLimit);
	
System.out.println(loginDTO.isUseCookie());

//λ‘κ·Έ?Έ ?¬λΆ?λ₯? vo? ???₯
model.addAttribute("userVO", vo);
}

}

@RequestMapping("/logout")
public String logout(HttpSession session){
	session.removeAttribute("LOGIN");
	return "redirect:/";
	
}

@RequestMapping(value="/register", method=RequestMethod.GET)
public String register(){
		
		return "/user/register";
	  }
@RequestMapping(value="/register",method=RequestMethod.POST)
public String register(UserDTO dto,HttpServletRequest request,RedirectAttributes attr){
	userService.register(dto, request);
	attr.addFlashAttribute("msg","??κ°???±κ³?");
	return "redirect:/";
}

}
