package com.naver.dbtjd122.dao;

import java.util.List;

import com.naver.dbtjd122.domain.ReplyVO;

public interface ReplyDAO {
    //글번호에 해당하는 모든 댓글 가져오기
	public List<ReplyVO>list (int bno);
	//글번호에 해당하는 댓글의 개수 가져오기
	public int count(int bno);
	//댓글을 입력
	public void insert(ReplyVO vo);
	
	//댓글을 수정
	public void update(ReplyVO vo);
	
	//댓글을 삭제
	public void delete(int rno);
}
