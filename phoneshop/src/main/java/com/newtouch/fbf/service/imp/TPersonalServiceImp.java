package com.newtouch.fbf.service.imp;

import java.io.IOException;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import com.ghw.org.test.MySessionFactory;
import com.newtouch.fbf.entity.TPersonal;
import com.newtouch.fbf.service.TPersonalService;

@Service
public class TPersonalServiceImp implements TPersonalService {

	@Override
	public TPersonal selectnewsfromt_personal(String email) {
		
		TPersonal tp=new TPersonal();
		try {
			SqlSession sqlSession = MySessionFactory.openSessionFactory();
			tp = sqlSession.selectOne("com.newtouch.fbf.dao.TPersonalMapper.getAllByEmail",email);
			System.out.println("之前");
			sqlSession.commit();
			System.out.println("之后");
			sqlSession.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return tp;
	}

	@Override
	public void Updatet_personalByEmail(TPersonal tpersonal) {
		
		try {
			SqlSession sqlSession = MySessionFactory.openSessionFactory();
			sqlSession.update("com.newtouch.fbf.dao.TPersonalMapper.updateByEmail",tpersonal);
			System.out.println("之前");
			sqlSession.commit();
			System.out.println("之后");
			sqlSession.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
