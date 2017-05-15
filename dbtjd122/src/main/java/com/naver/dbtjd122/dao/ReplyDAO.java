package com.naver.dbtjd122.dao;

import java.util.List;

import com.naver.dbtjd122.domain.ReplyVO;

public interface ReplyDAO {
    //κΈ?λ²νΈ? ?΄?Ή?? λͺ¨λ  ?κΈ? κ°?? Έ?€κΈ?
	public List<ReplyVO>list (int bno);
	//κΈ?λ²νΈ? ?΄?Ή?? ?κΈ?? κ°μ κ°?? Έ?€κΈ?
	public int count(int bno);
	//?κΈ?? ?? ₯
	public void insert(ReplyVO vo);
	
	//?κΈ?? ?? 
	public void update(ReplyVO vo);
	
	//?κΈ?? ?­? 
	public void delete(int rno);
}
