package com.newtouch.fbf.service.imp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import com.ghw.org.test.MySessionFactory;
import com.newtouch.fbf.entity.TCart;
import com.newtouch.fbf.service.TCartService;
@Service
public class TCartServiceImp implements TCartService {

	@Override
	public void insertCart(TCart tcart) {
				
		SqlSession sqlSession=null;
		try {
			sqlSession = MySessionFactory.openSessionFactory();
			sqlSession.insert("com.newtouch.fbf.dao.TCartMapper.insertcart",tcart);
			System.out.println("gt");
			sqlSession.commit();
			sqlSession.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
	
	
	
	@Override
	public List<TCart> selectByEmail(String email,String status) {
		
		TCart t=new TCart();
		t.setEmail(email);
		t.setStatus(status);
		
		List<TCart> tlist=new ArrayList<>();
		
		try {
			SqlSession sqlSession = MySessionFactory.openSessionFactory();
			tlist = sqlSession.selectList("com.newtouch.fbf.dao.TCartMapper.selectByemail1",t);
			sqlSession.commit();
			sqlSession.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return tlist;
	}



	@Override
	public TCart selectByid(String id) {
		TCart t=new TCart();
		
		try {
			SqlSession sqlSession = MySessionFactory.openSessionFactory();
			t = sqlSession.selectOne("com.newtouch.fbf.dao.TCartMapper.selectById",id);
			sqlSession.commit();
			sqlSession.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return t;
	}



	@Override
	public void update(TCart t) {
		
		try {
			SqlSession sqlSession = MySessionFactory.openSessionFactory();
			sqlSession.selectOne("com.newtouch.fbf.dao.TCartMapper.update",t);
			sqlSession.commit();
			sqlSession.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	@Override
	public void deletecart(String id) {
		SqlSession sqlSession=null;
		try {
			sqlSession = MySessionFactory.openSessionFactory();
			sqlSession.delete("com.newtouch.fbf.dao.TCartMapper.deletecart",id);
			System.out.println("gt");
			sqlSession.commit();
			sqlSession.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}





}


