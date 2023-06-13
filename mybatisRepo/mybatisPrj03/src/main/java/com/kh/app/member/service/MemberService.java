package com.kh.app.member.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kh.app.db.MybatisTemplate;
import com.kh.app.member.dao.MemberDao;
import com.kh.app.member.vo.MemberVo;

public class MemberService {
	
	private final MemberDao dao = new MemberDao();

	public List<MemberVo> getMemberList(String[] numArr) {
		SqlSession ss = MybatisTemplate.getSqlSession();
		
		List<MemberVo> voList = dao.getMemberList(ss , numArr);
		
		ss.close();
		
		return voList;
	}

	public MemberVo getMemberByNo(String no) {
		//커넥션
		SqlSession ss = MybatisTemplate.getSqlSession();
		
		MemberVo vo = dao.getMemberByNo(ss, no);
		
		//close
		ss.close();
		
		return vo;
	}

	public int insertMember(MemberVo vo) {
		//conn
		SqlSession ss = MybatisTemplate.getSqlSession();
		//sql == DAO
		int result = dao.insertMember(ss , vo);
		//tx
		if(result == 1) {
			ss.commit();
		}else {
			ss.rollback();
		}
		//close
		ss.close();
		return result;
	}

	public int delete(String no) {
		//conn
		SqlSession ss = MybatisTemplate.getSqlSession();
		//sql == dao
		int result = dao.delete(ss , no);
		//tx
		if(result == 1) {
			ss.commit();
		}else {
			ss.rollback();
		}
		//close
		ss.close();
		return result;
	}

	public int edit(MemberVo vo) {
		SqlSession ss = MybatisTemplate.getSqlSession();
		int result = dao.edit(ss , vo);
		if(result == 1) {
			ss.commit();
		}else {
			ss.rollback();
		}
		ss.close();
		return result;
	}

}//class

























