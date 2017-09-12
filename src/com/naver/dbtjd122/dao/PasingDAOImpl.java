package com.naver.dbtjd122.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.naver.dbtjd122.domain.PasingVO;
@Repository
public class PasingDAOImpl implements PasingDAO {
@Autowired
private SqlSession sqlSession;
	
	@Override
	public List<PasingVO> getlist() {
		return sqlSession.selectList("pasing.list");
	}

}
