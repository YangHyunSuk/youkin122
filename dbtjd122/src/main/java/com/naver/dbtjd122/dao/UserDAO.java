package com.naver.dbtjd122.dao;

import java.util.Map;

import com.naver.dbtjd122.domain.LoginDTO;
import com.naver.dbtjd122.domain.UserVO;

public interface UserDAO {
//ë¡œê·¸?¸ ì²˜ë¦¬?•˜?Š” ë©”ì„œ?“œ
public UserVO login(LoginDTO loginDTO);
//ì¿ í‚¤?˜ ?œ ?š¨?‹œê°„ì„ ?—…?°?´?Š¸?•˜?Š” ë©”ì„œ?“œ 
//ë§¤ê°œë³??ˆ˜?Š” ?œ ???˜ ?•„?´?””, ?„¸?…˜ ê°? ?œ ?š¨?‹œê°? 3ê°?ì§??‹¤ 
public void updateSession(Map<String,Object>map);
//ì¿ í‚¤?˜ ê°’ì„ ê°?ì§?ê³? id ?? pw ì°¾ì•„?˜¤?Š”ë©”ì„œ?“œ 
public UserVO checkUser(String sessionKey);
	
//?šŒ?› ê°??… ì²˜ë¦¬ë©”ì„œ?“œ
public void insert(UserVO vo);

//?•„?´?”” ì¤‘ë³µì²´í¬?•  ë©”ì„œ?“œ
public UserVO idcheck(String id);


}
