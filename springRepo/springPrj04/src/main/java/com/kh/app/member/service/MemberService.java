package com.kh.app.member.service;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.app.member.dao.MemberDao;
import com.kh.app.member.vo.MemberVo;

@Service
public class MemberService {

	private final MemberDao dao;
	
	private final SqlSessionTemplate sst;
	
	@Autowired
	public MemberService(MemberDao dao, SqlSessionTemplate sst) {
		this.dao = dao;
		this.sst = sst;
	}
	
	public int join(MemberVo vo) {
		return dao.join(sst, vo);
	}

}//class






















