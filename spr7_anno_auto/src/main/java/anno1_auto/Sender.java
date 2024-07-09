package anno1_auto;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component // Singleton pattern으로 Sender 객체가 생성. 객체 변수명은 sender가 된다.
//@Component("sender")
//@Component("sen") // 기본이름을 사용하지 않을 시 적어줘야함.
//@Scope("singleton") // 기본적으로 singleton 이라 안적어도 괜찮다.
public class Sender implements SenderInter {
	public void show() {
		System.out.println("Sender의 show 메소드 수행");
	}
}
