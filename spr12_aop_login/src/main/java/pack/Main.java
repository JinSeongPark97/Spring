package pack;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("init.xml");
		BusinessLogicInter inter = (BusinessLogicInter)context.getBean("bImpl"); //  Service() 변경된 변수 이름 호출
		inter.startProcess();
	}
	
	
}

// DB연동 4가지 방법
// 1. 클래스 내에서 직접 SQL문 기술
// 2. Spring이 지원하는 JDBC DAO Suport 사용 : 내부적으로 SQL 문 존재
// 3. MyBatis FrameWork 사용.
// 4. JPA 사용

// DI , AOP --> @MVC
