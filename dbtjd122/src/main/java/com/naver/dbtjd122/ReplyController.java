package com.naver.dbtjd122;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.naver.dbtjd122.domain.ReplyVO;
import com.naver.dbtjd122.service.ReplyService;
import com.naver.dbtjd122.service.UserService;

@RestController
public class ReplyController {
@Autowired
private ReplyService replyService;
@Autowired
private UserService userService;
	
@RequestMapping("/user/idcheck")
public Map<String,Object>idcheck(String id){
	return userService.idCheck(id);
	
}

@RequestMapping("/reply/list")
public List<ReplyVO>list(int bno){
return replyService.list(bno);
	}
	
	@RequestMapping("/reply/insert")
public List<ReplyVO>insert(ReplyVO vo){
		
		replyService.insert(vo);
		
		return replyService.list(vo.getBno());
	}
	@RequestMapping("/reply/update")
public List<ReplyVO>update(ReplyVO vo){
		replyService.update(vo);
		return replyService.list(vo.getBno());
	}
	@RequestMapping("/reply/delete")
public List<ReplyVO>delete(ReplyVO vo){
		replyService.delete(vo.getRno());
		return replyService.list(vo.getBno());
	}
}
