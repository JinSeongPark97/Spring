package anno1_auto;

import org.springframework.stereotype.Component;

@Component // 객체변수의 이름은 중요하지않고 타입이 중요
public class Sender2 implements SenderInter{
	@Override
	public void show() {
		System.out.println("Sender2 클래스의 show 메소드 처리");
		
	}
}
