package com.naver.dbtjd122;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.naver.dbtjd122.dao.UserDAO;
import com.naver.dbtjd122.domain.BoardVO;

import com.naver.dbtjd122.domain.PageMaker;

import com.naver.dbtjd122.domain.SearchCriteria;
import com.naver.dbtjd122.domain.UserVO;
import com.naver.dbtjd122.service.BoardService;
import com.naver.dbtjd122.service.MailService;
import com.naver.dbtjd122.service.MailServiceImpl;


@Controller
public class BoardController {
@Autowired
private BoardService boardService;
//@Autowired
//private UserDAO userDAO;
	@RequestMapping("/")
public String home(){

		return "home";

}
@RequestMapping(value="/board/register", method=RequestMethod.GET)
public String register(){
		
		return "/board/register";
	  }

@RequestMapping(value="/board/register", method=RequestMethod.POST)
public String register(HttpServletRequest request,RedirectAttributes attr){
boardService.insert(request);
//글쓰기 작업후에는 목록보기로 이동 데이터 베이스에 변화를 가져오므로  redirect
attr.addFlashAttribute("msg", "글쓰기성공");		
return "redirect:list";
	  }

/*전체목록보기일떄쓰던것
@RequestMapping("/board/list")
public String getAll(Model model){
//List<BoardVO>list =boardService.getAll();
//model.addAttribute("list",list);
return "/board/list";

}*/

@RequestMapping("/board/list")
public String getList(@ModelAttribute("criteria") SearchCriteria criteria, Model model){
List<BoardVO>list =boardService.getList(criteria);
model.addAttribute("list",list);
//페이징 처리를 위한 데이터 가져오기
PageMaker pageMaker =new PageMaker();
//현재 페이지 번호와 출력할 데이터 개수가 pageMaker에 저장 
pageMaker.setCriteria(criteria);
//pageMaker에 totalCount에 데이터 전체 개수를 설정하는데 
//나머지 구성요소도 자동으로 계산된다 
pageMaker.setTotalCount(boardService.totalCount(criteria));
model.addAttribute("pageMaker", pageMaker);

return "/board/list";

}


//1개의 파라미터를 URL에 붙여서사용
//블로그처럼 기사 내용을 보여주는게 목적인 웹 애플리케이션에서 많이 이용하는 주소패던
@RequestMapping("/board/detail")
public String getDetail(@RequestParam("bno")  int bno,
@ModelAttribute("criteria") SearchCriteria criteria, Model model){
BoardVO vo =boardService.getDetail(bno);
model.addAttribute("vo",vo);
return"/board/detail";

}
@RequestMapping("/board/delete/{bno}")
public String delete(@PathVariable int bno,RedirectAttributes attr){
	boardService.delete(bno);
	attr.addFlashAttribute("msg", "삭제에 성공했습니다");
//목록보기로 redirect
	return "redirect:/board/list";
}
@RequestMapping("/board/update/{bno}")
public String update(@PathVariable int bno,Model model){
	BoardVO vo= boardService.getDetail(bno);
model.addAttribute("vo",vo);
	//목록보기로 redirect
	return "/board/update";
}

@RequestMapping("/board/updateboard")
public String updateBoard(HttpServletRequest request,RedirectAttributes attr){
	boardService.update(request);
	attr.addFlashAttribute("msg","수정성공");
	return "redirect:/board/list";
}
@RequestMapping("/user/naverlogin")
public String test(HttpServletRequest request){
	return "/user/naverlogin";
}
@RequestMapping("/user/callback")
public String callback(HttpServletRequest request){
	return "/user/callback";
}
@RequestMapping("/user/jido")
public String jido(HttpServletRequest request){
	return "/user/jido";
}
@RequestMapping("/board/bookmark")
public String bookmark(){
	return"/board/bookmark";
}
@RequestMapping("/pasing/message")
public String doGet(HttpServletRequest request, HttpServletResponse response,RedirectAttributes attr)
throws ServletException,IOException{
MailService action = new MailServiceImpl();
action.sendMail(request, response);
attr.addFlashAttribute("msg","관리자 호출완료");

return "redirect:/";
	
}
@RequestMapping("/pasing/download")
public String download(HttpServletRequest request, HttpServletResponse response)
throws ServletException,IOException{
MailService pasingproxy = new MailServiceImpl();
pasingproxy.download(request, response);
	
return "/pasing/proxyse";

}
@RequestMapping("/pasing/proxy")
public String proxy(){
return "/pasing/proxy";
}

@RequestMapping("home2")
public String home2(){
return "home2";
}

@RequestMapping("/home2/mail")
public String home2mail(HttpServletRequest request, HttpServletResponse response,RedirectAttributes attr)
		throws ServletException,IOException{
	MailService action = new MailServiceImpl();
	action.home2mail(request, response);
	return "home2";
}
@RequestMapping("/board/socket")
public String socket(Session session){
	System.out.println("소켓작동확인");
return "/board/socket";
}
}