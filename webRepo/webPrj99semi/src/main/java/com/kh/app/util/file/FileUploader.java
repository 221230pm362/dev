package com.kh.app.util.file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.UUID;

public class FileUploader {
	
	public static void saveFile() {
		
		String path = req.getServletContext().getRealPath("/webapp/static/img/member/profile/");
		String randomName = UUID.randomUUID().toString();
		String originName = f.getSubmittedFileName();
		String ext = originName.substring( originName.lastIndexOf(".") ); 
		String changeName = randomName + ext;
		File target = new File(path + changeName);
		
		FileOutputStream fos = new FileOutputStream(target);
		InputStream is = f.getInputStream();
		byte[] buf = new byte[1024];
		int size = 0;
		while((size = is.read(buf)) != -1) {
			fos.write(buf, 0, size);
		}
		is.close();
		fos.close();
		
	}//method

}//class
