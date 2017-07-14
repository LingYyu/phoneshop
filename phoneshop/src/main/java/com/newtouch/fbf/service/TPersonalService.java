package com.newtouch.fbf.service;

import com.newtouch.fbf.entity.TPersonal;

public interface TPersonalService {
	
	 TPersonal  selectnewsfromt_personal(String email);//根据email查询个人信息
	  public void Updatet_personalByEmail(TPersonal tpersonal);//跟新个人信息。

}
