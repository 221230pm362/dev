package com.kh.app.admin.member.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kh.app.admin.member.dao.AdminMemberDao;
import com.kh.app.common.db.JDBCTemplate;
import com.kh.app.member.vo.MemberVo;

public class AdminMemberService {

	public List<MemberVo> getMemberList() throws Exception {
		
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		AdminMemberDao dao = new AdminMemberDao();
		List<MemberVo> voList = dao.getMemberList(conn);
		
		//close
		JDBCTemplate.close(conn);
		
		return voList;
	}

	public int restrainMember(String no) throws Exception {
		
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		AdminMemberDao dao = new AdminMemberDao();
		int result = dao.restrainMember(conn , no);
		
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

	public int restrainMembers(String[] noArr) throws Exception {
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		AdminMemberDao dao = new AdminMemberDao();
		int result = dao.restrainMembers(conn, noArr);
		
		//tx || rs
		if(result > 0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		//close
		JDBCTemplate.close(conn);
		
		return result;
	}
	
	

}//class
























