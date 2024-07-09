package pack.customer;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import pack.bank.Bank;
import pack.bank.HanaBank;
import pack.bank.SinhanBank;

@Service
@ComponentScan("pack.bank") // 고객이 bank 클래스를 scan
@Scope("prototype")
public class Customer {
	private Bank bank;
	
	// required : false : SinhanBank 인스턴스가 있으면 사용, 없으면 매핑 x, true: 신한뱅크 인스턴스가 없으면 에러 발생
	@Autowired(required = true) // type 으로 연결
	private SinhanBank sinhanBank;
	
	@Resource(name="hanaBank") // name 으로 연결
	private HanaBank hanaBank;
	
	// 은행 선택하기 위한 메소드
	public void selectBank(String sel) {
		if(sel.equals("sinhan")) {
			bank = sinhanBank;
		}else if(sel.equals("hana")) {
			bank = hanaBank;
		}
	}
	
	// 입금하는 메소드
	public void playInputMoney(int money) { 
		bank.inputMoney(money); // 객체 변수 bank는 고객이 선택한 은행에 따라 변경됨
	}
	
	// 출금하는 메소드
	public void playOutputMoney(int money) { 
		bank.outputMoney(money); // 
	}
	
	private String msg;
	
 	@PostConstruct // 생성자 처리 후 자동 호출 : 초기화 작업 가능
	public void test() {
		msg = "계좌 잔고 : ";
	}
 	
 	@PreDestroy // 웹 서비스 종료 직전 자동 호출 : 마무리 작업 가능
	public void test2() {
 		if(sinhanBank != null) sinhanBank = null;
 		if(hanaBank != null) hanaBank = null;		
 	}
 	
 	// 고객의 잔고 확인 메소드
 	public void showMoney() {
		System.out.println(msg + bank.getMoney());
	}
	
}

