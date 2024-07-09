package pack.customer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CustomerMain {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("bankinit.xml");
		
		Customer Hani = (Customer)context.getBean("customer");
		Hani.selectBank("sinhan");	// 은행 선택
		Hani.playInputMoney(500);	// 입금
		Hani.playOutputMoney(1000);	// 출금
		System.out.print("Hani 고객님의 ");
		Hani.showMoney();	// 잔고 체크
	
		Customer Minji = (Customer)context.getBean("customer");
		Minji.selectBank("sinhan");	// 은행 선택
		Minji.playInputMoney(500);	// 입금
		Minji.playOutputMoney(1000);	// 출금
		System.out.print("Minji 고객님의 ");
		Minji.showMoney();	// 잔고 체크
		
		Customer Hyerin = (Customer)context.getBean("customer");
		Hyerin.selectBank("hana");	// 은행 선택
		Hyerin.playInputMoney(500);	// 입금
		Hyerin.playOutputMoney(1000);	// 출금
		System.out.print("Hyerin 고객님의 ");
		Hyerin.showMoney();	// 잔고 체크
		
		// 객체의 주소가 동일함(@Scope:prototype) 처리해줘야함
		System.out.println("객체 주소 Hani : " + Hani);
		System.out.println("객체 주소 Minji : " + Minji);
		System.out.println("객체 주소 Hyerin : " + Hyerin);

		
	}
}
