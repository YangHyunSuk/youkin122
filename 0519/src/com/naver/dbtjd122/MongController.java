package com.naver.dbtjd122;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.naver.dbtjd122.domain.Product;
import com.naver.dbtjd122.service.ProductService;

@Controller
//공통주소가 있으면 
@RequestMapping("/mongo")
public class MongController {
@Autowired
private  ProductService productService;

@RequestMapping(value="/insert",method=RequestMethod.GET)
public String insert(){
//이문자열을 가지고 servlet -context .xml 에있는 
	//viewResolver와 합성해서 뷰위치를 결정한다 .
	return "/mongo/insert";
}	
@RequestMapping(value="/insert",method=RequestMethod.POST)
//1,파라미터 넘겨받는부분
//httpServletRequest, @ RequestParam,Command객체 
//2,세션 사용 여부-계속 보존해야하는 데이터작업ore 
//HttpSession
//3.결과 페이지 이동 방법
//forward(출력페이지 이름),rediect()redirect:요청주소
//4.데이터 전달
//forward-Model, redirect-redirectAttributes,Session 이용


//forwarding 와 redirect 여부는 새로고침을 했을때 동작여부 
public String insert(HttpServletRequest request,RedirectAttributes attr){
	productService.insert(request);
	attr.addFlashAttribute("msg","삽입성공");
	//삽입후에는 거의 목록보기로 가고
	//회원가입시는 로그인으로 간다 
	//목록보기로 갈때는 메세지를 출력하지않느다 .
	return  "redirect:../";
}
@RequestMapping(value="/list",method=RequestMethod.GET)
public String list(Model model){
	List<Product>list=productService.list();
	model.addAttribute("list",list);
	System.out.println(list);
	System.out.println("확인");	
	return "/mongo/list";
}
@RequestMapping(value="/detail",method=RequestMethod.GET)
public String detail(@RequestParam("id")String id, Model model){
	Product product=productService.detail(id);
	model.addAttribute("product",product);
	return "/mongo/detail";
}


@RequestMapping(value="/delete",method=RequestMethod.GET)
public String delete(@RequestParam("id")String id){
productService.delete(id);
	return "redirect:list";
}
@RequestMapping(value="/update",method=RequestMethod.GET)
public String update(@RequestParam("id")String id,Model model){
Product product= productService.detail(id);
model.addAttribute("product",product);
return "/mongo/update";
}
@RequestMapping(value="/update",method=RequestMethod.POST)
public String update(@ModelAttribute("produvt")Product product,Model model){
productService.update(product);
return "redirect:../";
}
}
