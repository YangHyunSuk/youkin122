package com.naver.dbtjd122.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.naver.dbtjd122.domain.BoardVO;
import com.naver.dbtjd122.domain.Criteria;
import com.naver.dbtjd122.domain.SearchCriteria;

public interface BoardService {
	
public void insert(HttpServletRequest request);
/*
 전체목록보기를 위한메서드
public List<BoardVO>getAll();
*/
//페이징 처리를 위한메서드
//public int totalCount();
//public List<BoardVO>getList(Criteria criteria);

//검색 처리를 위한 메서드
public int totalCount(
		SearchCriteria criteria);
public List<BoardVO>getList(
		SearchCriteria criteria);

//상세보기
public BoardVO getDetail(int bno);
//글삭제
public void delete(int bno);
//ip떄문에 request 로 받아야한다 매개 변수로 
public void update(HttpServletRequest request);
}
