package pack;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


import jakarta.servlet.http.HttpServletRequest;

/*
@RestController // @Controller + @ResponseBody
public class TestController {
	@RequestMapping("test1") // test1에 대한 요청이 올려오면 메소드 실행, get/post 구분하지 않는다.
	public String test() {	
		return " 요청에 대한 반응 보기 ";
	}
}
*/

@Controller // 사용자의 요청을 받아가지고 처리한 후 지정된 view(템플릿 엔진:jsp...(velocity,timeleaf))에 모델 객체를 넘겨주는 역할
public class TestController {
	@RequestMapping("test1") // test1에 대한 요청이 올려오면 메소드 실행, get/post 모두 처리.
	public ModelAndView test() {	
		 //System.out.println("test1 처리");
		 //return null;
		
		// 오리지널 형식
		//return new ModelAndView("list", "msg", "안녕? jsp😒💣"); // 첫번째 인자는 view 파일명 : list.jsp를 찾게 함.
		
		// 위 return을 풀어적으면 다음과 같다.
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("list");
		// request.setAttribute("msg", "안녕", jsp")
		// HttpServletRequest를 사용해 Key,Value로 jsp에 전송
		modelAndView.addObject("msg", "안녕? jsp😒💣"); // addObject : key:value 
		return modelAndView;
	}
	
	@RequestMapping(value="test2", method=RequestMethod.GET) // GET 요청만 처리가 가능함. post만 처리하고싶으면 = .post
	public ModelAndView test2() {
		return new ModelAndView("list", "msg", "Succes 2");
	}
	
	@GetMapping("test3") // get 만 요청 처리 가능
	public ModelAndView test3() {
		return new ModelAndView("list", "msg", "Succes 3");
	}
	
	@GetMapping("test4") // get 만 요청 처리 가능
	public String test4(Model model) {
		model.addAttribute("msg", "Succes 4");
		return "list";
	}
	
	@RequestMapping(value="test5", method=RequestMethod.POST) // GET 요청만 처리가 가능함. post만 처리하고싶으면 = .post
	public ModelAndView test5() {
		return new ModelAndView("list", "msg", "Succes 5");
	}
	
	@PostMapping("test6") // Post 만 요청 처리 가능
	public ModelAndView test6(Model model) {
		return new ModelAndView("list", "msg", "Succes 6");
	}
	
	@PostMapping("test7") // Post 만 요청 처리 가능, view 파일명을 반환, String 을 반환하는 것이 아니다.
	public String test7(Model model) {
		model.addAttribute("msg", "Succes 4"); // 모델에 삽입
		return "list";
	}
	
	@GetMapping("test8") // get 만 요청 처리 가능
	@ResponseBody // 일반 데이터를 그대로 리턴한다.
	public String test8() {
		String value = "일반 데이터- String, Map, JSON 등을 전달 가능";
		return value;
	}
	
	@GetMapping("test8_1")
	@ResponseBody // key,value
	public DataDto test8_1() {
		DataDto dto = new DataDto();
		dto.setCode(7);
		dto.setName("손흥민");
		return dto; // JSON 형태로 반환한다. jackson 라이브러리 지원.
	}
	
}