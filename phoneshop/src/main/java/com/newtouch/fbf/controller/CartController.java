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

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.newtouch.fbf.base.BaseController;
import com.newtouch.fbf.common.BusiConstant;
import com.newtouch.fbf.common.ResponseEntity;
import com.newtouch.fbf.entity.Productmenu;
import com.newtouch.fbf.entity.TCart;
import com.newtouch.fbf.entity.TProducttype;
import com.newtouch.fbf.entity.TUserOrder;
import com.newtouch.fbf.service.OrderService;
import com.newtouch.fbf.service.ProductMenuService;
import com.newtouch.fbf.service.ProducttypeService;
import com.newtouch.fbf.service.TCartService;

/**
 * 购物车列表
 * @author guotong
 *
 */
@RestController
public class CartController extends BaseController{  

@Autowired
private TCartService ts;
@Autowired
private ProductMenuService productmenuService;
@Autowired
private ProducttypeService ps;
@Autowired	
private OrderService orderservice;	
//添加购物车
@RequestMapping(value = "/insertCart",produces = "application/json")
   public ResponseEntity insertCart(String callback,HttpSession session,HttpServletRequest request,String color,String type,Integer qty){
	
	ResponseEntity r=new ResponseEntity();
    
	String name=(String)session.getAttribute("name1");
	String email=(String)session.getAttribute("email");
	System.out.println(color+""+""+type+""+qty);
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
	System.out.println("daozhe");
	session.removeAttribute("t");
	TCart t=new TCart();
	String colortype="颜色:"+color+" / "+"内存:"+type;
	t.setColortype(colortype);
	t.setEmail(email);
	t.setId(UUID.randomUUID().toString());
	t.setNum(qty);
	List<Productmenu> plist=productmenuService.selectAllbyname(name);
	t.setPicture(plist.get(0).getPicture());
	t.setProductname(name);
//	List<Productmenu> plist=productmenuService.selectAllbynameAndType(type, name);//根据type和name查询单价
//	t.setPrice(plist.get(0).getPrice());
	TProducttype tp=ps.selectPrice(name, type);
	t.setPrice(tp.getPrice());
	t.setStatus("0");
	System.out.println(name +"    "  +colortype +"   ");
	ts.insertCart(t);
	
	Productmenu pt=new Productmenu();
	pt.setNum(plist.get(0).getNum()-qty);
	pt.setId(plist.get(0).getId());
	pt.setName(name);
	productmenuService.UpdateNum(pt);
	
	r.setStatus(BusiConstant.STATUS_SUCCESS);
	r.setData(t);
	session.setAttribute("t", t);//购物车
	}
		return r;
	}

@RequestMapping(value = "/selectCart",produces = "application/json")
public ResponseEntity selectCart(String callback,HttpSession session,HttpServletRequest request){
	
	ResponseEntity r=new ResponseEntity();
	String email=(String)session.getAttribute("email");
	if(email==null||email=="")
	  {
		r.setStatus(BusiConstant.STATUS_ERROR);
	  }
	else
	 {
	List<TCart> tlist=ts.selectByEmail(email,"0");//加入购物车status为0，结算status为1.
	     if(tlist.size()>0)
	      {
	      r.setStatus(BusiConstant.STATUS_SUCCESS);
	      r.setData(tlist);
	      }
	 }
		return r;
	}

/*
 * 首页插入购物车
*/
@RequestMapping(value = "/insertCart1",produces = "application/json")
public ResponseEntity insertCart1(String callback,HttpSession session,HttpServletRequest request,String id){
	System.out.println("id:"+id);
	      ResponseEntity r=new ResponseEntity();
	      Productmenu pt=productmenuService.selectbyId(id);
	      String email=(String)session.getAttribute("email");
	  	   if(email==null||email=="")
	  	{
	  		r.setStatus(BusiConstant.STATUS_ERROR);
	  	}
	  	 else
	  	 {
	  		TCart t=new TCart();
	  		t.setEmail(email);
	  		t.setId(UUID.randomUUID().toString());
	  		String colortype="颜色:"+pt.getColor()+" / "+"内存:"+pt.getType();
	  		t.setColortype(colortype);
	  		t.setNum(1);
	  		t.setPicture(pt.getPicture());
	  	    t.setProductname(pt.getName());
	  		t.setPrice(pt.getPrice());
	  		ts.insertCart(t);
	  	    r.setStatus(BusiConstant.STATUS_SUCCESS);
	  		r.setData(t);
	  		 
	  	 }
	  
		return r;
	}
