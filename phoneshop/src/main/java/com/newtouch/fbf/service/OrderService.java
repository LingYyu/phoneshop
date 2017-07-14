package com.newtouch.fbf.service;

import java.util.Date;
import java.util.List;

import com.newtouch.fbf.entity.TUserOrder;

public interface OrderService {
	/*
	 * 点击购买 状态status=0
	*/
	 public void insertIntoOrder(TUserOrder tuserorder);
	 /*
	  * 确认购买，更新状态  status=1
	  * 
	 */
	 public void UpdateOrder(TUserOrder tu); 
	 /*
	  * 根据orderid查询所有
	 */
	 List<TUserOrder> selectAllByOrderid(String orderid);
	 /*
	  * 根据status查询和Email查询
	  * 
	 */
	 List<TUserOrder> selectAllBystatus(String email,String status);
	 
	 //根据email查询orderid
	 List<TUserOrder> selectAllByemail(String email);
	 
	 /*
	  * 根据status
	  * 
	 */
	 List<TUserOrder> selectAllBystatus1(String status);
	 
	 //查询所有订单
	 List<TUserOrder> selectAllOrder();
	 
	 
	 public void UpdateOrder1(TUserOrder tu); 
	 
	 
	 List<TUserOrder> selectAllprice(String orderid);
	 
	 /*
	  * 根据orderid和ordertime查询订单
	  * 
	 */
	 
	 List<TUserOrder> AdmainselectAllorderbyorderid(String orderid,String ordertime);
	 /*
	  * 根据ordertime查询
	 */
	 
	 List<TUserOrder> AdmainselectAllorderbyordertime(String ordertime);
	 
}
