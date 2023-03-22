package com.kh.app.main.member;

import java.sql.Connection;
import java.sql.SQLException;

import static com.kh.app.main.util.JDBCTemplate.*;

public class MemberService implements MemberServiceInterface {
	
	//회원가입
	@Override
	public int join(MemberVo vo) throws Exception {
		
		//비즈니스 로직
		
		//conn 준비
		Connection conn = getConnection();
		
		//SQL (DAO)
		MemberDao dao = new MemberDao();
		int result = dao.join(conn , vo);
		
		//정리 (tx , close)
		if(result == 1) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}//method

}//class
























