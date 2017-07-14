package com.newtouch.fbf.base;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public abstract class BaseEntity implements Serializable {

	private static final long serialVersionUID = -3366166682583204836L;
	
	@Id
	@GeneratedValue(generator = "UUID")
	protected Long id;
	protected Date createTime;
	protected String createUser;
	protected Date updateTime;
	protected String updateUser;
}
