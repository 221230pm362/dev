package com.kh.app.member.vo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MemberVo {
	
	private String id;
	private String pwd;
	private String nick;

}
