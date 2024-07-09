package anno2_resource;

import org.springframework.stereotype.Component;

@Component("aaa") // 객체 변수 이름을 "aaa"로 설정
public class Abc2 { // POJO : 멤버 필드와 메소드만 존재하고, 상속 등이 포함되어 있지 않은 클래스
	private int age;
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public int getAge() { 
		return age;
	}
}
