
package com.naver.dbtjd122.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.naver.dbtjd122.domain.BoardVO;

import com.naver.dbtjd122.domain.SearchCriteria;

@Repository
public class BoardDaoImpl implements BoardDao {
@Autowired
private SqlSession sqlsession;

	@Override
	public void insert(BoardVO vo) {
		sqlsession.insert("board.insert",vo);
	
	}
	/*
	@Override
	public List<BoardVO> getAll() {
		return sqlsession.selectList("board.getAll");
	}
	*/
	@Override
	public BoardVO getDetail(int bno) {
		return sqlsession.selectOne("board.getDetail", bno);
	}
	@Override
	public void updateReadcnt(int bno) {
	sqlsession.update("board.updateReadcnt", bno);
	}
	@Override
	public void update(BoardVO vo) {
	sqlsession.update("board.update",vo);
		
	}
	@Override
	public void delete(int bno) {
sqlsession.delete("board.delete",bno);	
	}
//	@Override
//	public int totalCount() {
//		
//		return sqlsession.selectOne("board.totalCount");
//	}
//	@Override
//	public List<BoardVO> getList(Criteria criteria) {
//		return sqlsession.selectList("board.getList",criteria);
	@Override
	public int totalCount(SearchCriteria criteria) {
				return sqlsession.selectOne("board.totalCount");
	}
	@Override
	public List<BoardVO> getList(SearchCriteria criteria) {
		return sqlsession.selectList("board.getList",criteria);
		

}
}
