package com.newtouch.fbf.service.imp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import com.ghw.org.test.MySessionFactory;
import com.newtouch.fbf.entity.Product;
import com.newtouch.fbf.service.ProductService;

@Service
public class ProductServiceImp implements ProductService {

	@Override
	public List<Product> selectproductname() {
		
		List<Product> plist=new ArrayList<>();
		
		try {
			SqlSession sqlSession = MySessionFactory.openSessionFactory();
			plist = sqlSession.selectList("com.newtouch.fbf.dao.ProductMapper.productname");
			sqlSession.commit();
			sqlSession.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return plist;
	}

	@Override
	public Product selectproductidByproductname(String productname) {
		// TODO Auto-generated method stub
		Product pr=new Product();
		
		try {
			SqlSession sqlSession = MySessionFactory.openSessionFactory();
			pr = sqlSession.selectOne("com.newtouch.fbf.dao.ProductMapper.productiid",productname);
			sqlSession.commit();
			sqlSession.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return pr;
	}

	@Override
	public Product selectproductNamebyProuctid(String productid) {
		Product pr=new Product();
      
		try {
			SqlSession sqlSession = MySessionFactory.openSessionFactory();
			pr = sqlSession.selectOne("com.newtouch.fbf.dao.ProductMapper.selectByproductid",productid);
			sqlSession.commit();
			sqlSession.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pr;
	}

	@Override
	public void insertProduct(Product product) {

		SqlSession sqlSession=null;
		try {
			sqlSession = MySessionFactory.openSessionFactory();
			sqlSession.insert("com.newtouch.fbf.dao.ProductMapper.insertProduct",product);
			System.out.println("插入Product成功");
			sqlSession.commit();
			sqlSession.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
