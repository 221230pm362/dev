package com.kh.app.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kh.app.member.vo.MemberVo;

public class MemberDao {

	public List<MemberVo> getMemberList(SqlSession ss, String[] numArr) {
		return ss.selectList("member.getMemberList" , numArr);
	}

	public MemberVo getMemberByNo(SqlSession ss, String no) {
		return ss.selectOne("member.getMemberByNo" , no);
	}

	public int insertMember(SqlSession ss, MemberVo vo) {
		return ss.insert("member.insertMember" , vo);
	}

	public int delete(SqlSession ss, String no) {
		return ss.delete("member.quit" , no);
	}

	public int edit(SqlSession ss, MemberVo vo) {
		return ss.update("member.updateMember" , vo);
	}

}//class






















