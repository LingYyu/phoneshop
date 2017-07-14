package com.newtouch.fbf.service.imp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import com.ghw.org.test.MySessionFactory;
import com.newtouch.fbf.entity.TUserAddress;
import com.newtouch.fbf.service.AddressService;

@Service
public class AddressServiceImp implements AddressService {

	@Override
	public void insertIntoAddress(TUserAddress TUseraddress) {
		
		SqlSession sqlSession=null;
		
		try {
			sqlSession = MySessionFactory.openSessionFactory();
			sqlSession.insert("com.newtouch.fbf.dao.TUserAddressMapper.insert",TUseraddress);
			System.out.println("gt");
			sqlSession.commit();
			sqlSession.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public List<TUserAddress> selectAllByEmail(String email) {
		
		List<TUserAddress> tlist=new ArrayList<>();
		
		try {
			SqlSession sqlSession = MySessionFactory.openSessionFactory();
			tlist = sqlSession.selectList("com.newtouch.fbf.dao.TUserAddressMapper.byEmail",email);
			sqlSession.commit();
			sqlSession.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tlist;
	}

	@Override
	public void deleteaddress(String id) {
		
                SqlSession sqlSession=null;
		
		try {
			sqlSession = MySessionFactory.openSessionFactory();
			sqlSession.delete("com.newtouch.fbf.dao.TUserAddressMapper.delete",id);
//			System.out.println("gt");
			sqlSession.commit();
			sqlSession.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
	}

}
