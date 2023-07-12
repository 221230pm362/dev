package com.kh.app.member.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.app.member.vo.MemberVo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Repository
@RequiredArgsConstructor
public class MemberDaoImpl implements MemberDao {
	
	@Override
	public int join(SqlSessionTemplate sst, MemberVo vo) {
		return sst.insert("member.join" , vo);
	}

	@Override
	public MemberVo login(SqlSessionTemplate sst, MemberVo vo) {
		return sst.selectOne("member.login" , vo);
	}

	@Override
	public int edit(SqlSessionTemplate sst, MemberVo vo) {
		return 0;
	}

	@Override
	public int quit(SqlSessionTemplate sst, int no) {
		return 0;
	}
	
}
