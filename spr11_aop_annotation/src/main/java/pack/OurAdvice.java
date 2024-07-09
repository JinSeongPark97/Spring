package pack;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

// Aspect 클래스 : 관심사항을 담은 클래스(Advice 용) 
@Aspect
@Component
public class OurAdvice {
	// @Before : 핵심 메소드 앞에서만 수행
	// @After : 핵심 메소드 뒤에서만 수행
	@Around("execution(* *..*LogicInter*.*(..)) or execution(public void selectAll())") // 핵심 메소드 앞 뒤에서만 수행
	public Object testM(ProceedingJoinPoint joinPoint) throws Throwable {
		// 수행 시간 체크 → 관심사항에 해당함
		StopWatch stopWatch = new StopWatch(); // StopWatch 객체 생성
		stopWatch.start(); // 스탑워치 시작
		
		System.out.println("핵심 메소드 수행 전 관심사항 실행"); // 로그인 , 시큐리티 , 트랜잭션 등
		
		Object object = joinPoint.proceed(); // 선택된 핵심 메소드 수행
		
		System.out.println("핵심 메소드 수행 후 뭔가를 실행");   
		
		stopWatch.stop(); // 스탑워치 종료
		System.out.println("처리 시간 : " + stopWatch.getTotalTimeSeconds()); // 처리시간을 초로 확인 
		
		return object;
	}

}
