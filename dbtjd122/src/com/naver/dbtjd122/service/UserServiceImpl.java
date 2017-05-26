
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
		//아이디가 존재하는경우는 result에 false 를 존재하지 않는경우에는 true를 저장 
		if(vo==null){
			map.put("result", "true");
		}else{			
			map.put("result", "false");
		}
		return map;
		
		}



	@Override
	public void register(UserDTO dto, HttpServletRequest request) {
		//DAO의 매개변수
		UserVO vo =new UserVO();
		//파일이 업로드 될 경로 생성
		String uploadPath =request.getServletContext().getRealPath("/userimage");
		//유일무일한 문자열생성
		UUID uid=UUID.randomUUID();
		//업로드하려는 파일 이름과 유일무이한 문자열을 합쳐서 파일이름 만들기
		String filename =uid +"_"+dto.getImage().getOriginalFilename();
		//파일을 업로드할 경로만들기
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
