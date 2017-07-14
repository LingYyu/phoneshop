package com.newtouch.fbf.service.imp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import com.ghw.org.test.MySessionFactory;
import com.newtouch.fbf.entity.TProductcolor;
import com.newtouch.fbf.service.ProductcolorService;

@Service
public class ProductcolorServiceImp implements ProductcolorService {

	@Override
	public void insertProductcolor(TProductcolor productcolor) {


		try {
			SqlSession sqlSession = MySessionFactory.openSessionFactory();
			sqlSession.insert("com.newtouch.fbf.dao.TProductcolorMapper.insertProductcolor", productcolor);
			System.out.println("插入TProductcolor成功");
			sqlSession.commit();
			sqlSession.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public List<TProductcolor> selectcolor(String name) {

		List<TProductcolor> plist=new ArrayList<>();
		
		try {
			SqlSession sqlSession = MySessionFactory.openSessionFactory();
			plist = sqlSession.selectList("com.newtouch.fbf.dao.TProductcolorMapper.selectbyname",name);
			sqlSession.commit();
			sqlSession.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return plist;
	}

}
