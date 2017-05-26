package com.naver.dbtjd122.dao;

import java.util.Map;

import com.naver.dbtjd122.domain.LoginDTO;
import com.naver.dbtjd122.domain.UserVO;

public interface UserDAO {
//로그인 처리하는 메서드
public UserVO login(LoginDTO loginDTO);
//쿠키의 유효시간을 업데이트하는 메서드 
//매개변수는 유저의 아이디, 세션 값 유효시간 3가지다 
public void updateSession(Map<String,Object>map);
//쿠키의 값을 가지고 id 와 pw 찾아오는메서드 
public UserVO checkUser(String sessionKey);
	
//회원 가입 처리메서드
public void insert(UserVO vo);

//아이디 중복체크할 메서드
public UserVO idcheck(String id);


}
