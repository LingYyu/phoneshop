package com.newtouch.fbf.service.imp;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import com.ghw.org.test.MySessionFactory;
import com.newtouch.fbf.entity.TUserOrder;
import com.newtouch.fbf.service.OrderService;

@Service
public class OrderServiceImp implements OrderService {

	@Override
	public void insertIntoOrder(TUserOrder tuserorder) {
		
		SqlSession sqlSession=null;
		
		try {
			sqlSession = MySessionFactory.openSessionFactory();
			sqlSession.insert("com.newtouch.fbf.dao.TUserOrderMapper.insert",tuserorder);
			sqlSession.commit();
			sqlSession.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

	@Override
	public void UpdateOrder(TUserOrder tu) {

		SqlSession sqlSession=null;
		System.out.println("gtgtgtgtgs");
		try {
			sqlSession = MySessionFactory.openSessionFactory();
		    System.out.println("zheerle");
			sqlSession.update("com.newtouch.fbf.dao.TUserOrderMapper.update11",tu);
			System.out.println("jinlaile ");
			sqlSession.commit();
			sqlSession.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<TUserOrder> selectAllByOrderid(String orderid) {
		List<TUserOrder> list=new ArrayList<>();
		try {
			SqlSession sqlSession = MySessionFactory.openSessionFactory();
			list = sqlSession.selectList("com.newtouch.fbf.dao.TUserOrderMapper.byorderid",orderid);
			sqlSession.commit();
			sqlSession.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public List<TUserOrder> selectAllBystatus(String email,String status) {
		TUserOrder to=new TUserOrder();
		to.setEmail(email);
		to.setStatus(status);
		List<TUserOrder> list=new ArrayList<>();
		try {
			SqlSession sqlSession = MySessionFactory.openSessionFactory();
			list = sqlSession.selectList("com.newtouch.fbf.dao.TUserOrderMapper.bystatus",to);
			sqlSession.commit();
			sqlSession.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public List<TUserOrder> selectAllBystatus1(String status) {
		List<TUserOrder> list=new ArrayList<>();
		try {
			SqlSession sqlSession = MySessionFactory.openSessionFactory();
			list = sqlSession.selectList("com.newtouch.fbf.dao.TUserOrderMapper.bystatus1",status);
			sqlSession.commit();
			sqlSession.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<TUserOrder> selectAllOrder() {
		List<TUserOrder> list=new ArrayList<>();
		
		try {
			SqlSession sqlSession = MySessionFactory.openSessionFactory();
			list = sqlSession.selectList("com.newtouch.fbf.dao.TUserOrderMapper.selectAllOrderId");
			sqlSession.commit();
			sqlSession.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public void UpdateOrder1(TUserOrder tu) {
		SqlSession sqlSession=null;
		System.out.println("gtgtgtgtgs");
		try {
			sqlSession = MySessionFactory.openSessionFactory();
		    System.out.println("zheerle");
			sqlSession.update("com.newtouch.fbf.dao.TUserOrderMapper.updateByPrimaryKeySelective",tu);
			System.out.println("jinlaile ");
			sqlSession.commit();
			sqlSession.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<TUserOrder> selectAllByemail(String email) {
		List<TUserOrder> list=new ArrayList<>();
		try {
			SqlSession sqlSession = MySessionFactory.openSessionFactory();
			list = sqlSession.selectList("com.newtouch.fbf.dao.TUserOrderMapper.byemail1",email);
			sqlSession.commit();
			sqlSession.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public  List<TUserOrder> selectAllprice(String orderid) {
		 List<TUserOrder> tlist=new  ArrayList<>();
		try {
			SqlSession sqlSession = MySessionFactory.openSessionFactory();
			tlist = sqlSession.selectList("com.newtouch.fbf.dao.TUserOrderMapper.bycount",orderid);
			sqlSession.commit();
			sqlSession.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return tlist;
	}

	@Override
	public List<TUserOrder> AdmainselectAllorderbyorderid(String orderid, String ordertime) {
		 List<TUserOrder> tlist=new  ArrayList<>();
		 TUserOrder t=new TUserOrder();
		 DateFormat dateFormat = new SimpleDateFormat();
         Date parse = null;;
		try {
			parse = dateFormat.parse(ordertime);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 t.setOrderid(orderid);
		 t.setOrdertime(parse);
		 try {
			SqlSession sqlSession = MySessionFactory.openSessionFactory();
				tlist = sqlSession.selectList("com.newtouch.fbf.dao.TUserOrderMapper.byordertimeAndorderid",t);
				sqlSession.commit();
				sqlSession.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tlist;
	}

	@Override
	public List<TUserOrder> AdmainselectAllorderbyordertime(String ordertime) {
		 List<TUserOrder> tlist=new  ArrayList<>();
		 try {
			SqlSession sqlSession = MySessionFactory.openSessionFactory();
				tlist = sqlSession.selectList("com.newtouch.fbf.dao.TUserOrderMapper.byordertime",ordertime);
				sqlSession.commit();
				sqlSession.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tlist;
	}

}
