package com.newtouch.fbf.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.newtouch.fbf.base.BaseController;
import com.newtouch.fbf.common.BusiConstant;
import com.newtouch.fbf.common.ResponseEntity;
import com.newtouch.fbf.entity.TPersonal;
import com.newtouch.fbf.service.TPersonalService;

/**
 * 用户列表
 * @author guotong
 *
 */
@RestController
public class PersonalController extends BaseController{  

@Autowired
private TPersonalService tpersonal;
	
	
//查看个人信息
@RequestMapping(value = "/selectAllByEmail",produces = "application/json")
   public ResponseEntity selectAllByEmail(String callback,HttpSession session,HttpServletRequest request){
	
	ResponseEntity r=new ResponseEntity();
	TPersonal tp=new TPersonal();
	String email=(String)session.getAttribute("email");
	tp=tpersonal.selectnewsfromt_personal(email);
	r.setStatus(BusiConstant.STATUS_SUCCESS);
	r.setData(tp);
		return r;
	}


//更新个人信息
@RequestMapping(value = "/updateAllByEmail",produces = "application/json")
public ResponseEntity updateAllByEmail(String callback,HttpSession session,HttpServletRequest request,String picture,String password,String repassword,String nick,String truename,String sex,String birthday) throws ParseException{
	
	ResponseEntity r=new ResponseEntity();
	System.out.println(password +"    "+sex  +"   "+ picture+"   ");
	Date date=null;
	TPersonal tp=new TPersonal();
	String email=(String)session.getAttribute("email");
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
		tp.setEmail(email);
		tp.setPicture(picture);
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    date = (Date) dateFormat.parse(birthday);
		tp.setBrithday(date);
		
		tp.setNick(nick);
		tp.setPassword(repassword);
		tp.setTruename(truename);
		tp.setSex(sex);
		tpersonal.selectnewsfromt_personal(email);
		r.setStatus(BusiConstant.STATUS_SUCCESS);
		r.setData(tp);
		
	}
		return r;
	}


}


	
