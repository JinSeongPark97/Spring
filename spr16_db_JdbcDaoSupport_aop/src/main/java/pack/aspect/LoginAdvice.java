package pack.aspect;

import java.util.Scanner;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoginAdvice { // 관심 사항
	
	// 핵심 로직
	@Around("execution(public void jikwonList())")
	public Object test(ProceedingJoinPoint JoinPoint) throws Throwable {
		System.out.println("Login id 입력");
		Scanner scanner = new Scanner(System.in);
		String id = scanner.next();
		
		// kor 일때만 로그인
		if(!id.equalsIgnoreCase("test")) { 
			System.out.println("id 불일치. login 실패");
			return null;			
		}
		
		Object object = JoinPoint.proceed();
		scanner.close();
		
		return object;
	}
}
