package com.newtouch.fbf.service.imp;



import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.newtouch.fbf.entity.TCart;
import com.newtouch.fbf.entity.TUserOrder;
import com.newtouch.fbf.service.OrderService;
import com.newtouch.fbf.service.TCartService;

public class Test {

	
	public static void main(String[] args)  {

		OrderService orderservice =new OrderServiceImp();
       String ordertime1="%"+"2017-03-31"+"%";
    	
    	List<TUserOrder> list3=orderservice.AdmainselectAllorderbyordertime(ordertime1);
    	System.out.println(list3.size());
	}
}
