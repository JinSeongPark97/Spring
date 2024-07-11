package pack;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

// 스프링은 기본이 singleton 
@Controller
public class TestController3 {
	@RequestMapping("/java/korea")
	public String ghi(Model model) {
		model.addAttribute("msg", "Success /java/korea");
		return "list"; 		
	}
	
	@GetMapping(value={"/java/good", "nice", "ok"}) // 여러개 일 경우에는 배열 형태로 값을 입력한다.
	public String ghi2(Model model) {
		model.addAttribute("msg", "여러 개의 요청이 한 개의 메소드와 매핑");
		return "list"; 		
	}
	
	
	
}
