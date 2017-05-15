package com.naver.dbtjd122.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.naver.dbtjd122.domain.BoardVO;

import com.naver.dbtjd122.domain.SearchCriteria;

@Repository
public interface BoardDao {

public void insert(BoardVO vo);
	//ì£¼ì„?œ¼ë¡œë°”ê¾¸ê³ 
//public List<BoardVO> getAll();-1

//?˜?´ì§? ì²˜ë¦¬ë¥? ?œ„?•´?„œ ë§Œë“  ëª©ë¡ ë³´ê¸° ë©”ì„œ?“œ-1  
//? „ì²? ?°?´?„° ê°œìˆ˜ë¥? ê°?? ¸?˜¤?Š” ë©”ì„œ?“œ?? 
//public  int totalCount();

//?˜„? œ ?˜?´ì§? ë²ˆí˜¸?? ?°?´?„° ê°œìˆ˜ë¥? ?„˜ê²¨ì„œ  ?˜?´ì§? ë²ˆí˜¸?— ?•´?‹¹?•˜?Š” ?°?´?„°ë¥? ê°?? ¸?˜¤?Š” ë©”ì„œ?“œ 
//public List<BoardVO> getList(Criteria criteria);

//ê²??ƒ‰ì²˜ë¦¬ë¥¼ìœ„?•´?…” ë§Œë“  ëª©ë¡ë³´ê¸° ë©”ì„œ?“œ ? „ì²´ë°?´?„° ê°œìˆ˜ë¥? ê°?? ¸?˜¤?Š”ë©”ì„œ?“œ
public int totalCount(SearchCriteria criteria);
//?˜„? œ ?˜?´ì§??— ë²ˆí˜¸?? ?°?´?„°ê°œìˆ˜ë¥? ?„˜ê²¨ì„œ ?˜?´ì§? ë²ˆí˜¸?— ?•´?‹¹?•˜?Š” ?°?´?„°ë¥? ê°?? ¸?˜¤?Š”ë©”ì„œ?“œ
public List<BoardVO>getList(SearchCriteria criteria);

//ê²Œì‹œê¸? ë²ˆí˜¸ë¥? ?´?š©?•´?„œ ?°?´?„°ë¥? ì°¾ì•„?˜¤?Š” ë©”ì„œ?“œ

public BoardVO getDetail(int bno);
//ê²Œì‹œê¸? ë²ˆí˜¸ë¥? ê°?ì§?ê³? ì¡°íšŒ?ˆ˜ë¥? 1ì¦ê??‹œ?‚¤?Š” ë©”ì„œ?“œ
public void updateReadcnt(int bno);

//ê²Œì‹œê¸? ë²ˆí˜¸ë¥? ê°?ì§?ê³? ?‚´?š©?„ ?ˆ˜? •
public void update(BoardVO vo);
//ê²Œì‹œê¸? ë²ˆí˜¸ë¥? ê°?ì§?ê³? ?‚­? œ?…
public void delete(int bno);



}
