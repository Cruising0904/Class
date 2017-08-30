package test.sp.iot.anno3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Execute {

	public static void main(String[] args) {
		ApplicationContext factory;
		String path = "classpath:/anno3/ioc.xml";
		factory = new ClassPathXmlApplicationContext(path);
		User u = (User)factory.getBean("user");
		UserService us = (UserService)factory.getBean("userService");
		u.setId("test");
		u.setName("길동이");
		u.setPwd("1111");
		
		String result = us.login(u);
		System.out.println(result);
	}
}
