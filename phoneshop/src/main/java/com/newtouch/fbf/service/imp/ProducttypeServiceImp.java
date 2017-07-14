package com.newtouch.fbf.service.imp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import com.ghw.org.test.MySessionFactory;
import com.newtouch.fbf.entity.TProducttype;
import com.newtouch.fbf.service.ProducttypeService;

@Service
public class ProducttypeServiceImp implements ProducttypeService {

	@Override
	public void insertProducttype(TProducttype producttype) {


		try {
			SqlSession sqlSession = MySessionFactory.openSessionFactory();
			sqlSession.insert("com.newtouch.fbf.dao.TProducttypeMapper.insertproducttype", producttype);
			System.out.println("插入producttype成功");
			sqlSession.commit();
			sqlSession.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public List<TProducttype> selectbyname(String name) {

		 List<TProducttype> plist=new  ArrayList<>();
		try {
			SqlSession sqlSession = MySessionFactory.openSessionFactory();
			plist = sqlSession.selectList("com.newtouch.fbf.dao.TProducttypeMapper.selectbyname",name);
			sqlSession.commit();
			sqlSession.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return plist;
	}

	@Override
	public TProducttype selectPrice(String name, String type) {
		
		TProducttype tp=new TProducttype();
		tp.setName(name);
		tp.setType(type);
		
		try {
			SqlSession sqlSession = MySessionFactory.openSessionFactory();
			tp=sqlSession.selectOne("com.newtouch.fbf.dao.TProducttypeMapper.selectbynameandtype",tp);
			sqlSession.commit();
			sqlSession.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return tp;
	}

}
