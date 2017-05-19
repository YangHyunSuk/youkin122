package com.naver.dbtjd122.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naver.dbtjd122.dao.ReplyDAO;
import com.naver.dbtjd122.domain.ReplyVO;
@Service
public class ReplyServiceImpl implements ReplyService {
@Autowired
private ReplyDAO replyDAO;
	@Override
	public List<ReplyVO> list(int bno) {
		// TODO Auto-generated method stub
		return replyDAO.list(bno);
	}

	@Override
	public int count(int bno) {
		// TODO Auto-generated method stub
		return replyDAO.count(bno);
	}

	@Override
	public void insert(ReplyVO vo) {
		replyDAO.insert(vo);
	}

	@Override
	public void update(ReplyVO vo) {
		replyDAO.update(vo);
	}

	@Override
	public void delete(int rno) {
			replyDAO.delete(rno);
	}

}
