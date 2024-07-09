package anno1_auto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
// 참고 : 계층(Layers)별 어노테이션 구분
// Application layer : 클라이언트와 데이터 입출력을 제어하는 용도 ex) @Controller ...
// Domain layer : 어플리케이션 중심이며, 업무처리를 담당 ex) @Service ...
// Infrastuctor layer : DB에 대한 영속성(persistence) 등을 담당 ex)  @Repository ...

//@Component
@Service 
// 객체변수 이름은 senderProcess
//@Service("sendProcess") 
//@Scope("singleton") // 위와 동일하다
public class SenderProcess {
	// @Autowired : Bean의 자동 삽입을 위해 사용하는 어노테이션. (name에 의한 매핑이 아니라 type으로 매핑)
	
	//@Autowired // field injection : 간단하나 테스트 불편. 주로 사용
	//private Sender sender; 
	// Sender 클래스에 @Component를 사용하여 Sender 타입의 객체가 만들어져 있어야 함..?
	
	@Autowired // 해당 어노테이션은 이름으로 찾는게 아니라 타입으로 찾으므로 에러가 발생.
	@Qualifier("sender2") // Autowired의 보조 어노테이션, 혼자서는 사용이 불가능하다.
	private SenderInter senderInter; // Sender 인스턴스의 주소를 넘겨주는데 Sender 클래스의 주소를 이곳에 와이어링함.
	
	
	/*
	@Autowired // setter injection : 코드가 장황하다
	public void setSender(Sender sender) {
		this.sender = sender;
	}
	
	@Autowired // constructor injection : 불변성과 테스트가 편하지만 생성자가 너무 많아짐
	public SenderProcess(Sender sender) {
		this.sender = sender;
	}
	*/
	
	public void displayData() {
		senderInter.show();
	}
	
	
}