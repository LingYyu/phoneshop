package com.newtouch.fbf.service;

import java.util.List;

import com.newtouch.fbf.entity.TUserAddress;

public interface AddressService {
	
	//新增收货地址
	public void insertIntoAddress(TUserAddress Tuseraddress);
	
	//查询已有收货地址
	
	List<TUserAddress> selectAllByEmail(String email);
	
	
	//删除地址
	public void  deleteaddress(String id);

}
