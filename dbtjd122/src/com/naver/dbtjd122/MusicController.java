package com.naver.dbtjd122;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.naver.dbtjd122.domain.MusicVO;
import com.naver.dbtjd122.service.MusicService;

@Controller
public class MusicController {
@Autowired
private MusicService musicSerivce;


@RequestMapping("/music/yangmusic")
public String home(Model model) {
	List<MusicVO>list=musicSerivce.getlist();
	model.addAttribute("list",list);
	
	
	return "/music/yangmusic";


}
@RequestMapping(value ="/pasing/pasing", method = RequestMethod.POST)
public void simpleTest(@RequestBody String body) {
System.out.println("/pasing/pasing"+body);


}
}
