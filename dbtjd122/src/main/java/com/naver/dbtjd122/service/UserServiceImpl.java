
package com.naver.dbtjd122.service;

import java.io.File;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naver.dbtjd122.dao.UserDAO;
import com.naver.dbtjd122.domain.LoginDTO;
import com.naver.dbtjd122.domain.UserDTO;
import com.naver.dbtjd122.domain.UserVO;
@Service
public class UserServiceImpl implements UserService {
@Autowired
private  UserDAO userDAO; 



	
	@Override
	public UserVO login(LoginDTO loginDTO) {
		
		return userDAO.login(loginDTO);
	}



	@Override
	public void updateSession(String id, String sessionKey, Date sessionLimit) {
		Map<String,Object>map=new HashMap<String,Object>();
		map.put("id", id);
		map.put("sessionkey", sessionKey);
		map.put("sessionLimit", sessionLimit);
		
		userDAO.updateSession(map);
	}



	@Override
	public UserVO userCheck(String sessionKey) {
		return userDAO.checkUser(sessionKey);
	}



	@Override
	public Map<String, Object> idCheck(String id) {
		UserVO vo =userDAO.idcheck(id);
		Map<String,Object>map=new HashMap<String,Object>();
		//?•„?´?””ê°? ì¡´ì¬?•˜?Š”ê²½ìš°?Š” result?— false ë¥? ì¡´ì¬?•˜ì§? ?•Š?Š”ê²½ìš°?—?Š” trueë¥? ???¥ 
		if(vo==null){
			map.put("result", "true");
		}else{			
			map.put("result", "false");
		}
		return map;
		
		}



	@Override
	public void register(UserDTO dto, HttpServletRequest request) {
		//DAO?˜ ë§¤ê°œë³??ˆ˜
		UserVO vo =new UserVO();
		//?ŒŒ?¼?´ ?—…ë¡œë“œ ?  ê²½ë¡œ ?ƒ?„±
		String uploadPath =request.getServletContext().getRealPath("/userimage");
		//?œ ?¼ë¬´ì¼?•œ ë¬¸ì?—´?ƒ?„±
		UUID uid=UUID.randomUUID();
		//?—…ë¡œë“œ?•˜? ¤?Š” ?ŒŒ?¼ ?´ë¦„ê³¼ ?œ ?¼ë¬´ì´?•œ ë¬¸ì?—´?„ ?•©ì³ì„œ ?ŒŒ?¼?´ë¦? ë§Œë“¤ê¸?
		String filename =uid +"_"+dto.getImage().getOriginalFilename();
		//?ŒŒ?¼?„ ?—…ë¡œë“œ?•  ê²½ë¡œë§Œë“¤ê¸?
		String filepath=uploadPath+"\\"+filename;
		
	
	try{
		File f=new File(filepath);
			dto.getImage().transferTo(f);
			vo.setId(dto.getId());
			vo.setPw(dto.getPw());
			vo.setName(dto.getName());
			vo.setImage(filename);
				
			userDAO.insert(vo);
			
	}catch(Exception e){
		System.out.println(e.getMessage());
	}
	}
}
