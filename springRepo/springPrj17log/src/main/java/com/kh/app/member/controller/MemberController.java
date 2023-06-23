package com.kh.app.member.controller;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("member")
@RequiredArgsConstructor
@Slf4j
public class MemberController {
	
	//회원가입
	@PostMapping("join")
	@ResponseBody
	public String join(@RequestParam HashMap<String, String> paramMap) {
		
		log.debug("회원가입 요청 받음 ~~~");
		log.debug("전달받은 데이터 : {}" , paramMap.toString());
		
		return "join OK ~~~";
	}

}//class

















