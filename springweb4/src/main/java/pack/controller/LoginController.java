package pack.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller // 클라이언트의 요청을 받아가지고 모델을 다녀와 받은값을 뷰파일을 통해 처리.
public class LoginController {
	// 로그 정보 출력용 클래스
	private final Logger logger = LoggerFactory.getLogger(this.getClass()); // 현재 클래스가 적용됨
	
	
	@GetMapping("login")
	public String submitCall() {
		// 타임리프의 경우 templates로 이동.
		// jsp를 사용한 경우엔 main/views로 이동.		
		// return "login.html"; // foward : 기본값
		
		
		return "redirect:login.html"; // redirect 명시적으로 적어줘야함. (view 이동 x , webapp/login.html 으로 다이렉트 이동)
		// return "redirect:http://localhost/loing.html"; // 위 행과 동일
		// forwarding -> views로 이동.
	}
	// 클라이언트가 전달한 값 수신 방법 1: 전통적인 방법
	/*
	@PostMapping("login")
	public String submit(HttpServletRequest request, Model model) {
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		// 초보적 방식
		System.out.println(id + " " + pwd);		
		// loger 클래스 사용
		logger.info(id + " " + pwd); // 로그레벨 trace > debug > info > warn > error > fatal
		
		String data = "";
		if(id.equals("kor") && pwd.equals("111"))
			data = "로그인 성공";
		else
			data = "로그인 실패";
		model.addAttribute("data", data); // setAttribute()의 역할
		return "result"; // forwarding
 	}
 	*/
	
	// 스프링이 제공하는 방법 2 : Spring Annotation 사용.
	// 클라이언트가 입력한 값은 항상 문자열로 넘어옴. 형변환이 가능하다.
	@PostMapping("login")
	public String submit(@RequestParam(value="id") String id, 
			// @RequestParam(value="pwd") String pwd,
			// @RequestParam(value="pwd") int pwd, // 문자열을 인트형으로 형변환 함.
			// defaultValue : 초기치를 줄 수 있음, 문자형을 숫자형으로 변환시킴, 초기치가 있어 아무것도 입력없이 전송클릭해도 로그인이 됨.
			@RequestParam(value="pwd", defaultValue = "111") int pwd, 
			Model model) {
		
		String data = "";
		// if(id.equals("kor") && pwd.equals("111"))
		if(id.equals("kor") && pwd == 111)
			data = "로그인 성공";
		else
			data = "로그인 실패";
		model.addAttribute("data", data); // setAttribute()의 역할
		return "result"; // forwarding
	}
}