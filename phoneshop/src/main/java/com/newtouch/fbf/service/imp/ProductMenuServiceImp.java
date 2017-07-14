package com.newtouch.fbf.service.imp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import com.ghw.org.test.MySessionFactory;
import com.newtouch.fbf.entity.Productmenu;
import com.newtouch.fbf.service.ProductMenuService;

@Service
public class ProductMenuServiceImp implements ProductMenuService {

	@Override
	public List<Productmenu> selectsales(String sales,String type) {
		
		System.out.println(sales);
		Productmenu p=new Productmenu();
		p.setSales(sales);
		p.setType(type);
		System.out.println("进来了");
		List<Productmenu> plist=new ArrayList<>();
		try {
			SqlSession sqlSession = MySessionFactory.openSessionFactory();
			plist = sqlSession.selectList("com.newtouch.fbf.dao.ProductmenuMapper.sales",p);
			sqlSession.commit();
			sqlSession.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return plist;
	}
//根据品牌名查找所有
	@Override
	public List<Productmenu> selectAllByProductId(String productid,String type) {
		
		Productmenu p=new Productmenu();
		p.setProductid(productid);
		p.setType(type);
		
		List<Productmenu> plist=new ArrayList<>();
		try {
			SqlSession sqlSession = MySessionFactory.openSessionFactory();
			plist = sqlSession.selectList("com.newtouch.fbf.dao.ProductmenuMapper.productid",p);
			sqlSession.commit();
			sqlSession.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return plist;
	}
	@Override
	public Productmenu selectbyId(String id) {
		
		Productmenu p=new Productmenu();
		
		try {
			SqlSession sqlSession = MySessionFactory.openSessionFactory();
			p = sqlSession.selectOne("com.newtouch.fbf.dao.ProductmenuMapper.selectById",id);
			sqlSession.commit();
			sqlSession.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return p;
	}
	
	
	@Override
	public List<Productmenu> selectAllbyname(String name) {
		List<Productmenu> plist=new ArrayList<>();
		
		try {
			SqlSession sqlSession = MySessionFactory.openSessionFactory();
			plist = sqlSession.selectList("com.newtouch.fbf.dao.ProductmenuMapper.byname",name);
			sqlSession.commit();
			sqlSession.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return plist;
	}
	@Override
	public List<Productmenu> selectAllbynameAndType(String type, String name) {
	
		List<Productmenu> plist=new ArrayList<>();
		Productmenu pt=new Productmenu();
		pt.setType(type);
		pt.setName(name);
		
		try {
			SqlSession sqlSession = MySessionFactory.openSessionFactory();
			plist = sqlSession.selectList("com.newtouch.fbf.dao.ProductmenuMapper.byNameAndType",pt);
			sqlSession.commit();
			sqlSession.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return plist;
	}
	@Override
	public void insertProductmenu(Productmenu productmenu) {
		
		try {
			SqlSession sqlSession = MySessionFactory.openSessionFactory();
			sqlSession.insert("com.newtouch.fbf.dao.ProductmenuMapper.insertProductmenu", productmenu);
			System.out.println("插入productmenu成功");
			sqlSession.commit();
			sqlSession.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override
	public List<Productmenu> selectAll(String type) {

		List<Productmenu> plist=new ArrayList<>();
		
		try {
			SqlSession sqlSession = MySessionFactory.openSessionFactory();
			plist = sqlSession.selectList("com.newtouch.fbf.dao.ProductmenuMapper.nono",type);
			sqlSession.commit();
			sqlSession.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return plist;
	}
	@Override
	public void UpdateOrder(Productmenu pt) {

		try {
			SqlSession sqlSession = MySessionFactory.openSessionFactory();
			sqlSession.selectList("com.newtouch.fbf.dao.ProductmenuMapper.update",pt);
			sqlSession.commit();
			sqlSession.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	@Override
	public List<Productmenu> selectLikeName(String name,String type) {
		Productmenu p=new Productmenu();
		p.setName(name);
		p.setType(type);
		
        List<Productmenu> plist=new ArrayList<>();
		
		try {
			SqlSession sqlSession = MySessionFactory.openSessionFactory();
			plist = sqlSession.selectList("com.newtouch.fbf.dao.ProductmenuMapper.name123",p);
			sqlSession.commit();
			sqlSession.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return plist;
	}
	@Override
	public void UpdateNum(Productmenu pt) {
		try {
			SqlSession sqlSession = MySessionFactory.openSessionFactory();
			sqlSession.selectList("com.newtouch.fbf.dao.ProductmenuMapper.updateNum",pt);
			sqlSession.commit();
			sqlSession.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
