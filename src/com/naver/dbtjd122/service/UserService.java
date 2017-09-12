package com.naver.dbtjd122.service;

import java.sql.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.naver.dbtjd122.domain.LoginDTO;
import com.naver.dbtjd122.domain.UserDTO;
import com.naver.dbtjd122.domain.UserVO;

public interface UserService {
//로그인을 처리해주는메서드
public UserVO login(LoginDTO loginDTO);

//로그인할떄 자동로그인 체크한 경우에 세션의 ㅋ와 유효시간을 업데이트 해주는 메서드 
public void updateSession(String id,String sessionKey,Date sessionLimit);

//자동로그인이 체크되어있어서 쿠키에 세션의 키값을 저장했을때
//로그인을 시도하면 자동 로그인할수있도록 아이디와 비밀번호를 찾아오는 메서드 
public UserVO userCheck(String sessionKey);

//id 중복체크해주는 메서드를 ㅏㅁ늗ㄴ다
//결과는 맵으로 리턴
public Map<String,Object>idCheck(String id);

//회원가입처리
//User는 사용자가 입력한 내용으,ㄹ 처리 HttpServletRequest는 파일업로드처리
public void register(UserDTO dto,HttpServletRequest request);



}
