package com.newtouch.fbf.spring;

import java.util.Date;

import org.springframework.core.convert.converter.Converter;

import com.newtouch.fbf.support.StringToDateSupport;

public final class String2DateConverter implements Converter<String, Date> {
	
	@Override
	public Date convert(String source) {
		
		return StringToDateSupport.stringToDate(source);
	}

}