/*
 * 结算
*/
@RequestMapping(value = "/paylist")
public JSONPObject paylist(String callback1,HttpSession session,HttpServletRequest request,String [] payList){
	
    session.removeAttribute("tlist");
    session.removeAttribute("e");
	System.out.println(payList.length+"yh");
	TCart tc=new TCart();
	 String email=(String)session.getAttribute("email");
	 List<TUserOrder> tlist=new ArrayList<>();
	 
	 Calendar calendar=Calendar.getInstance();
     long sss=calendar.getTime().getTime();
     String e=Long.toString(sss);
     
     session.setAttribute("e", e);//保存订单号
	 Date date=new Date();
	for(int i=0;i<payList.length;i++)
	{
		TUserOrder torder=new TUserOrder();
		String payList1=payList[i];
		System.out.println(payList1);
		tc=ts.selectByid(payList1);
		torder.setId(UUID.randomUUID().toString());
		torder.setEmail(email);
		torder.setAddress("");
		torder.setNum(tc.getNum());
		torder.setPicture(tc.getPicture());
		torder.setPrice(tc.getPrice());
		torder.setProducttype(tc.getColortype());
		torder.setName(tc.getProductname());
	    torder.setOrderid(e);//订单号：
	    torder.setStatus("0");//订单提交成功时状态变为1
	    torder.setOrdertime(date);
	    BigDecimal a=new BigDecimal(tc.getNum());
	    torder.setCount(tc.getPrice().multiply(a));//总价格
	    tlist.add(torder);
	    orderservice.insertIntoOrder(torder);//插入到数据库
	    System.out.println(tc.getProductname()+"gtgt");
	    
	    TCart t =new TCart();
	    t.setId(payList1);
	    t.setStatus("1");//更新购物车的状态
	    System.out.println("ddd");
	    ts.update(t);
		
	}
	session.setAttribute("tlist", tlist);

	return new JSONPObject(callback1, tlist);
	}

/*
 * 删除购物车
*/
@RequestMapping(value = "/deleteCart",produces = "application/json")
public ResponseEntity deleteCart1(String callback,HttpSession session,HttpServletRequest request,String id){
	      System.out.println("id:"+id);
	      String a="1";
	      ResponseEntity r=new ResponseEntity();
	      
	       ts.deletecart(id);
	      
	  	    r.setStatus(BusiConstant.STATUS_SUCCESS);
	  		r.setData(a);
	  		
		return r;
	}

/*
 * 清空除购物车
*/
@RequestMapping(value = "/deleteAllCart",produces = "application/json")
public ResponseEntity deleteAllCart1(String callback,HttpSession session,HttpServletRequest request){
	     
	      ResponseEntity r=new ResponseEntity();
	      String email=(String)session.getAttribute("email");
	      List<TCart> tlist=ts.selectByEmail(email,"0");
	      if(tlist.size()>0)
	      {
	    	  for(TCart t:tlist)
		      {
		    	  ts.deletecart(t.getId());
		      }
		  	    r.setStatus(BusiConstant.STATUS_SUCCESS);
		  		r.setData(null);
	      }
	      else
	      {
	    	  r.setStatus(BusiConstant.STATUS_ERROR);
	    	  
	      }

		return r;
	}

//更新数量
@RequestMapping(value = "/updateNum",produces = "application/json")
public ResponseEntity updatenum(String callback,HttpSession session,HttpServletRequest request,String id,Integer qty){
	     
	      ResponseEntity r=new ResponseEntity();
            System.out.println(id+""+qty);
	        TCart t =new TCart();
		    t.setId(id);
		    t.setNum(qty);
		    ts.update(t);
		    r.setStatus(BusiConstant.STATUS_SUCCESS);
	  		r.setData(null);
		return r;
	}

}


	
