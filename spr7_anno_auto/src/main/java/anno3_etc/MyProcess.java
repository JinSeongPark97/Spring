package anno3_etc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("my") // 객체변수 이름 my로 설정
public class MyProcess {
	// @Value : 변수에 값을 초기화하기 위해 사용할 수도 있다.
	// Spring EL : #{표현식}, 만들어진 Component 객체를 이용, private는 getter를 
	// spEL 표현식은 # 기호로 시작되며 중괄호로 묶어서 표현한다. #{표현식}
	// 속성 값을 참조할 때는 $ 기호와 중괄호로 묶어서 표현한다. ${property.name}
	
	@Value("#{dataInfo.name}") // dataInfo 인스턴스에 name 값 주입 ← DataInfo 클래스의 멤버 필드에 선언된 값 할당
	private String name;
	private String part;
	
	@Autowired
	//public MyProcess(@Value("영업부") String part) {
	public MyProcess(@Value("#{dataInfo.part}") String part) {	
	this.part = part;
	}
	
	@Value("123") // 값을 줄때에는 기본이 String type 이다.
	private int age;
	
	@Value("1,2,3,4") // 배열의 초기치로 값이 전달된다.
	private int arr[];
	
	public void showData() { 
		System.out.println("name : " + name);
		System.out.println("part : " + part);
		System.out.println("age : " + age);
		System.out.println(arr[0] + " " + arr[3]);
		
	}
}
