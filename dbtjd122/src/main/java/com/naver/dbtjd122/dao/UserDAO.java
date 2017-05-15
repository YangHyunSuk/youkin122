package com.naver.dbtjd122.dao;

import java.util.Map;

import com.naver.dbtjd122.domain.LoginDTO;
import com.naver.dbtjd122.domain.UserVO;

public interface UserDAO {
//λ‘κ·Έ?Έ μ²λ¦¬?? λ©μ?
public UserVO login(LoginDTO loginDTO);
//μΏ ν€? ? ?¨?κ°μ ??°?΄?Έ?? λ©μ? 
//λ§€κ°λ³??? ? ??? ??΄?, ?Έ? κ°? ? ?¨?κ°? 3κ°?μ§??€ 
public void updateSession(Map<String,Object>map);
//μΏ ν€? κ°μ κ°?μ§?κ³? id ?? pw μ°Ύμ?€?λ©μ? 
public UserVO checkUser(String sessionKey);
	
//?? κ°?? μ²λ¦¬λ©μ?
public void insert(UserVO vo);

//??΄? μ€λ³΅μ²΄ν¬?  λ©μ?
public UserVO idcheck(String id);


}
