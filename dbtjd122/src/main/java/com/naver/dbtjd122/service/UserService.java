package com.naver.dbtjd122.service;

import java.sql.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.naver.dbtjd122.domain.LoginDTO;
import com.naver.dbtjd122.domain.UserDTO;
import com.naver.dbtjd122.domain.UserVO;

public interface UserService {
//λ‘κ·Έ?Έ? μ²λ¦¬?΄μ£Όλλ©μ?
public UserVO login(LoginDTO loginDTO);

//λ‘κ·Έ?Έ? ? ??λ‘κ·Έ?Έ μ²΄ν¬? κ²½μ°? ?Έ?? ??? ? ?¨?κ°μ ??°?΄?Έ ?΄μ£Όλ λ©μ? 
public void updateSession(String id,String sessionKey,Date sessionLimit);

//??λ‘κ·Έ?Έ?΄ μ²΄ν¬??΄??΄? μΏ ν€? ?Έ?? ?€κ°μ ???₯???
//λ‘κ·Έ?Έ? ???λ©? ?? λ‘κ·Έ?Έ? ???λ‘? ??΄??? λΉλ?λ²νΈλ₯? μ°Ύμ?€? λ©μ? 
public UserVO userCheck(String sessionKey);

//id μ€λ³΅μ²΄ν¬?΄μ£Όλ λ©μ?λ₯? ????΄?€
//κ²°κ³Ό? λ§΅μΌλ‘? λ¦¬ν΄
public Map<String,Object>idCheck(String id);

//??κ°??μ²λ¦¬
//User? ?¬?©?κ°? ?? ₯? ?΄?©?Ό,?Ή μ²λ¦¬ HttpServletRequest? ??Ό?λ‘λμ²λ¦¬
public void register(UserDTO dto,HttpServletRequest request);



}
