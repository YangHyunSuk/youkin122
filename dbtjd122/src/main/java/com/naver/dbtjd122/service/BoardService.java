package com.naver.dbtjd122.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.naver.dbtjd122.domain.BoardVO;
import com.naver.dbtjd122.domain.Criteria;
import com.naver.dbtjd122.domain.SearchCriteria;

public interface BoardService {
	
public void insert(HttpServletRequest request);
/*
 ? μ²΄λͺ©λ‘λ³΄κΈ°λ?? ??λ©μ?
public List<BoardVO>getAll();
*/
//??΄μ§? μ²λ¦¬λ₯? ??λ©μ?
//public int totalCount();
//public List<BoardVO>getList(Criteria criteria);

//κ²?? μ²λ¦¬λ₯? ?? λ©μ?
public int totalCount(
		SearchCriteria criteria);
public List<BoardVO>getList(
		SearchCriteria criteria);

//??Έλ³΄κΈ°
public BoardVO getDetail(int bno);
//κΈ??­? 
public void delete(int bno);
//ip?λ¬Έμ request λ‘? λ°μ?Ό??€ λ§€κ° λ³??λ‘? 
public void update(HttpServletRequest request);
}
