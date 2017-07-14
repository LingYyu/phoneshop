package com.ghw.org.test;
import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MySessionFactory {
	private static SqlSession session;
	//开启
	public static SqlSession openSessionFactory() throws IOException{
		String resource = "context/spring-mybatis.xml";  
        Reader reader = Resources.getResourceAsReader(resource);  
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder()  
                .build(reader);  
        session = sessionFactory.openSession();
        return session;
	}
}
