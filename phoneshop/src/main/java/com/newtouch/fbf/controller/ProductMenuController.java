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
import com.newtouch.fbf.common.ProductEo;
import com.newtouch.fbf.common.ProductVo;
import com.newtouch.fbf.common.ResponseEntity;
import com.newtouch.fbf.entity.Product;
import com.newtouch.fbf.entity.Productmenu;
import com.newtouch.fbf.entity.TProductcolor;
import com.newtouch.fbf.entity.TProducttype;
import com.newtouch.fbf.service.ProductMenuService;
import com.newtouch.fbf.service.ProductService;
import com.newtouch.fbf.service.ProductcolorService;
import com.newtouch.fbf.service.ProducttypeService;



/**
 * 产品明细列表
 * @author guotong
 *
 */
@RestController
public class ProductMenuController extends BaseController{  

	
	
@Autowired
private ProductMenuService productmenuservice;

@Autowired
private ProductService productservice;
@Autowired
private ProductcolorService pc;
@Autowired
private ProducttypeService pt;


//查询所有的主打商品分页
@SuppressWarnings("unused")
@RequestMapping(value = "/productmenu/zhuda",produces = "application/json")
 public ResponseEntity ZhudaList1(String callback,HttpSession session,HttpServletRequest request,Integer index,Integer size){

	ResponseEntity r=new ResponseEntity();
	List<ProductVo>	list=new ArrayList<>();
	List<Productmenu> plist1=productmenuservice.selectsales("主打商品","1");
	 RowBounds rowBounds = new RowBounds((index-1)*size,size);
	  PageHelper.startPage(index, size);
	List<Productmenu> plist=productmenuservice.selectsales("主打商品","1");
	for(Productmenu pp:plist)
	  {
	  	
	  	ProductVo pv=new ProductVo();
	  	    pv.setId(pp.getId());
			pv.setPicture(pp.getPicture());
			pv.setPrice(pp.getPrice());
			pv.setProductid(pp.getProductid());//该参数传到下一个页面。
			pv.setName(pp.getName());
//			pv.setType(productname1);
			pv.setTotalCount(plist1.size());
			list.add(pv);
		}
	r.setStatus(BusiConstant.STATUS_SUCCESS);
	r.setData(list);
	
		return r;
	}

//促销商品查询分页
@SuppressWarnings("unused")
@RequestMapping(value = "/productmenu/tejia",produces = "application/json")
public ResponseEntity TejiaList1(String callback,HttpSession session,HttpServletRequest request,Integer index,Integer size){
	
	ResponseEntity r=new ResponseEntity();
	List<ProductVo>	list=new ArrayList<>();
	List<Productmenu> plist1=productmenuservice.selectsales("特价商品","1");
	 RowBounds rowBounds = new RowBounds((index-1)*size,size);
	  PageHelper.startPage(index, size);
	List<Productmenu> plist=productmenuservice.selectsales("特价商品","1");
	for(Productmenu pp:plist)
	  {
	  	
	  	ProductVo pv=new ProductVo();
	  	    pv.setId(pp.getId());
			pv.setPicture(pp.getPicture());
			pv.setPrice(pp.getPrice());
			pv.setProductid(pp.getProductid());//该参数传到下一个页面。
			pv.setName(pp.getName());
//			pv.setType(productname1);
			pv.setTotalCount(plist1.size());
			list.add(pv);
		}
	r.setStatus(BusiConstant.STATUS_SUCCESS);
	r.setData(list);
	
		return r;
	}

//商品明细（product.html页面）
@RequestMapping(value = "/productmenu/category",produces = "application/json")
public ResponseEntity categoryList(String callback,HttpSession session,HttpServletRequest request,String name){
	
	ResponseEntity r=new ResponseEntity();
	ProductEo pe=new ProductEo();
	String name1=null;
	
	if(name==null||name=="")
	{
		name1=(String)session.getAttribute("name1");
	}
	else
	{
		name1=name;
	}
		
	session.setAttribute("name1", name1);
	pe.setName(name1);
	List<Productmenu> plist=productmenuservice.selectAllbyname(name1);//价格默认取集合的第一个
	 List<TProducttype> plist1=pt.selectbyname(name1);//价格
	 pe.setNum(plist.get(0).getNum());
	String productid=plist.get(0).getProductid();
	Product product=productservice.selectproductNamebyProuctid(productid);
	pe.setProductname(product.getProductname());
	pe.setMinprice(plist1.get(0).getPrice());//最小值
	pe.setPicture(plist.get(0).getPicture());
	System.out.println(plist1.get(0).getPrice()+"价格");
	int b=plist1.size();
	System.out.println(b+"长度");
	pe.setMaxprice(plist1.get(b-1).getPrice());//最大值
	pe.setQty(1);
	System.out.println(pe.getProductname()+"zly");
	
	session.setAttribute("name1", name1);
	r.setStatus(BusiConstant.STATUS_SUCCESS);
	r.setData(pe);
	return r;
	}

/*
 * 查询内存（product.html页面）
*/
@RequestMapping(value = "/productmenu/category1",produces = "application/json")
public ResponseEntity category1List(String callback,HttpSession session,HttpServletRequest request,String name){
	
	ResponseEntity r=new ResponseEntity();
    String name1=null;

 if(name==null||name=="")
 {
	 name1=(String)session.getAttribute("name1");
 }
 else
 {
	 name1=name;
 }
 List<TProducttype> plist=pt.selectbyname(name1);
	session.setAttribute("name1", name1);
	r.setStatus(BusiConstant.STATUS_SUCCESS);
	r.setData(plist);
	return r;
	}

/*
 * 查询颜色（product.html页面）
*/
@RequestMapping(value = "/productmenu/category2",produces = "application/json")
public ResponseEntity category2List(String callback,HttpSession session,HttpServletRequest request,String name){
	
	ResponseEntity r=new ResponseEntity();
    String name1=null;
System.out.println("颜色"+name);
 if(name==null||name=="")
 {
	 name1=(String)session.getAttribute("name1");
	 System.out.println(name1+"name1");
 }
 else
 {
	 name1=name;
 }
    List<TProductcolor> plist=pc.selectcolor(name1);
	session.setAttribute("name1", name1);
	r.setStatus(BusiConstant.STATUS_SUCCESS);
	r.setData(plist);
	return r;
	}

/*
 * 查询图片
*/
@RequestMapping(value = "/productmenu/category3",produces = "application/json")
public ResponseEntity category3List(String callback,HttpSession session,HttpServletRequest request,String name){
	System.out.println(name+"ffffffffffffff");
	ResponseEntity r=new ResponseEntity();
    String name1=null;

 if(name==null||name=="")
 {
	 name1=(String)session.getAttribute("name1");
 }
 else
 {
	 name1=name;
 }
 List<Productmenu> plist=productmenuservice.selectAllbyname(name1);
	r.setStatus(BusiConstant.STATUS_SUCCESS);
	r.setData(plist);
	return r;
	}
/*
模糊查询
*/
@SuppressWarnings("unused")
@RequestMapping(value = "/productmenu/mohu",produces = "application/json")
public ResponseEntity mohuchaxun(String callback,HttpSession session,HttpServletRequest request,String name,Integer index,Integer size){
	
	ResponseEntity r=new ResponseEntity();
	List<ProductVo>	list=new ArrayList<>();
	String name1="%"+name+"%";
	System.out.println(index+"dddd"+size);
	List<Productmenu> plist1=productmenuservice.selectLikeName(name1,"1");
	  RowBounds rowBounds = new RowBounds((index-1)*size,size);
	  PageHelper.startPage(index, size);
	List<Productmenu> plist123=productmenuservice.selectLikeName(name1,"1");
	if(plist123.size()<1)
	{
		r.setStatus(BusiConstant.STATUS_ERROR);
	}
	else
	{
		 for(Productmenu pp:plist123)
		  {
		  	
		  	ProductVo pv=new ProductVo();
		  	    pv.setId(pp.getId());
				pv.setPicture(pp.getPicture());
				pv.setPrice(pp.getPrice());
				pv.setProductid(pp.getProductid());//该参数传到下一个页面。
				pv.setName(pp.getName());
				pv.setTotalCount(plist1.size());
				list.add(pv);
			}
		
		r.setStatus(BusiConstant.STATUS_SUCCESS);
	}
	r.setData(list);
	return r;

	
	}


}


	
