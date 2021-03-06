package com.newtouch.fbf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

//@SpringBootApplication
//@ImportResource(locations={"classpath:context/application.xml"})
//@Configuration
//@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
//public class Application extends SpringBootServletInitializer{
//	
//	@Override 
//	  protected SpringApplicationBuilder configure( 
//	  SpringApplicationBuilder application) { 
//	  return application.sources(Application.class); 
//	  } 
//
//	  public static void main(String[] args) { 
//	  SpringApplication.run(Application.class, args); 
//	  } 
//	} 
@SpringBootApplication
public class Application{
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}


