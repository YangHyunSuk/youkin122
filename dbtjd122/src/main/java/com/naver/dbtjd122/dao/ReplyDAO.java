package com.naver.dbtjd122.dao;

import java.util.List;

import com.naver.dbtjd122.domain.ReplyVO;

public interface ReplyDAO {
    //ê¸?ë²ˆí˜¸?— ?•´?‹¹?•˜?Š” ëª¨ë“  ?Œ“ê¸? ê°?? ¸?˜¤ê¸?
	public List<ReplyVO>list (int bno);
	//ê¸?ë²ˆí˜¸?— ?•´?‹¹?•˜?Š” ?Œ“ê¸??˜ ê°œìˆ˜ ê°?? ¸?˜¤ê¸?
	public int count(int bno);
	//?Œ“ê¸??„ ?…? ¥
	public void insert(ReplyVO vo);
	
	//?Œ“ê¸??„ ?ˆ˜? •
	public void update(ReplyVO vo);
	
	//?Œ“ê¸??„ ?‚­? œ
	public void delete(int rno);
}
