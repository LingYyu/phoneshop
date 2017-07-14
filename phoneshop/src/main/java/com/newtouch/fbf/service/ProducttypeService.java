package com.newtouch.fbf.service;

import java.util.List;

import com.newtouch.fbf.entity.TProducttype;

public interface ProducttypeService {

	/*
	 * 管理员插入
	*/
	
	public void insertProducttype(TProducttype producttype);
	
	/*
	 * 根据name查询
	*/
	
	List<TProducttype> selectbyname(String name);
	/*
	 * 根据name和type查询
	*/
	TProducttype  selectPrice(String name,String type);
	
	
}
