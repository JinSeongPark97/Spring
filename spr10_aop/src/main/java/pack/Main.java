package pack;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("aopinit.xml");
		
		LogicInter inter = (LogicInter)context.getBean("logicImpl");
		inter.selectDataProcess1();
		inter.selectDataProcess2();
		// 위 코드는 핵심 로직만 있는 상태
		
		// 관심사항을 가지는 클래스가 필요 → OurAdvice.java
		
		
	}
}
