package com.kh.app.gallery.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("gallery")
@Slf4j
public class GalleryController {
	
	//갤러리 글 작성하기 (화면)
	@GetMapping("write")
	public void write() {}
	
	//갤러리 글 작성하기
	@PostMapping("write")
	public void write(String title , List<MultipartFile> fList, HttpServletRequest req) throws Exception {

		//파일 한개만 꺼냄
		MultipartFile f = fList.get(0);
		
		//비어있는지 확인
		if(f.isEmpty()) {
			throw new RuntimeException("파일 안넘어왔음");
		}
		
		//서버측에 저장
		String savePath = req.getServletContext().getRealPath("/resources/upload/gallery/img/");
		String path = savePath + "abc.png";
		File target = new File(path);
		
		f.transferTo(target);
		
		
		
	}

}//class























