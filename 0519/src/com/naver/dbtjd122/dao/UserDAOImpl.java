package com.naver.dbtjd122.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.naver.dbtjd122.domain.LoginDTO;
import com.naver.dbtjd122.domain.UserVO;
@Repository
public class UserDAOImpl implements UserDAO {
@Autowired
private SqlSession sqlSession;


	@Override
	public UserVO login(LoginDTO loginDTO) {
		return sqlSession.selectOne("user.login", loginDTO);
	}


	@Override
	public void updateSession(Map<String, Object> map) {
		sqlSession.update("user.updateSession",map);
	}


	@Override
	public UserVO checkUser(String sessionKey) {
		return sqlSession.selectOne("user.checkUser",sessionKey);
	//세션키로 가져오는 것 
		
	}


	@Override
	public void insert(UserVO vo) {
		sqlSession.insert("user.insert",vo);
		
	}


	@Override
	public UserVO idcheck(String id) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("user.idcheck",id);
	}
}
