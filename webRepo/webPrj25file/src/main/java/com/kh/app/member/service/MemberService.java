package com.kh.app.member.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kh.app.member.dao.MemberDao;
import com.kh.app.member.vo.MemberVo;
import com.kh.app.util.JDBCTemplate;

public class MemberService {

	//회원가입
	public int join(MemberVo vo) throws Exception {

		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		MemberDao dao = new MemberDao();
		int result = dao.join(conn , vo);
		
		//tx || rs
		if(result == 1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		//close
		JDBCTemplate.close(conn);
	
		return result;
	}

	//로그인
	public MemberVo login(MemberVo vo) throws Exception {
		
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		MemberDao dao = new MemberDao();
		MemberVo loginMember = dao.login(conn , vo);
		
		//close
		JDBCTemplate.close(conn);

		return loginMember;
	}
	
}//class








