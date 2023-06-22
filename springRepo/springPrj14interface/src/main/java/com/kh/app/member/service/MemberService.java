package com.kh.app.member.service;

import com.kh.app.member.vo.MemberVo;

public interface MemberService {
	
	//회원가입
	int join(MemberVo vo);
	
	//로그인
	MemberVo login(MemberVo vo);

}
