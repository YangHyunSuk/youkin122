
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
		//??΄?κ°? μ‘΄μ¬??κ²½μ°? result? false λ₯? μ‘΄μ¬?μ§? ??κ²½μ°?? trueλ₯? ???₯ 
		if(vo==null){
			map.put("result", "true");
		}else{			
			map.put("result", "false");
		}
		return map;
		
		}



	@Override
	public void register(UserDTO dto, HttpServletRequest request) {
		//DAO? λ§€κ°λ³??
		UserVO vo =new UserVO();
		//??Ό?΄ ?λ‘λ ?  κ²½λ‘ ??±
		String uploadPath =request.getServletContext().getRealPath("/userimage");
		//? ?Όλ¬΄μΌ? λ¬Έμ?΄??±
		UUID uid=UUID.randomUUID();
		//?λ‘λ?? €? ??Ό ?΄λ¦κ³Ό ? ?Όλ¬΄μ΄? λ¬Έμ?΄? ?©μ³μ ??Ό?΄λ¦? λ§λ€κΈ?
		String filename =uid +"_"+dto.getImage().getOriginalFilename();
		//??Ό? ?λ‘λ?  κ²½λ‘λ§λ€κΈ?
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
