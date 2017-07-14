package com.ghw.org.test;


import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;
/**
 * <p>Title:  </p>
 * <p>Description:  图片上传</p>
 * @author guo
 * @date
 */
public class UploadUtils {
	public static String uploadFile(MultipartFile file, HttpServletRequest request) {
		if(file.isEmpty()) {
			return null;
		}
		String fileName1 = file.getOriginalFilename();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String fileName="../images/"+sdf.format(new Date()) + fileName1;
		FileOutputStream outputStream;
		try {
			outputStream = new FileOutputStream("D:/Code/sublime/MobileShop/MobileShop-front/images/"+ fileName);
			outputStream.write(file.getBytes());
			outputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("D:/Code/sublime/MobileShop/MobileShop-front/images/" + fileName);
		return fileName;
	}
	
	public static String uploadFile1(MultipartFile file, HttpServletRequest request) {
		if(file.isEmpty()) {
			return null;
		}
		String fileName1 = file.getOriginalFilename();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String fileName="../images/"+sdf.format(new Date()) + fileName1;
		FileOutputStream outputStream;
		try {
			outputStream = new FileOutputStream("D:/Code/sublime/MobileShop/MobileShop-back/images/"+ fileName);
			outputStream.write(file.getBytes());
			outputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("D:/Code/sublime/MobileShop/MobileShop-back/images/" + fileName);
		return fileName;
	}
}

