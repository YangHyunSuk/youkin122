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
//ëª¨ë“ ?š”ì²?ì²˜ë¦¬ë©”ì„œ?“œ?˜ ì£¼ì†Œ?•?— url ?•?— /user ë¶™ì„ 
@RequestMapping("/user")
public class UserController {
@Autowired
private UserService userService;


//user /login ?š”ì²??´ ?™”?„?‹œ ì²˜ë¦¬user.jspë¡? ?´?™ 
//?š”ì²?ê³? ?™?¼?•œ ?´ë¦„ì˜ jsp ?ŒŒ?¼ë¡? ê°ˆë–„?Š” ë¦¬í„´?„ ?• ?•„?š”ê°??—†?‹¤

@RequestMapping("/login")
public void  login(){}

@RequestMapping("loginpost")
//?¸?„°?„¼?„°ë¥¼ì‚¬?š§?…‡?•˜ì§??•Š?Š” ë¡œê·¸?¸ ì²˜ë¦¬
public void login(
		LoginDTO loginDTO,
		HttpSession session,
		Model model){
		UserVO vo =userService.login(loginDTO);
		if(loginDTO.isUseCookie()){
		String id=loginDTO.getId();
		String sessionKey=session.getId();
//?¼ì£¼ì¼?›„
	Date sessionLimit=new Date(System.currentTimeMillis()+1000+60*60*24*30);
	userService.updateSession(id, sessionKey, sessionLimit);
	
System.out.println(loginDTO.isUseCookie());

//ë¡œê·¸?¸ ?—¬ë¶?ë¥? vo?— ???¥
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
	attr.addFlashAttribute("msg","?šŒ?›ê°??…?„±ê³?");
	return "redirect:/";
}

}
