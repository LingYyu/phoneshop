package com.newtouch.fbf.service;

import java.util.List;

import com.newtouch.fbf.entity.TCart;

public interface TCartService {
/*
 * 添加购物车
*/	
public void insertCart(TCart tcart);


/*
 * 查询购物车
*/

List<TCart> selectByEmail(String email,String status);

/*
 * 结算根据id查询
 * 
*/

TCart selectByid(String id);

/*
 * 更新购物车状态
*/
public void update(TCart t);

/*
 * 删除购物车
*/


public void  deletecart(String id);



}
