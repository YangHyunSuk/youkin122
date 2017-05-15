package com.naver.dbtjd122.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naver.dbtjd122.dao.BoardDao;
import com.naver.dbtjd122.dao.ReplyDAO;
import com.naver.dbtjd122.domain.BoardVO;

import com.naver.dbtjd122.domain.SearchCriteria;
@Service
public class BoardServiceImpl implements BoardService {
@Autowired
private BoardDao boardDao;
@Autowired
private ReplyDAO replyDao;

	@Override
	public void insert(HttpServletRequest request) {
		String title=request.getParameter("title");
		String content =request.getParameter("content");
		String writer= request.getParameter("writer");
		String ip=request.getRemoteAddr();
		
		
		BoardVO vo= new BoardVO();
		vo.setTitle(title);
		vo.setContent(content);
		vo.setWriter(writer);
		vo.setIp(ip);
		/*
		boardDao.insert(vo);
			String [] titles={
					"?“±?—…?•´ì£¼ì„¸?š”","ê°??…?¸?‚¬","ë°˜ê°‘?Šµ?‹ˆ?‹¤","?•ˆ?…•?•˜?„¸?š”","?™˜?˜?•©?‹ˆ?‹¤"};
			String[]contents={"?•„ë¬´ë§???”ì¹?","??ë°•ì‚¬ê±?","?š°ì£¼ë??Š¤?? ê¹??¬ì²?","ê¸°ë…êµë‹¤","ë¶ˆêµ?‹¤"};
			String[]writers={"?Š¤?Š¸ë§?","?–´?„ë¹?","?œˆ?„?š°","ë§ˆì´?¬ë¡?","??ë¦¬ìŠ¤"};
			String[]ips={"211.458.4.105","213.488.8.185","261.458.2.175","261.448.9.185","251.458.8.456"};
	
	Random r= new Random();
	for(int i=0; i<200;i++){
		BoardVO v = new BoardVO();
	v.setTitle(titles[r.nextInt(5)]);
	v.setContent(contents[r.nextInt(5)]);
	v.setWriter(writers[r.nextInt(5)]);
	v.setIp(ips[r.nextInt(5)]);
	
	boardDao.insert(vo);
	}*/
		boardDao.insert(vo);
		
	}
	/*
	@Override
	public List<BoardVO> getAll() {	// TODO Auto-generated method stub
		return boardDao.getAll();
	}
	*/
	@Override
	public BoardVO getDetail(int bno) {
    //ì¡°íšŒ?ˆ˜ 1ì¦ê??•˜ê³?
		BoardVO vo= boardDao.getDetail(bno);
		boardDao.updateReadcnt(bno);
		return vo;
	}
	@Override
	public void delete(int bno) {
	boardDao.delete(bno);
		
	}
	@Override
	public void update(HttpServletRequest request) {
		
		int bno= Integer.parseInt(request.getParameter("bno"));
		
		String title=request.getParameter("title");
		String content =request.getParameter("content");
		String writer= request.getParameter("writer");
		String ip=request.getRemoteAddr();
		
		
		BoardVO vo= new BoardVO();
		vo.setTitle(title);
		vo.setContent(content);
		vo.setWriter(writer);
		vo.setIp(ip);
		
		boardDao.insert(vo);
	}
	

//	@Override
//	public int totalCount() {
//		
//		return boardDao.totalCount();
//	}
//	@Override
//	public List<BoardVO> getList(Criteria criteria) {
//		return boardDao.getList(criteria);
//	}

@Override
public int totalCount(SearchCriteria criteria){
	if(criteria.getKeyword()!=null)
		criteria.setKeyword(criteria.getKeyword().toUpperCase());
	return boardDao.totalCount(criteria);
}
@Override
public List<BoardVO> getList(SearchCriteria criteria){
	
	if(criteria.getKeyword()!=null)
		criteria.setKeyword(criteria.getKeyword().toUpperCase());
	List<BoardVO>list=boardDao.getList(criteria);
	//list?˜ ëª¨ë“ ?°?´?„°ë¥? ?ˆœ?šŒ?•˜ë©´ì„œ ?Œ“ê¸?ê°??ˆ˜???¥
	for(BoardVO vo:list){
		int r= replyDao.count(vo.getBno());
		vo.setReplyCnt(r);
	}
	
	return list;

}
}
