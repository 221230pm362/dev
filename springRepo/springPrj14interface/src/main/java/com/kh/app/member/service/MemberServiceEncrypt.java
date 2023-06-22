package com.kh.app.member.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.app.member.dao.MemberDao;
import com.kh.app.member.vo.MemberVo;

import lombok.RequiredArgsConstructor;

@Service
@Primary
@RequiredArgsConstructor
@Transactional
public class MemberServiceEncrypt implements MemberService {
	
	private final SqlSessionTemplate sst;
	private final MemberDao dao;
	private final BCryptPasswordEncoder encoder;

	// 로그인
	@Override
	public MemberVo login(MemberVo vo) {
		
		MemberVo loginMember = dao.login(sst, vo);
		
		//비번 일치 여부 체크
		String dbPwd = loginMember.getPwd();
		String userPwd = vo.getPwd();
		
		boolean isMatch = encoder.matches(userPwd , dbPwd);
		if(!isMatch) {
			throw new RuntimeException("로그인 실패..");
		}
		
		return loginMember;
	}
	
	// 회원가입
	@Override
	public int join(MemberVo vo) {
		
		String pwd = vo.getPwd();
		
		//암호화
		String newPwd = encoder.encode(pwd);
		
		vo.setPwd(newPwd);
		
		return dao.join(sst, vo);
	}
	
	
	
	
}





















