package com.naver.dbtjd122.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.naver.dbtjd122.domain.BoardVO;

import com.naver.dbtjd122.domain.SearchCriteria;

@Repository
public interface BoardDao {

public void insert(BoardVO vo);
	//μ£Όμ?Όλ‘λ°κΎΈκ³ 
//public List<BoardVO> getAll();-1

//??΄μ§? μ²λ¦¬λ₯? ??΄? λ§λ  λͺ©λ‘ λ³΄κΈ° λ©μ?-1  
//? μ²? ?°?΄?° κ°μλ₯? κ°?? Έ?€? λ©μ??? 
//public  int totalCount();

//??  ??΄μ§? λ²νΈ?? ?°?΄?° κ°μλ₯? ?κ²¨μ  ??΄μ§? λ²νΈ? ?΄?Ή?? ?°?΄?°λ₯? κ°?? Έ?€? λ©μ? 
//public List<BoardVO> getList(Criteria criteria);

//κ²??μ²λ¦¬λ₯Όμ?΄? λ§λ  λͺ©λ‘λ³΄κΈ° λ©μ? ? μ²΄λ°?΄?° κ°μλ₯? κ°?? Έ?€?λ©μ?
public int totalCount(SearchCriteria criteria);
//??  ??΄μ§?? λ²νΈ?? ?°?΄?°κ°μλ₯? ?κ²¨μ ??΄μ§? λ²νΈ? ?΄?Ή?? ?°?΄?°λ₯? κ°?? Έ?€?λ©μ?
public List<BoardVO>getList(SearchCriteria criteria);

//κ²μκΈ? λ²νΈλ₯? ?΄?©?΄? ?°?΄?°λ₯? μ°Ύμ?€? λ©μ?

public BoardVO getDetail(int bno);
//κ²μκΈ? λ²νΈλ₯? κ°?μ§?κ³? μ‘°ν?λ₯? 1μ¦κ???€? λ©μ?
public void updateReadcnt(int bno);

//κ²μκΈ? λ²νΈλ₯? κ°?μ§?κ³? ?΄?©? ?? 
public void update(BoardVO vo);
//κ²μκΈ? λ²νΈλ₯? κ°?μ§?κ³? ?­? ?
public void delete(int bno);



}
