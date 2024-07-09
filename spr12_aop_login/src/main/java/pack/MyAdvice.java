package pack;

import java.util.Scanner;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
@Component
@Aspect
public class MyAdvice {
	
	@Around("execution(public void startProcess())")
	public Object test(ProceedingJoinPoint joinPoint) throws Throwable {
		
		System.out.println("AOP 시작 : 핵심 로직 수행 전 id 검증");
		
		// 로그인 만들기
		System.out.println("input id :");
		Scanner scanner = new Scanner(System.in);
		String id = scanner.nextLine();
		scanner.close();
		
		// 로그인 시도
		if(!id.equals("ok")) { // ok가 아닐 시
			System.out.println("id가 불일치합니다. 작업을 종료합니다.");
			return null; // null을 리턴하면 proceed를 만나지않음, 핵심 메소드 수행 x
		}	
			
		Object object = joinPoint.proceed(); // 이 행이 핵심 메소드 13행의 startProcess()를 수행한다.
		
		return object;
	}
}