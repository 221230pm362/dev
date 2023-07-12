package com.kh.app.member.dao;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.app.member.vo.MemberVo;

public interface MemberDao {
	
	// 회원가입
	int join(SqlSessionTemplate sst, MemberVo vo);
	
	// 로그인
	MemberVo login(SqlSessionTemplate sst, MemberVo vo);
	
	// 수정
	int edit(SqlSessionTemplate sst, MemberVo vo);
	
	// 탈퇴
	int quit(SqlSessionTemplate sst, int no);
	
}
