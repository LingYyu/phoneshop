package com.newtouch.fbf.controller;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.validator.constraints.Email;
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
import com.newtouch.fbf.entity.TUser;
import com.newtouch.fbf.service.TUserService;



/**
 * 用户列表
 * @author guotong
 *
 */
@RestController
public class UserListController extends BaseController{  

	
	
@Autowired
private TUserService tuserservice;
	
//注册
@RequestMapping(value = "/zhuce",produces = "application/json")
   public ResponseEntity selectUserList(String callback,HttpSession session,HttpServletRequest request,String email,String nick,String password,String repassword,String truename,String sex,String birthday) throws ParseException{
//	response.setHeader("Access-Control-Allow-Origin", "*");
	
	Date date=null;
	ResponseEntity r=new ResponseEntity();

	System.out.println(email+"  "+password+"  "+repassword+"  "+truename+ "    "  +sex+"   "+birthday);
	if
	(email==null||password==null||repassword==null||truename==null||sex==null||birthday==null)
	{
		r.setStatus(BusiConstant.STATUS_ERROR);
	}
	else if
	(!password.equals(repassword))
	{
		r.setStatus(BusiConstant.STATUS_ERROR);    //两次密码不一致
		r.setMsg("两次密码不一致");
	}
	else
	{
		List<TUser> tlist=tuserservice.selectEmail(email);
		System.out.println(tlist.size());
		if(tlist.size()<=0&&!email.equals("admain@qq.com")){
			TUser tuser=new TUser();
		    tuser.setId(UUID.randomUUID().toString());
		    tuser.setEmail(email);
		    tuser.setNick(nick);
		    tuser.setPassword(repassword);
		    tuser.setPicture("../images/header.jpg");
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		    date = (Date) dateFormat.parse(birthday);
		    tuser.setBirthday(date);
		    tuser.setSex(sex);
		    tuser.setTruename(truename);
			tuserservice.insertintot_user(tuser);
			r.setStatus(BusiConstant.STATUS_SUCCESS);
			r.setMsg("注册成功!");
			r.setData(tuser);
		}
		else
		{
			r.setStatus(BusiConstant.STATUS_ERROR);
			r.setMsg("该邮箱已被注册!");
		}
		
	}
		return r;
	}


/*@RequestMapping(value = "/login")
public JSONPObject Login(String callback,HttpSession session,HttpServletRequest request,String email,String password){
	
	List<TUser> tlist=tuserservice.selectemailAndpassword(email, password);
	String a="1";
	if(tlist.size()>0)
	{
	a="0";
	}
    else
	a="2";
	return new JSONPObject(callback, a);
	
	}*/

@RequestMapping(value = "/login", produces = "application/json")
public ResponseEntity Login(String callback, HttpSession session, HttpServletRequest request, String email,
		String password) {
	ResponseEntity r=new ResponseEntity();
	System.out.println(email +"  "+password);
	List<TUser> tlist = tuserservice.selectemailAndpassword(email, password);
	if (tlist.size() > 0) {
		System.out.println(tlist);
		session.removeAttribute(email);
		session.setAttribute("email", email);
		r.setStatus(BusiConstant.STATUS_SUCCESS);
		r.setData(tlist);
	} else
		
		r.setStatus(BusiConstant.STATUS_ERROR);
	
	    return r;

    }

@RequestMapping(value = "/selectTuser", produces = "application/json")
public ResponseEntity selectTuser(String callback, HttpSession session, HttpServletRequest request) {
	ResponseEntity r=new ResponseEntity();
	System.out.println("sssssssssssssssssssssssssss");
	String email=(String)session.getAttribute("email");
	List<TUser> tlist = tuserservice.selectEmail(email);
	
		r.setStatus(BusiConstant.STATUS_SUCCESS);
		r.setData(tlist);
	    return r;
    }


@RequestMapping(value = "/updateTuser", produces = "application/json")
public ResponseEntity updateTuser(String callback, HttpSession session, HttpServletRequest request,String picture,String password,String repassword,String nick,String truename,String sex,String birthday) throws ParseException {
	ResponseEntity r=new ResponseEntity();
	
	TUser tuser=new TUser();
	Date date=null;
	String email=(String)session.getAttribute("email");
	System.out.println(email+"  " +nick+"   "+truename+"   "+sex+"    "+birthday+"  "+picture);
	if(password==null||repassword==null||nick==null||truename==null||sex==null||birthday==null)
	{
		r.setStatus(BusiConstant.STATUS_ERROR);//不能为空。
	}
	else if
	(!password.equals(repassword))
	{
		r.setStatus(BusiConstant.STATUS_ERROR);    //两次密码不一致
	}
	else
	{
		tuser.setEmail(email);
		tuser.setPicture(picture);
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    date = (Date) dateFormat.parse(birthday);
	    tuser.setBirthday(date);
	    tuser.setNick(nick);
	    tuser.setPassword(repassword);
	    tuser.setTruename(truename);
	    tuser.setSex(sex);
		tuserservice.updateTuser(tuser);
		r.setStatus(BusiConstant.STATUS_SUCCESS);
		r.setData(tuser);
	}
	return r;
   }
/*
 * 退出
*/
@RequestMapping(value = "/exit", produces = "application/json")
public ResponseEntity exitTuser(String callback, HttpSession session, HttpServletRequest request){
	ResponseEntity r=new ResponseEntity();
	    String a="10";
	    session.removeAttribute("email");
		r.setStatus(BusiConstant.STATUS_SUCCESS);
		r.setData(a);
	    return r;
   }

@RequestMapping(value = "/updateTuser1")
public JSONPObject insertAll(String callback1,HttpSession session,HttpServletRequest request,String email,String password,String repassword,String nick,String birthday,String truename,
		 @RequestParam(value = "P1", required = false) MultipartFile P1,HttpServletResponse response){
	 	
	System.out.println(nick+"   "+birthday+"  "+truename+"  "+password);
		String p1="";

		if(!P1.isEmpty()){
			 p1=UploadUtils.uploadFile(P1, request);
		}
		else
		{
			List<TUser> tlist = tuserservice.selectEmail(email);
			p1=tlist.get(0).getPicture();
		}
		TUser tuser=new TUser();
		Date date=null;
		
		System.out.println(email+"  " +nick+"   "+truename);
			tuser.setEmail(email);
			tuser.setPicture(p1);
			tuser.setPassword(password);
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		    try {
				date = (Date) dateFormat.parse(birthday);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    tuser.setBirthday(date);
		    tuser.setNick(nick);
		    
		    tuser.setTruename(truename);
			tuserservice.updateTuser(tuser);
			String a=tuserservice.updateTuser(tuser);
        return new JSONPObject(callback1, a);
	
}





@RequestMapping(value = "/selectTuser1")
public JSONPObject selectAll(String callback,HttpSession session,HttpServletRequest request,HttpServletResponse response){
	 	
	System.out.println("sssssssssssssssssssssssssss");
	String email=(String)session.getAttribute("email");
	List<TUser> tlist = tuserservice.selectEmail(email);
	return new JSONPObject(callback, tlist);
	
}












}





	
