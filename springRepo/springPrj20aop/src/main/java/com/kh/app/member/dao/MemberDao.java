package com.kh.app.member.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.app.member.vo.MemberVo;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class MemberDao {
	
	public int join(SqlSessionTemplate sst, MemberVo vo) {
		System.out.println("join 호출됨 ~~~~~");
		return sst.insert("member.join" , vo);
//		long start = System.currentTimeMillis();
//		int result = sst.insert("member.join" , vo);
//		long end = System.currentTimeMillis();
//		long time = end - start;
//		log.debug("join 에 걸린 시간 : {}ms" , time);
//		return result;
	}

	public MemberVo login(SqlSessionTemplate sst, MemberVo vo) {
		System.out.println("login 호출됨 ~~~~~");
		return sst.selectOne("member.login", vo);
//		long start = System.currentTimeMillis();
//		MemberVo loginMember = sst.selectOne("member.login", vo);
//		long end = System.currentTimeMillis();
//		long time = end - start;
//		log.debug("login 에 걸린 시간 : {}ms" , time);
//		return loginMember;
	}

}//class
























