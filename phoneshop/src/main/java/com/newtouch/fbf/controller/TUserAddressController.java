package com.newtouch.fbf.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.newtouch.fbf.base.BaseController;
import com.newtouch.fbf.common.BusiConstant;
import com.newtouch.fbf.common.ProductVo;
import com.newtouch.fbf.common.ResponseEntity;
import com.newtouch.fbf.entity.Product;
import com.newtouch.fbf.entity.Productmenu;
import com.newtouch.fbf.entity.TUser;
import com.newtouch.fbf.entity.TUserAddress;
import com.newtouch.fbf.service.AddressService;
import com.newtouch.fbf.service.TUserService;



/**
 * 用户地址列表
 * @author guotong
 *
 */
@RestController
public class TUserAddressController extends BaseController{  

	
	
@Autowired
private AddressService addressservice;
@Autowired
private TUserService tuserservice;
	
//收货地址
@RequestMapping(value = "/address",produces = "application/json")
   public ResponseEntity selectUserList(String callback,HttpSession session,HttpServletRequest request,String city,String province,String district,String address,String phone,String yb,String name){
	if (city==null) {
		city="";
	}
	if (province==null) {
		province="";
	}
	if (district==null) {
		district="";
	}
	String city1=province+city+district;
	String email=(String) session.getAttribute("email");
	ResponseEntity r=new ResponseEntity();
	System.out.println(email+"   "+city1+"     "+address+"    "+yb+"     "+phone+"     " );
    TUserAddress ta=new TUserAddress();
     ta.setId(UUID.randomUUID().toString());
     ta.setAddress(address);
     ta.setCity(city1);
     ta.setEmail(email);
     ta.setYb(yb);
     ta.setPhone(phone);
     ta.setName(name);
     addressservice.insertIntoAddress(ta);
	 r.setStatus(BusiConstant.STATUS_SUCCESS);
	 r.setData(ta);
		return r;
	}

//查询关于用户的收货地址
@RequestMapping(value = "/Alladdress",produces = "application/json")
public ResponseEntity selectAddressList(String callback,HttpSession session,HttpServletRequest request){
	
	ResponseEntity r=new ResponseEntity();
	List<TUserAddress> tlist=new ArrayList<>();
	
	String email=(String)session.getAttribute("email");
	List<TUser> tlist1=tuserservice.selectEmail(email);

	tlist=addressservice.selectAllByEmail(email);

	if(tlist.size()>0)
	{
		for(TUserAddress ta:tlist)
		{
			ta.setAttr1(tlist1.get(0).getPicture());
		}
		 r.setStatus(BusiConstant.STATUS_SUCCESS);
		 r.setData(tlist);
	}
	else
	{
		 r.setStatus(BusiConstant.STATUS_ERROR);
	     r.setData(tlist1.get(0).getPicture());
	}
	return r;
}



@RequestMapping(value = "/deleteaddress",produces = "application/json")
public ResponseEntity deleteAddressList(String callback,HttpSession session,HttpServletRequest request,String id){
	
	ResponseEntity r=new ResponseEntity();
	String a="1";
	System.out.println(id+"hhhh");
	addressservice.deleteaddress(id);
	
	r.setStatus(BusiConstant.STATUS_SUCCESS);
	 r.setData(a);
		return r;
}










}


	
