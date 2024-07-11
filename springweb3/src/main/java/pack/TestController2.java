package pack;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("test9")
public class TestController2 {
	@RequestMapping(method=RequestMethod.GET) //
	public String Test1(Model model) {
		// HttpServletRequest 객체의 값을 저장 후 view에 전달(Model)
		model.addAttribute("msg", "success get");
		return "list"; // list.jsp를 forwarding 한다. → Spring 은 forward 가 기본
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String Test2(Model model) {
		model.addAttribute("msg", "success post");
		return "list";
	}
}
