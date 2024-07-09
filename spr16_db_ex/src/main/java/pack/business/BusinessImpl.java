package pack.business;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pack.model.JikwonDto;
import pack.model.JikwonInter;

@Service
public class BusinessImpl implements BusinessInter {
	// model을 포함관계로 호출.
	@Autowired // Type 에 의한 매핑
	private JikwonInter jikwonInter;
	
	@Override
	public void jikwonList() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("고객 번호 입력:");
		String gogekNum = scanner.nextLine();
		System.out.println("고객 이름 입력:");
		String name = scanner.nextLine();
		scanner.close();
		
		List<JikwonDto> list = jikwonInter.selectList(gogekNum,name);
		if(list.isEmpty()) {
			System.out.println("로그인에 실패하였습니다.");
			System.exit(0);
		}
		
		for(JikwonDto j:list) {
			System.out.println(j.getJikwon_name() + " " +
							j.getJikwon_jik() + " " +
							j.getJikwon_gen());
		}
	}
}
