package com.newtouch.fbf.service;

import java.util.List;

import com.newtouch.fbf.entity.TProductcolor;

public interface ProductcolorService {
/*
 * 管理员插入
*/	
	
	public void insertProductcolor(TProductcolor productcolor);
	/*
	 * 根据name查询
	*/
	
	List<TProductcolor> selectcolor(String name);
}
