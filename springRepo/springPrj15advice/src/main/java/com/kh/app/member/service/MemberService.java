package com.kh.app.member.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.app.member.dao.MemberDao;
import com.kh.app.member.vo.MemberVo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberService {
	
	private final MemberDao dao;
	private final SqlSessionTemplate sst;
	
	public int join(MemberVo vo) throws Exception {
		return dao.join(sst, vo);
	}

}//class























