package com.kh.app.main.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.kh.app.main.util.JDBCTemplate;

public class MemberDao {
	
	//회원가입
	public int join(Connection conn , MemberVo vo) throws Exception {
		
		//SQL (close)
		String sql = "INSERT INTO MEMBER (NO, ID, PWD, NICK) VALUES(SEQ_MEMBER_NO.NEXTVAL , ?, ?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getId());
		pstmt.setString(2, vo.getPwd());
		pstmt.setString(3, vo.getNick());
		int result = pstmt.executeUpdate();
		
		JDBCTemplate.close(pstmt);
		
		return result;
	}

}//class























