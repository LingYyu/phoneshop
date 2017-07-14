package com.newtouch.fbf.controller;

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
import com.newtouch.fbf.common.ProductVo;
import com.newtouch.fbf.common.ResponseEntity;
import com.newtouch.fbf.entity.Product;
import com.newtouch.fbf.entity.Productmenu;
import com.newtouch.fbf.service.ProductMenuService;
import com.newtouch.fbf.service.ProductService;



/**
 * 产品列表
 * @author guotong
 *
 */
@RestController
public class ProductController extends BaseController{  

	
	
@Autowired
private ProductService productservice;

@Autowired
private ProductMenuService productmenuservice;
	
//查询全部商品名
@RequestMapping(value = "/product",produces = "application/json")
   public ResponseEntity selectUserList(String callback,HttpSession session,HttpServletRequest request){
	
	ResponseEntity r=new ResponseEntity();
	List<Product> plist=productservice.selectproductname();
	r.setStatus(BusiConstant.STATUS_SUCCESS);
	r.setData(plist);
	
		return r;
	}
/*
            RowBounds rowBounds = new RowBounds((pageno-1)*3,3);
			PageHelper.startPage(pageno, 5);
*/
//根据某一商品名查询所有(例如 “三星” 查询 “三星”的所有产品)
@SuppressWarnings("unused")
@RequestMapping(value = "/product/product1",produces = "application/json")
public ResponseEntity selectUserList1(String productname,String callback,HttpSession session,HttpServletRequest request,Integer index,Integer size){
	
	ResponseEntity r=new ResponseEntity();
    List<ProductVo>	list=new ArrayList<>();
	System.out.println(productname+"gt");
	System.out.println(index+"fff"+size);
	String productname1=null;
	if(productname==null||productname=="")
	{
		productname1=(String)session.getAttribute("productname1");
		System.out.println(productname1+"yh");
		System.out.println("123");
	}
	else
	{
		System.out.println("234");
		productname1=productname;
	}
	
  Product p=productservice.selectproductidByproductname(productname1);
  List<Productmenu> plist1=productmenuservice.selectAllByProductId(p.getProductid(),"1");
  RowBounds rowBounds = new RowBounds((index-1)*size,size);
  PageHelper.startPage(index, size);
  List<Productmenu> plist=productmenuservice.selectAllByProductId(p.getProductid(),"1");
  for(Productmenu pp:plist)
  {
  	
  	ProductVo pv=new ProductVo();
  	    pv.setId(pp.getId());
		pv.setPicture(pp.getPicture());
		pv.setPrice(pp.getPrice());
		pv.setProductid(pp.getProductid());//该参数传到下一个页面。
		pv.setName(pp.getName());
		pv.setType(productname1);
		pv.setTotalCount(plist1.size());
		list.add(pv);
	}
 //session.removeAttribute("productname1");
 session.setAttribute("productname1", productname1);
	r.setStatus(BusiConstant.STATUS_SUCCESS);
	r.setData(list);
	
		return r;
	}


//查询类似
@SuppressWarnings("unused")
@RequestMapping(value = "/product/product2",produces = "application/json")
public ResponseEntity selectUserList2(String productid,String callback,HttpSession session,HttpServletRequest request,Integer index,Integer size){
	
	ResponseEntity r=new ResponseEntity();
    List<ProductVo>	list=new ArrayList<>();
	System.out.println(productid+"gt");
	String productid1=null;
	if(productid==null||productid=="")
	{
		productid1=(String)session.getAttribute("productid1");
		System.out.println(productid1+"yh");
		System.out.println("123");
	}
	else
	{
		System.out.println("234");
		productid1=productid;
	}
	List<Productmenu> plist1=productmenuservice.selectAllByProductId(productid1,"1");
	  RowBounds rowBounds = new RowBounds((index-1)*size,size);
	  PageHelper.startPage(index, size);
List<Productmenu> plist=productmenuservice.selectAllByProductId(productid1,"1");
for(Productmenu pp:plist)
{
	
	ProductVo pv=new ProductVo();
	pv.setId(pp.getId());
		pv.setPicture(pp.getPicture());
		pv.setPrice(pp.getPrice());
		pv.setProductid(productid1);//该参数传到下一个页面。
		pv.setName(pp.getName());
		pv.setTotalCount(plist1.size());
		list.add(pv);
	}
//session.removeAttribute("productname1");
session.setAttribute("productid1", productid1);
	r.setStatus(BusiConstant.STATUS_SUCCESS);
	r.setData(list);
	
		return r;
	}


}


	
