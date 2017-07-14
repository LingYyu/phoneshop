package com.newtouch.fbf.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.newtouch.fbf.base.BaseController;
import com.newtouch.fbf.common.BusiConstant;
import com.newtouch.fbf.common.ResponseEntity;
import com.newtouch.fbf.entity.TUserOrder;
import com.newtouch.fbf.service.OrderService;



/**
 * 后台管理员
 * @author guotong
 *
 */
@RestController
public class AdmainOrderController extends BaseController{  
	
@Autowired	
private OrderService orderservice;	
/*
 * 查询所有订单
 * 
*/
@RequestMapping(value = "/adminorder/selectorder",produces = "application/json")
public ResponseEntity selectorder(String callback,HttpSession session,HttpServletRequest request){
	 ResponseEntity r=new ResponseEntity();
	
	 List<TUserOrder> list=orderservice.selectAllOrder();
	
	 List<List<TUserOrder>> list1=new ArrayList<List<TUserOrder>>();
		List<TUserOrder> list2=null;
		for(int i=0;i<list.size();i++)
		{
			 BigDecimal  count1=new BigDecimal("0");
			
			list2=orderservice.selectAllByOrderid(list.get(i).getOrderid());
			List<TUserOrder> tt=orderservice.selectAllByOrderid(list.get(i).getOrderid());
			for(TUserOrder to:tt)
			{
				count1=count1.add(to.getCount());
			}
			for(int j=0;j<list2.size();j++)
			{
				list2.get(j).setAllprice(count1);
				if(list2.get(j).getStatus().equals("0"))
				{
					list2.get(j).setStatus("未支付");
					list2.get(j).setChangestatus("等待支付");
				}
				if(list2.get(j).getStatus().equals("1"))
				{
					list2.get(j).setStatus("待发货");
					list2.get(j).setChangestatus("发货");
				}
				if(list2.get(j).getStatus().equals("2"))
				{
					list2.get(j).setStatus("查看物流");
					list2.get(j).setChangestatus("等待收货");
				}
				if(list2.get(j).getStatus().equals("3"))
				{
					list2.get(j).setStatus("收货成功");
					list2.get(j).setChangestatus("交易成功");
				}
				System.out.println(list2.get(j).getStatus());
				
			}
			list1.add(list2);
		}
		 r.setStatus(BusiConstant.STATUS_SUCCESS);
		 r.setData(list1);	
	return r;
	
}
/*
 * 查询待发货状态status=1
 * 查询已发货状态status=2
 * 查询交易完成状态status=3
*/
@RequestMapping(value = "/adminorder/selectorder1",produces = "application/json")
public ResponseEntity selectorder1(String callback,HttpSession session,HttpServletRequest request,String status){
	ResponseEntity r=new ResponseEntity();
	
	List<TUserOrder> list=orderservice.selectAllBystatus1(status);
	
	List<List<TUserOrder>> list1=new ArrayList<List<TUserOrder>>();
	
	List<TUserOrder> list2=null;
	for(int i=0;i<list.size();i++)
	{
		BigDecimal  count1=new BigDecimal("0");
		list2=orderservice.selectAllByOrderid(list.get(i).getOrderid());
		List<TUserOrder> tt=orderservice.selectAllByOrderid(list.get(i).getOrderid());
		for(TUserOrder to:tt)
		{
			count1=count1.add(to.getCount());
		}
		for(int j=0;j<list2.size();j++)
		{
			list2.get(j).setAllprice(count1);
			if(list2.get(j).getStatus().equals("0"))
			{
				list2.get(j).setStatus("未支付");
				list2.get(j).setChangestatus("等待支付");
			}
			if(list2.get(j).getStatus().equals("1"))
			{
				list2.get(j).setStatus("待发货");
				list2.get(j).setChangestatus("发货");
			}
			if(list2.get(j).getStatus().equals("2"))
			{
				list2.get(j).setStatus("查看物流");
				list2.get(j).setChangestatus("等待收货");
			}
			if(list2.get(j).getStatus().equals("3"))
			{
				list2.get(j).setStatus("收货成功");
				list2.get(j).setChangestatus("交易成功");
			}
			System.out.println(list2.get(j).getStatus());
			
		}
		list1.add(list2);
	}
	 r.setStatus(BusiConstant.STATUS_SUCCESS);
	 r.setData(list1);	
	return r;
	
}
/*
 * 点击发货状态变为2
 * 
*/
	
@RequestMapping(value = "/adminorder/fahuo",produces = "application/json")
public ResponseEntity fahuo(String callback,HttpSession session,HttpServletRequest request,String orderid){
	ResponseEntity r=new ResponseEntity();
	 List<TUserOrder> list=orderservice.selectAllByOrderid(orderid);
	    System.out.println(list.size()+"长度"); 
	    for(int i=0;i<list.size();i++)
	    {
	    	TUserOrder to=new TUserOrder();
	    	to.setId(list.get(i).getId());
	    	to.setStatus("2");//点击发货，状态改为2
	    	orderservice.UpdateOrder1(to);
	    }
	 r.setStatus(BusiConstant.STATUS_SUCCESS);
	 r.setData(list);	
	return r;
	
}
/*
 * 模糊查询
*/
@RequestMapping(value = "/adminorder/mohu",produces = "application/json")
public ResponseEntity select(String callback,HttpSession session,HttpServletRequest request,String orderid,String ordertime){
	ResponseEntity r=new ResponseEntity();
	List<List<TUserOrder>> list1=new ArrayList<List<TUserOrder>>();
	List<TUserOrder> list2=null;
	System.out.println(orderid+"  hhh "+ordertime);
	if(orderid==""&&ordertime=="")
	{
		List<TUserOrder>	list3=orderservice.selectAllOrder();
		
		for(int i=0;i<list3.size();i++)
		{
			BigDecimal  count1=new BigDecimal("0");
			list2=orderservice.selectAllByOrderid(list3.get(i).getOrderid());
			List<TUserOrder> tt=orderservice.selectAllByOrderid(list3.get(i).getOrderid());
			for(TUserOrder to:tt)
			{
				count1=count1.add(to.getCount());
			}
			for(int j=0;j<list2.size();j++)
			{
				list2.get(j).setAllprice(count1);
				if(list2.get(j).getStatus().equals("0"))
				{
					list2.get(j).setStatus("未支付");
					list2.get(j).setChangestatus("等待支付");
				}
				if(list2.get(j).getStatus().equals("1"))
				{
					list2.get(j).setStatus("待发货");
					list2.get(j).setChangestatus("发货");
				}
				if(list2.get(j).getStatus().equals("2"))
				{
					list2.get(j).setStatus("查看物流");
					list2.get(j).setChangestatus("等待收货");
				}
				if(list2.get(j).getStatus().equals("3"))
				{
					list2.get(j).setStatus("收货成功");
					list2.get(j).setChangestatus("交易成功");
				}
				System.out.println(list2.get(j).getStatus());
				
			}
			list1.add(list2);
		}
		 r.setStatus(BusiConstant.STATUS_SUCCESS);
		 r.setData(list1);
			
		}
	
	if(orderid!=""&&ordertime=="")//orderid不为空 ordertime==null;
	{
		list2=orderservice.selectAllByOrderid(orderid);
		List<TUserOrder> tt=orderservice.selectAllByOrderid(orderid);
		BigDecimal  count1=new BigDecimal("0");
		for(TUserOrder to:tt)
		{
			count1=count1.add(to.getCount());
		}
		
		for(int j=0;j<list2.size();j++)
		{
			list2.get(j).setAllprice(count1);
			if(list2.get(j).getStatus().equals("0"))
			{
				list2.get(j).setStatus("未支付");
				list2.get(j).setChangestatus("等待支付");
			}
			if(list2.get(j).getStatus().equals("1"))
			{
				list2.get(j).setStatus("待发货");
				list2.get(j).setChangestatus("发货");
			}
			if(list2.get(j).getStatus().equals("2"))
			{
				list2.get(j).setStatus("查看物流");
				list2.get(j).setChangestatus("等待收货");
			}
			if(list2.get(j).getStatus().equals("3"))
			{
				list2.get(j).setStatus("收货成功");
				list2.get(j).setChangestatus("交易成功");
			}
			System.out.println(list2.get(j).getStatus());
			
		}
		list1.add(list2);
	 r.setStatus(BusiConstant.STATUS_SUCCESS);
	 r.setData(list1);
		
	}
    if(orderid==""&&ordertime!="")//orderid==null  ordertime不为空
    {
    	String ordertime1="%"+ordertime+"%";
    	
    	List<TUserOrder> list3=orderservice.AdmainselectAllorderbyordertime(ordertime1);
    	System.out.println(list3.size()+"hh");
    	for(int i=0;i<list3.size();i++)
    	{
    		BigDecimal  count1=new BigDecimal("0");
			list2=orderservice.selectAllByOrderid(list3.get(i).getOrderid());
			List<TUserOrder> tt=orderservice.selectAllByOrderid(list3.get(i).getOrderid());
			for(TUserOrder to:tt)
			{
				count1=count1.add(to.getCount());
			}
			for(int j=0;j<list2.size();j++)
			{
				list2.get(j).setAllprice(count1);
				if(list2.get(j).getStatus().equals("0"))
				{
					list2.get(j).setStatus("未支付");
					list2.get(j).setChangestatus("等待支付");
				}
				if(list2.get(j).getStatus().equals("1"))
				{
					list2.get(j).setStatus("待发货");
					list2.get(j).setChangestatus("发货");
				}
				if(list2.get(j).getStatus().equals("2"))
				{
					list2.get(j).setStatus("查看物流");
					list2.get(j).setChangestatus("等待收货");
				}
				if(list2.get(j).getStatus().equals("3"))
				{
					list2.get(j).setStatus("收货成功");
					list2.get(j).setChangestatus("交易成功");
				}
				System.out.println(list2.get(j).getStatus());
				
			}
			list1.add(list2);
			
		}
    	 r.setStatus(BusiConstant.STATUS_SUCCESS);
		 r.setData(list1);
    	}

    if(orderid!=""&ordertime!="")//orderid,ordertime都不为空
    {
       String ordertime1="%"+ordertime+"%";
    	
    	List<TUserOrder> list3=orderservice.AdmainselectAllorderbyordertime(ordertime1);
    	System.out.println(list3.size()+"hh");
    	for(int i=0;i<list3.size();i++)
    	{
    		String orderid1=list3.get(i).getOrderid();
    		System.out.println(orderid1+"hhhhh");
    		if(orderid.equals(orderid1))
    		{
    			
        		BigDecimal  count1=new BigDecimal("0");
    			list2=orderservice.selectAllByOrderid(orderid);
    			List<TUserOrder> tt=orderservice.selectAllByOrderid(orderid);
    			for(TUserOrder to:tt)
    			{
    				count1=count1.add(to.getCount());
    			}
    			for(int j=0;j<list2.size();j++)
    			{
    				list2.get(j).setAllprice(count1);
    				if(list2.get(j).getStatus().equals("0"))
    				{
    					list2.get(j).setStatus("未支付");
    					list2.get(j).setChangestatus("等待支付");
    				}
    				if(list2.get(j).getStatus().equals("1"))
    				{
    					list2.get(j).setStatus("待发货");
    					list2.get(j).setChangestatus("发货");
    				}
    				if(list2.get(j).getStatus().equals("2"))
    				{
    					list2.get(j).setStatus("查看物流");
    					list2.get(j).setChangestatus("等待收货");
    				}
    				if(list2.get(j).getStatus().equals("3"))
    				{
    					list2.get(j).setStatus("收货成功");
    					list2.get(j).setChangestatus("交易成功");
    				}
    				System.out.println(list2.get(j).getStatus());
    				
    			}
    			list1.add(list2);
    			
    		}
    		 r.setStatus(BusiConstant.STATUS_SUCCESS);
    		 r.setData(list1);
    	}
    	
    }
 
	return r;
	
}


}




	
