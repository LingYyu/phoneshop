package com.ghw.org.test;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Test {
	
	public static void main(String[] args) {
		System.err.println(new Date());
		
		
		try {
			ServerSocketChannel ch = ServerSocketChannel.open();
			ch.socket().bind(new InetSocketAddress(InetAddress.getLocalHost(), 9999));
			ch.configureBlocking(false);
			
			Selector sl = Selector.open();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		SpringApplication.run(Test.class, args);
	}

}
