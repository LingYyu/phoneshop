package com.newtouch.fbf.controller;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.newtouch.fbf.base.BaseController;
import com.newtouch.fbf.common.BusiConstant;
import com.newtouch.fbf.common.ResponseEntity;
import com.newtouch.fbf.entity.Productmenu;
import com.newtouch.fbf.entity.TProducttype;
import com.newtouch.fbf.entity.TUserOrder;
import com.newtouch.fbf.service.OrderService;
import com.newtouch.fbf.service.ProductMenuService;
import com.newtouch.fbf.service.ProducttypeService;



/**
 * 订单列表
 * @author guotong
 * 
 * 未付款 状态status=0
 * 确认支付状态status=1
 * 待发货状态status=1（后台管理员）
 * 代收货状态status=2
 * 待评价状态status=3
 *
 */
@RestController
public class TUserOrderController extends BaseController{  

@Autowired	
private OrderService orderservice;	
@Autowired
private ProductMenuService productmenuService;
@Autowired
private ProducttypeService ps;

/*
 * 查询所有订单
 * 
*/
@RequestMapping(value = "/selectAllOrder",produces = "application/json")
public ResponseEntity selectAllOrder(String callback,HttpSession session,HttpServletRequest request){
	ResponseEntity r=new ResponseEntity();
	String email=(String)session.getAttribute("email");
	if(email==null||email=="")
	{
		 r.setStatus(BusiConstant.STATUS_ERROR);
		 System.out.println(email);
	}
	else
	{
	List<TUserOrder> list=orderservice.selectAllByemail(email);
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
		System.out.println(count1);
		for(int j=0;j<list2.size();j++)
		{
			list2.get(j).setAllprice(count1);
			if(list2.get(j).getStatus().equals("0"))
			{
				list2.get(j).setStatus("未支付");
				list2.get(j).setChangestatus("继续支付");
			}
			if(list2.get(j).getStatus().equals("1"))
			{
				list2.get(j).setStatus("等待发货");
				list2.get(j).setChangestatus("提醒发货");
			}
			if(list2.get(j).getStatus().equals("2"))
			{
				list2.get(j).setStatus("查看物流");
				list2.get(j).setChangestatus("确认收货");
			}
			if(list2.get(j).getStatus().equals("3"))
			{
				list2.get(j).setStatus("交易成功");
				list2.get(j).setChangestatus("交易成功");
			}
			System.out.println(list2.get(j).getStatus());
			
		}
		list1.add(list2);
	}
	System.out.println(list1.size());
	 r.setStatus(BusiConstant.STATUS_SUCCESS);
	 r.setData(list1);	
	}
	return r;
	
}
/*
 * 查询未支付状态status=0
 * 查询待发货状态status=1
 * 查询待收货状态status=2
 * 查询待评价状态status=3
*/
@RequestMapping(value = "/selectOrder1",produces = "application/json")
public ResponseEntity selectOrder1(String callback,HttpSession session,HttpServletRequest request,String status){
	ResponseEntity r=new ResponseEntity();
	String email=(String)session.getAttribute("email");
	List<TUserOrder> list=orderservice.selectAllBystatus(email,status);//查询orderid
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
				list2.get(j).setChangestatus("继续支付");
			}
			if(list2.get(j).getStatus().equals("1"))
			{
				list2.get(j).setStatus("等待发货");
				list2.get(j).setChangestatus("提醒发货");
			}
			if(list2.get(j).getStatus().equals("2"))
			{
				list2.get(j).setStatus("查看物流");
				list2.get(j).setChangestatus("确认收货");
			}
			if(list2.get(j).getStatus().equals("3"))
			{
				list2.get(j).setStatus("交易成功");
				list2.get(j).setChangestatus("待评价");
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
 * 立即购买  状态=0  
*/
@RequestMapping(value = "/insertOrder",produces = "application/json")
public ResponseEntity insertOrder(String callback,HttpSession session,HttpServletRequest request,String color,String type,int qty){
	
	     ResponseEntity r=new ResponseEntity();
	     session.removeAttribute("e");
	     String email=(String)session.getAttribute("email");
	     String name=(String)session.getAttribute("name1");
	     TUserOrder torder=new TUserOrder();
	     List<TUserOrder> tlist=new ArrayList<>();
	     if(email==null||email=="")
	     {
	     r.setStatus(BusiConstant.STATUS_ERROR);
	     }
	     else if(color==null||color==""||type==null||type=="")
	 	{
	 		r.setStatus("3");
	 		System.out.println(r.getStatus()+"gtgt");
	 	}
	     else
	     {
	    	 torder.setEmail(email);
	    	 torder.setId(UUID.randomUUID().toString());
	    	 torder.setNum(qty);
	    	 torder.setOrdertime(new Date());
	    	 torder.setName(name);
	    	 List<Productmenu> plist=productmenuService.selectAllbyname(name);
	    	 torder.setPicture(plist.get(0).getPicture());
//	    	 torder.setPicture(picture);
//	    	 List<Productmenu> plist=productmenuService.selectAllbynameAndType(type, name);//根据type和name查询单价
//	    	 torder.setPrice(plist.get(0).getPrice());
	    	 TProducttype tp=ps.selectPrice(name, type);
	    	 torder.setPrice(tp.getPrice());
	    	 String producttype="颜色:"+color+" / "+"内存:"+type;
	    	 torder.setProducttype(producttype);
	    	 torder.setStatus("0");
	    	 torder.setAddress("地址");
	    	 Calendar calendar=Calendar.getInstance();
		     long sss=calendar.getTime().getTime();
		     String e=Long.toString(sss);
	    	 torder.setOrderid(e);//订单号
	    	 session.setAttribute("e", e);
	    	 BigDecimal a=new BigDecimal(qty);
		     torder.setCount(torder.getPrice().multiply(a));
//		     session.setAttribute("torder", torder);
		     tlist.add(torder);
		     
		    Productmenu pt=new Productmenu();
		 	pt.setNum(plist.get(0).getNum()-qty);
		 	pt.setId(plist.get(0).getId());
		 	pt.setName(name);
		 	productmenuService.UpdateNum(pt);
		     
		     session.setAttribute("tlist", tlist);
		     orderservice.insertIntoOrder(torder);
	    	 r.setStatus(BusiConstant.STATUS_SUCCESS);
			 r.setData(torder);
	    	 
	     }

	return r;
}

/*
 * pay页面
*/
@RequestMapping(value = "/pay",produces = "application/json")
public ResponseEntity pay(String callback,HttpSession session,HttpServletRequest request){
	ResponseEntity r=new ResponseEntity();
	
//	TUserOrder torder=(TUserOrder) session.getAttribute("torder");
	@SuppressWarnings("unchecked")
	List<TUserOrder> tlist=(List<TUserOrder>) session.getAttribute("tlist");
	
	 r.setStatus(BusiConstant.STATUS_SUCCESS);
	 r.setData(tlist);	
	return r;
	
}

/*
 * 提交订单status改为1
 *
*/
@RequestMapping(value = "/updateOrder",produces = "application/json")
public ResponseEntity updateOrder(String address,String city,String callback,HttpSession session,HttpServletRequest request){
	
    ResponseEntity r=new ResponseEntity();
   // String email=(String)session.getAttribute("email");
    String orderid=(String) session.getAttribute("e");
    System.out.println(address+"   "+city);
    if(address==""&&city=="")
    {
    	 r.setStatus(BusiConstant.STATUS_ERROR);
    }
    else
    {
    String address1=city+address;
    List<TUserOrder> list=orderservice.selectAllByOrderid(orderid);
    System.out.println(list.size()+"长度"); 
    for(int i=0;i<list.size();i++)
    {
    	TUserOrder to=new TUserOrder();
    	to.setId(list.get(i).getId());
    	to.setOrdertime(new Date());
    	to.setAddress(address1);
    	to.setStatus("1");
    	orderservice.UpdateOrder1(to);
    	
    }
    r.setStatus(BusiConstant.STATUS_SUCCESS);
    r.setData(orderid);
    }
return r;
}

/*
 * 确认收货状态变为3
 * 
*/
	
@RequestMapping(value = "/adminorder/sucess",produces = "application/json")
public ResponseEntity sucess(String callback,HttpSession session,HttpServletRequest request,String orderid){
	ResponseEntity r=new ResponseEntity();
	 List<TUserOrder> list=orderservice.selectAllByOrderid(orderid);
	    System.out.println(list.size()+"长度"); 
	    for(int i=0;i<list.size();i++)
	    {
	    	TUserOrder to=new TUserOrder();
	    	to.setId(list.get(i).getId());
	    	to.setStatus("3");//点击确认收货，状态改为3
	    	orderservice.UpdateOrder1(to);
	    	
	    }
	 r.setStatus(BusiConstant.STATUS_SUCCESS);
	 r.setData(list);	
	return r;
	
}


/*
 * 继续支付
 * 
*/
	
@RequestMapping(value = "/adminorder/continuepay",produces = "application/json")
public ResponseEntity continuepay(String callback,HttpSession session,HttpServletRequest request,String orderid){
	ResponseEntity r=new ResponseEntity();
	session.removeAttribute("tlist");
	session.setAttribute("e", orderid);
	 List<TUserOrder> tlist=orderservice.selectAllByOrderid(orderid);
	 session.setAttribute("tlist", tlist);
	 r.setStatus(BusiConstant.STATUS_SUCCESS);
	 r.setData(tlist);	
	return r;
	
}



}


