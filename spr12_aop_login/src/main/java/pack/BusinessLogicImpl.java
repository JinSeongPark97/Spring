package pack;

import org.springframework.stereotype.Service;

@Service("bImpl")
public class BusinessLogicImpl implements BusinessLogicInter{
	private void Bisiness() {

	}
	
	@Override
	public void startProcess() { // 핵심 로직
		System.out.println("검증 되었음으로 핵심 로직 수행");
		
	}
}
