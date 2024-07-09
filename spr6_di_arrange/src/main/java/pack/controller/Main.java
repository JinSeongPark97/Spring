package pack.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		/*
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:arrange.xml"); // resources에 넣어두면 생략가능.
		*/
		
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("classpath:arrange.xml");
		
		System.out.println("---Singleton 확인하세요---");
		MessageImpl impl1 = (MessageImpl)context.getBean("mImpl");
		impl1.sayHi();
		System.out.println();
		MessageImpl impl2 = (MessageImpl)context.getBean("mImpl");
		impl2.sayHi();
		
		System.out.println("impl1 주소 : " + impl1 + "\n" + "impl2 주소 : " + impl2); // 주소가 같으면 싱글톤, 주소가 다르면 별도의 객체 생성 , 스프링은 싱글톤으로 만들어줌.
		
		System.out.println("\n---다형성 처리 하세요---");
		MessageInter inter = (MessageInter)context.getBean("mImpl");
		inter.sayHi();
		
		System.out.println("\n---다형성 처리 하세요2---");
		MessageInter inter2 = (MessageInter)context.getBean("mImpl", MessageInter.class);
		inter.sayHi();
	
		context.close();
		
	}

}