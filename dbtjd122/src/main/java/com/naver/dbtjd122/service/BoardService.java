package com.naver.dbtjd122.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.naver.dbtjd122.domain.BoardVO;
import com.naver.dbtjd122.domain.Criteria;
import com.naver.dbtjd122.domain.SearchCriteria;

public interface BoardService {
	
public void insert(HttpServletRequest request);
/*
 ? „ì²´ëª©ë¡ë³´ê¸°ë?? ?œ„?•œë©”ì„œ?“œ
public List<BoardVO>getAll();
*/
//?˜?´ì§? ì²˜ë¦¬ë¥? ?œ„?•œë©”ì„œ?“œ
//public int totalCount();
//public List<BoardVO>getList(Criteria criteria);

//ê²??ƒ‰ ì²˜ë¦¬ë¥? ?œ„?•œ ë©”ì„œ?“œ
public int totalCount(
		SearchCriteria criteria);
public List<BoardVO>getList(
		SearchCriteria criteria);

//?ƒ?„¸ë³´ê¸°
public BoardVO getDetail(int bno);
//ê¸??‚­? œ
public void delete(int bno);
//ip?–„ë¬¸ì— request ë¡? ë°›ì•„?•¼?•œ?‹¤ ë§¤ê°œ ë³??ˆ˜ë¡? 
public void update(HttpServletRequest request);
}
