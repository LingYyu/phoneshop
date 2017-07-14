package com.newtouch.fbf.service.imp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import com.ghw.org.test.MySessionFactory;
import com.newtouch.fbf.entity.TUser;
import com.newtouch.fbf.service.TUserService;

@Service
public class TUserServiceImp implements TUserService {

	@Override
	public void insertintot_user(TUser tuser) {
		
		SqlSession sqlSession=null;
		try {
			sqlSession = MySessionFactory.openSessionFactory();
			sqlSession.insert("com.newtouch.fbf.dao.TUserMapper.zhuce",tuser);
			System.out.println("gt");
			sqlSession.commit();
			sqlSession.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public List<TUser> selectemailAndpassword(String email, String password) {
		
		System.out.println("进入了");
		List<TUser> tlist=new ArrayList<>();
		TUser tuser=new TUser();
		tuser.setEmail(email);
		tuser.setPassword(password);
		
		
		try {
			SqlSession sqlSession = MySessionFactory.openSessionFactory();
			tlist = sqlSession.selectList("com.newtouch.fbf.dao.TUserMapper.login",tuser);
			System.out.println("之前");
			sqlSession.commit();
			System.out.println("之后");
			
			sqlSession.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return tlist;
	}

	@Override
	public List<TUser> selectEmail(String email) {
		
		List<TUser> tlist=new ArrayList<>();
		
		try {
			SqlSession sqlSession = MySessionFactory.openSessionFactory();
			tlist = sqlSession.selectList("com.newtouch.fbf.dao.TUserMapper.login1",email);
			sqlSession.commit();
			sqlSession.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return tlist;
	}
	@Override
	public String updateTuser(TUser tuser) {
		
		try {
			SqlSession sqlSession = MySessionFactory.openSessionFactory();
			sqlSession.update("com.newtouch.fbf.dao.TUserMapper.updateByEmail",tuser);
			System.out.println("之前");
			sqlSession.commit();
			System.out.println("之后");
			sqlSession.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return "1";
	}


}
