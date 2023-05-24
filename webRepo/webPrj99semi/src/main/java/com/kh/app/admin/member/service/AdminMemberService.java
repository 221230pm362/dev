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
	
	

}//class
























