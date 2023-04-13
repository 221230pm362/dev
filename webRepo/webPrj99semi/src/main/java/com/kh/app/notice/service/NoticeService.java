package com.kh.app.notice.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kh.app.common.db.JDBCTemplate;
import com.kh.app.common.page.PageVo;
import com.kh.app.notice.dao.NoticeDao;
import com.kh.app.notice.vo.NoticeVo;

public class NoticeService {
	
	private final NoticeDao dao = new NoticeDao();

	public int selectCnt() throws Exception {
		
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		int cnt = dao.selectCnt(conn);
		
		JDBCTemplate.close(conn);
		
		return cnt;
	}

	public List<NoticeVo> selectNoticeList(PageVo pv) throws Exception {

		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		List<NoticeVo> list = dao.selectNoticeList(conn , pv);
		
		JDBCTemplate.close(conn);
		
		return list;
	}

	public int write(NoticeVo vo) throws Exception {
		//conn
		Connection conn = JDBCTemplate.getConnection();
		
		
		int result = dao.write(conn, vo);
		
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

}//class



















