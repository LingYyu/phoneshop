package com.newtouch.fbf.service;

import java.util.List;

import com.newtouch.fbf.entity.Product;

public interface ProductService {

	//查找品牌名
	
	List<Product> selectproductname();
	
	Product selectproductidByproductname(String productname);
	
	/*
	 * 根据productid查询productname
	*/
	Product selectproductNamebyProuctid(String productid);
	
	/*
	 * 管理员插入
	*/
	public void insertProduct(Product product);
	
	
}
