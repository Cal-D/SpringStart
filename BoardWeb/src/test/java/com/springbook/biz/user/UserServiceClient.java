package com.springbook.biz.user;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class UserServiceClient {
 public static void main(String[] args) {
	AbstractApplicationContext container =
			new GenericXmlApplicationContext("applicationContext.xml");
	
	UserService userService = (UserService)container.getBean("userService");
	
	UserVO vo = new UserVO();
	vo.setId("spiderM");
	vo.setPassword("spi123");
	
	UserVO user = userService.getUser(vo);
	if(user != null) {
		System.out.println(user.getName()+ "is Coming");
	}
	else {
		System.out.println("로그인 실패");
	}
	container.close();
}
}
