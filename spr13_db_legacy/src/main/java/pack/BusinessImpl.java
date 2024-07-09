package pack;



import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("businessImpl") // 객체변수의 명을 businessImpl로 변경
public class BusinessImpl implements BusinessInter{
	// DB처리하는 모델 클래스를 사용 
	
	@Autowired // 타입에 의한 매핑
	// @Qualifier("SangpumImpl") // 인터페이스를 구현한 파생 클래스가 여러 개인 경우에 사용, 현재 하나이므로 작성 필요 x
	private SangpumInter inter;
	
	
	@Override
	public void selectProcess() {
		ArrayList<SangpumDto> slist = inter.selectAll();
		
		for(SangpumDto s: slist) {
			System.out.println(s.getCode() + " " + 
					s.getSang() + " " +
					s.getSu() + " " +
					s.getDan());
		}
	}
}
