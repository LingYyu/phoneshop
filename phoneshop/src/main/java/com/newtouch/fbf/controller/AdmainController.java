package com.newtouch.fbf.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.ghw.org.test.UploadUtils;
import com.newtouch.fbf.base.BaseController;
import com.newtouch.fbf.common.BusiConstant;
import com.newtouch.fbf.common.ResponseEntity;
import com.newtouch.fbf.entity.Product;
import com.newtouch.fbf.entity.Productmenu;
import com.newtouch.fbf.entity.TProductcolor;
import com.newtouch.fbf.entity.TProducttype;
import com.newtouch.fbf.entity.TUserOrder;
import com.newtouch.fbf.service.OrderService;
import com.newtouch.fbf.service.ProductMenuService;
import com.newtouch.fbf.service.ProductService;
import com.newtouch.fbf.service.ProductcolorService;
import com.newtouch.fbf.service.ProducttypeService;


/**
 * 后台管理员
 * @author guotong
 *
 */
@RestController
public class AdmainController extends BaseController{  
	
@Autowired	
private OrderService orderservice;	
@Autowired
private ProductService productservice;
@Autowired
private ProductMenuService productmenuservice;
@Autowired
private ProductcolorService productcolorservice;
@Autowired
private ProducttypeService producttypeservice;
//管理员登陆
@RequestMapping(value = "/adminlogin")
public JSONPObject adminlogin(String callback,HttpSession session,HttpServletRequest request,String email,String password){
	
	String a="222";
	System.out.println(email+""+password);
	if(!email.equals("admain@qq.com")||!password.equals("zlyzly"))
	{
		a="111";
	}
	return new JSONPObject(callback, a);
	}

/*
 *添加商品
*/

@RequestMapping(value = "/insertAll")

   public JSONPObject insertAll(String callback1,HttpSession session,HttpServletRequest request,String name,String productname,String qty,
		  String price,String sales, String [] color,String [] type,@RequestParam(value = "P1", required = false) MultipartFile P1,HttpServletResponse response){
	 	
	String a="1";
	System.out.println(productname+""+price+""+sales+""+name);
	try {
		String p1="";
		//String [] color=request.getParameterValues("color");
		//String [] type=request.getParameterValues("type");
		if(!P1.isEmpty()){
			 p1=UploadUtils.uploadFile(P1, request);
			 p1=UploadUtils.uploadFile1(P1, request);
			System.out.println(p1+"gtgtgtg");
		}
//		Product product=new Product();
		
		/*product.setId(UUID.randomUUID().toString());
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
		String productid=sdf.format(new Date());
		product.setProductid(productid);
		product.setProductname(name);
		productservice.insertProduct(product);*/
		Product product=productservice.selectproductidByproductname(name);
		String productid=product.getProductid();
		
		
		Productmenu productmenu=new Productmenu();
		productmenu.setId(UUID.randomUUID().toString());
		productmenu.setName(productname);
		
		int qty1=Integer.parseInt(qty);
		productmenu.setNum(qty1);
		productmenu.setPicture(p1);
		BigDecimal price1=new BigDecimal(price);
		productmenu.setPrice(price1);
		productmenu.setProductid(productid);
		productmenu.setSales(sales);
		productmenu.setType("0");//销售中 点击上架 type=1;
		productmenuservice.insertProductmenu(productmenu);
		
		TProductcolor tproductcolor=new TProductcolor();
		for(int i=0;i<color.length;i++)
		{
			System.out.println("颜色"+color[i]);
			String color1=color[i];
			tproductcolor.setColor(color1);
			tproductcolor.setId(UUID.randomUUID().toString());
			tproductcolor.setName(productname);
			productcolorservice.insertProductcolor(tproductcolor);
		}
		
		TProducttype tproducttype=new TProducttype();
		for(int i=0;i<type.length;i++)
		{
			BigDecimal price2=new BigDecimal(300*i);
			BigDecimal price3=price1.add(price2);
			String type1=type[i];
			tproducttype.setId(UUID.randomUUID().toString());
			tproducttype.setName(productname);
			tproducttype.setType(type1);
			tproducttype.setPrice(price3);
			producttypeservice.insertProducttype(tproducttype);
			
		}
	} catch (Exception e) {
		a="3";//出现异常（失败）
		System.out.println("出现异常");
		e.printStackTrace();
	}

  return new JSONPObject(callback1, a);
	
}
/*
 * 查询所有正在热销的商品
 * type=1
*/
@RequestMapping(value = "/admain/selectorder",produces = "application/json")
public ResponseEntity selectorder(String callback,HttpSession session,HttpServletRequest request){
	ResponseEntity r=new ResponseEntity();
	
	List<Productmenu> plist=productmenuservice.selectAll("1");
	
	 r.setStatus(BusiConstant.STATUS_SUCCESS);
	 r.setData(plist);	
	return r;
	
}
/*
 * 查询新添加的商品
 * type=1
*/
@RequestMapping(value = "/admain/selectadd",produces = "application/json")
public ResponseEntity selectadd(String callback,HttpSession session,HttpServletRequest request){
	ResponseEntity r=new ResponseEntity();
	
	List<Productmenu> plist=productmenuservice.selectAll("0");
	
	 r.setStatus(BusiConstant.STATUS_SUCCESS);
	 r.setData(plist);	
	return r;
	
}
/*
 * 点击下架
 * type=0
*/
@RequestMapping(value = "/admain/downorder",produces = "application/json")
public ResponseEntity selectorder1(String callback,HttpSession session,HttpServletRequest request,String id){
	ResponseEntity r=new ResponseEntity();
	Productmenu p=new Productmenu();
	
	   p.setId(id);
	   p.setType("0");//下架状态变为0
	
	productmenuservice.UpdateOrder(p);
	 r.setStatus(BusiConstant.STATUS_SUCCESS);
	 r.setData(p);	
	return r;
	
}
/*
 * 点击上架
 * type=1
*/
@RequestMapping(value = "/admain/uporder",produces = "application/json")
public ResponseEntity selectuporder(String callback,HttpSession session,HttpServletRequest request,String id){
	ResponseEntity r=new ResponseEntity();
	Productmenu p=new Productmenu();
	
	   p.setId(id);
	   p.setType("1");//上架状态变为1
	
	productmenuservice.UpdateOrder(p);
	 r.setStatus(BusiConstant.STATUS_SUCCESS);
	 r.setData(p);	
	return r;
	
}

}


	
