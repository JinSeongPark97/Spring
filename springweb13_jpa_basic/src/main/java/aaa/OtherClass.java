package aaa;

import org.springframework.stereotype.Component;

@Component
public class OtherClass {
	public OtherClass() {
		System.out.println("OtherClass");
	}
	
	public void abc() {
		System.out.println("OhterClass 클래스 내 method() 실행");
	}
}
