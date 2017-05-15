package com.naver.dbtjd122.service;

import java.sql.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.naver.dbtjd122.domain.LoginDTO;
import com.naver.dbtjd122.domain.UserDTO;
import com.naver.dbtjd122.domain.UserVO;

public interface UserService {
//ë¡œê·¸?¸?„ ì²˜ë¦¬?•´ì£¼ëŠ”ë©”ì„œ?“œ
public UserVO login(LoginDTO loginDTO);

//ë¡œê·¸?¸?• ?–„ ??™ë¡œê·¸?¸ ì²´í¬?•œ ê²½ìš°?— ?„¸?…˜?˜ ?…‹?? ?œ ?š¨?‹œê°„ì„ ?—…?°?´?Š¸ ?•´ì£¼ëŠ” ë©”ì„œ?“œ 
public void updateSession(String id,String sessionKey,Date sessionLimit);

//??™ë¡œê·¸?¸?´ ì²´í¬?˜?–´?ˆ?–´?„œ ì¿ í‚¤?— ?„¸?…˜?˜ ?‚¤ê°’ì„ ???¥?–ˆ?„?•Œ
//ë¡œê·¸?¸?„ ?‹œ?„?•˜ë©? ??™ ë¡œê·¸?¸?• ?ˆ˜?ˆ?„ë¡? ?•„?´?””?? ë¹„ë?ë²ˆí˜¸ë¥? ì°¾ì•„?˜¤?Š” ë©”ì„œ?“œ 
public UserVO userCheck(String sessionKey);

//id ì¤‘ë³µì²´í¬?•´ì£¼ëŠ” ë©”ì„œ?“œë¥? ?…?…?Š—?„´?‹¤
//ê²°ê³¼?Š” ë§µìœ¼ë¡? ë¦¬í„´
public Map<String,Object>idCheck(String id);

//?šŒ?›ê°??…ì²˜ë¦¬
//User?Š” ?‚¬?š©?ê°? ?…? ¥?•œ ?‚´?š©?œ¼,?„¹ ì²˜ë¦¬ HttpServletRequest?Š” ?ŒŒ?¼?—…ë¡œë“œì²˜ë¦¬
public void register(UserDTO dto,HttpServletRequest request);



}
