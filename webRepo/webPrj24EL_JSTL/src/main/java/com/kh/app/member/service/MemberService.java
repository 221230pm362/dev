package com.kh.app.member.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kh.app.member.dao.MemberDao;
import com.kh.app.member.vo.MemberVo;
import com.kh.app.util.JDBCTemplate;

public class MemberService {

	//회원가입
	public int join(MemberVo vo) throws Exception {
		
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//SQL
		MemberDao dao = new MemberDao();
		int result = dao.join(conn , vo);
		
		//tx || rs
		if( result == 1 ) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		//close
		JDBCTemplate.close(conn);

		return result;
	}

	//회원 목록
	public List<MemberVo> selectList() throws Exception {

		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		MemberDao dao = new MemberDao();
		List<MemberVo> voList = dao.selectList(conn);
		
		//close
		JDBCTemplate.close(conn);
		
		return voList;
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

	//정보 수정 , 조회(no)
	public MemberVo edit(MemberVo vo) throws Exception {
		
		//conn
		Connection conn = JDBCTemplate.getConnection();
		MemberVo updatedMember = null;
		
		try {
			//SQL
			MemberDao dao = new MemberDao();
			int result = dao.edit(conn , vo);
			
			//tx || rs
			
			if(result == 1) {
				updatedMember = dao.selectOneByNo(conn , vo.getNo());
				if(updatedMember == null) {
					JDBCTemplate.rollback(conn);
					throw new Exception("업데이트는 되었는데 셀렉트 실패함...");
				}
				JDBCTemplate.commit(conn);
			}else {
				JDBCTemplate.rollback(conn);
			}
		}finally {
			//close
			JDBCTemplate.close(conn);
		}
		
		return updatedMember;
	}

	
	//탈퇴
	public int del(String no) throws Exception {
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		//SQL
		String sql = "DELETE FROM MEMBER WHERE NO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, no);
		int result = pstmt.executeUpdate();
		
		//tx || rs
		if(result == 1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		//close
		JDBCTemplate.close(pstmt);
		JDBCTemplate.close(conn);
		
		return result;
	}
	
	
	
	
	
	

}//class





















