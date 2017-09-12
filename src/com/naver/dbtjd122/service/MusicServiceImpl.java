package com.naver.dbtjd122.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naver.dbtjd122.dao.MusicDAO;
import com.naver.dbtjd122.domain.MusicVO;

@Service
public class MusicServiceImpl implements MusicService {
@Autowired
private MusicDAO musicDAO;

@Override
public List<MusicVO> getlist() {
	
	return musicDAO.getlist();
}

}
