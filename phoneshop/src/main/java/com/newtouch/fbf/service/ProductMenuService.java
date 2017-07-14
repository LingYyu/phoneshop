package com.newtouch.fbf.service;

import java.util.List;

import com.newtouch.fbf.entity.Productmenu;

public interface ProductMenuService {
	//促销，打折商品
	List<Productmenu> selectsales(String sales,String type);

	//根据品牌名查找所有
	List<Productmenu> selectAllByProductId(String productid,String type);
	//产品明细
	Productmenu selectbyId(String id);
	
	/*
	 * 购物车模块
	*/
	List<Productmenu> selectAllbyname(String name);
	
	/*
	 * 根据name和type查询价格
	*/
	
	List<Productmenu> selectAllbynameAndType(String type,String name);
	/*
	 * 管理员插入
	*/
	
	public void insertProductmenu(Productmenu productmenu);
	
	/*查询正在销售中的商品
	 * type=0
	*/
	List<Productmenu> selectAll(String type);
	
	/*
	 * 更新type
	*/
	
	public void UpdateOrder(Productmenu pt); 
	
	List<Productmenu> selectLikeName(String name,String type);
	public void UpdateNum(Productmenu pt); 
	
}
