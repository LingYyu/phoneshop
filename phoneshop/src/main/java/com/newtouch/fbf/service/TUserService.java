package com.newtouch.fbf.service;

import java.util.List;

import com.newtouch.fbf.entity.TUser;

public interface TUserService {
	
	//注册
	public void insertintot_user(TUser tuser);

	//登录
	List<TUser> selectemailAndpassword(String email,String password);
	//根据用户名查
	List<TUser> selectEmail(String email);
	//更新个人信息；
	public String updateTuser(TUser tuser);
}
