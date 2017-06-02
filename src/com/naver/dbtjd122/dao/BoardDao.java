package com.naver.dbtjd122.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.naver.dbtjd122.domain.BoardVO;

import com.naver.dbtjd122.domain.SearchCriteria;

@Repository
public interface BoardDao {

public void insert(BoardVO vo);
	//주석으로바꾸고
//public List<BoardVO> getAll();-1

//페이징 처리를 위해서 만든 목록 보기 메서드-1  
//전체 데이터 개수를 가져오는 메서드와 
//public  int totalCount();

//현제 페이지 번호와 데이터 개수를 넘겨서  페이지 번호에 해당하는 데이터를 가져오는 메서드 
//public List<BoardVO> getList(Criteria criteria);

//검색처리를위해ㅔ 만든 목록보기 메서드 전체데이터 개수를 가져오는메서드
public int totalCount(SearchCriteria criteria);
//현제 페이지에 번호와 데이터개수를 넘겨서 페이지 번호에 해당하는 데이터를 가져오는메서드
public List<BoardVO>getList(SearchCriteria criteria);

//게시글 번호를 이용해서 데이터를 찾아오는 메서드

public BoardVO getDetail(int bno);
//게시글 번호를 가지고 조회수를 1증가시키는 메서드
public void updateReadcnt(int bno);

//게시글 번호를 가지고 내용을 수정
public void update(BoardVO vo);
//게시글 번호를 가지고 삭제ㅐ
public void delete(int bno);



}
