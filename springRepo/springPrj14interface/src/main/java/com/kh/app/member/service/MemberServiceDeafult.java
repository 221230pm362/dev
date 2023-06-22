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
public class MemberServiceDeafult implements MemberService {
	
	private final MemberDao dao;
	private final SqlSessionTemplate sst;

	//회원가입
	public int join(MemberVo vo) {
		return dao.join(sst, vo);
	}

	//로그인
	public MemberVo login(MemberVo vo) {
		return dao.login(sst , vo);
	}

}//class





















