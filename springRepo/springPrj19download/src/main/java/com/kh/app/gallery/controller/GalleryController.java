package com.kh.app.gallery.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("gallery")
public class GalleryController {
	
	//갤러리 목록
	@GetMapping("list")
	public void list() {}
	
	//다운로드 (기존방식)
	//@GetMapping("download")
	public void download(HttpServletRequest req, HttpServletResponse resp) throws Exception {

		//파일이 없을 때
		//resp.sendError(404);
		
		//다운로드
		//헤더 셋팅
		resp.setHeader("Content-Type", "appliation/octet-stream");
		resp.setHeader("Content-Disposition", "attachment; filename=hello.png");
		resp.setHeader("Content-Length", "21811");
		
		//파일내보내기
		String root = req.getServletContext().getRealPath("/resources/img/");
		String path = root + "test.png";
		File target = new File(path);
		byte[] data = FileUtils.readFileToByteArray(target);
		resp.getOutputStream().write(data);
	}
	
	
	//다운로드 (스프링방식)
	@GetMapping("download")
	public ResponseEntity<ByteArrayResource> download(HttpServletRequest req ) throws Exception {
		
		//파일 객체 준비 (바이트배열준비를 위함)
		String root = req.getServletContext().getRealPath("/resources/img/");
		String path = root + "test.png";
		File target = new File(path);
		byte[] data = FileUtils.readFileToByteArray(target);
		ByteArrayResource x = new ByteArrayResource(data);
		
		return ResponseEntity
				.ok()
				.contentType(MediaType.APPLICATION_OCTET_STREAM)
				.contentLength(target.length())
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=hello.png")
				.header(HttpHeaders.CONTENT_ENCODING, "UTF-8")
				.body(x)
				;
	}
	
	
	public void m01() {
		
		MemberVo vo = MemberVo.temp()
			.id("user01")
			.pwd("1234")
			.nick("nick01")
			.build()
			;
		
	}
	
	

}//class







