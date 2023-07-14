package com.kh.app.member.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.app.exception.LoginFailException;
import com.kh.app.member.dao.MemberDao;
import com.kh.app.member.vo.MemberVo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class MemberServiceImpl implements MemberService {

	private final SqlSessionTemplate sst;
	private final MemberDao dao;
	private final BCryptPasswordEncoder pwdEncoder;
	
	@Override
	public int join(MemberVo vo) {
		
		//검증
		if(vo.getPwd().length() < 4) {
			throw new RuntimeException("비밀번호 길이는 4글자 이상이어야 합니다.");
		}
		
		String pwd = vo.getPwd();
		String newPwd = pwdEncoder.encode(pwd);
		vo.setPwd(newPwd);
		
		return dao.join(sst, vo);
	}

	@Override
	public MemberVo login(MemberVo vo) {
		MemberVo loginMember = null;
		try {
			loginMember = dao.login(sst, vo);
			
			//boolean isMatch = loginMember.getPwd().equals(vo.getPwd());
			boolean isMatch = pwdEncoder.matches(vo.getPwd(), loginMember.getPwd());
			
			if(!isMatch) {
				throw new LoginFailException();
			}
		}catch(Exception e) {
			throw new LoginFailException();
		}
		
		return loginMember;
	}

	@Override
	public int edit(MemberVo vo) {
		return 0;
	}

	@Override
	public int quit(int no) {
		return 0;
	}

}
