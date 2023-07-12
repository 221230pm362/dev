package com.kh.app.member.service;

import com.kh.app.member.vo.MemberVo;

public interface MemberService {

	// 회원가입
	int join(MemberVo vo);
	
	// 로그인
	MemberVo login(MemberVo vo);
	
	// 수정
	int edit(MemberVo vo);
	
	// 탈퇴
	int quit(int no);
	
}//class
























