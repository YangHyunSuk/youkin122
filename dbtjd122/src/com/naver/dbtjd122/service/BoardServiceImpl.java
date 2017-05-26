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
					"등업해주세요","가입인사","반갑습니다","안녕하세요","환영합니다"};
			String[]contents={"아무말대잔치","대박사건","우주대스타 김희철","기독교다","불교다"};
			String[]writers={"스트링","어도비","윈도우","마이크로","홀리스"};
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
    //조회수 1증가하고
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
	//list의 모든데이터를 순회하면서 댓글갯수저장
	for(BoardVO vo:list){
		int r= replyDao.count(vo.getBno());
		vo.setReplyCnt(r);
	}
	
	return list;

}
}
