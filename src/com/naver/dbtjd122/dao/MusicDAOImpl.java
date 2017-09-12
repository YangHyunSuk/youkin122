package com.naver.dbtjd122.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.naver.dbtjd122.domain.MusicVO;
@Repository
public class MusicDAOImpl implements MusicDAO {
@Autowired SqlSession sqlSession;
	@Override
	public List<MusicVO> getlist() {
		
		return sqlSession.selectList("yang.getList");
	}

}
