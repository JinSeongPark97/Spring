package pack.controller;

import java.lang.reflect.Member;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import pack.dto.MemberDto;
import pack.repository.MemberDao;

//@Controller
//@ResponseBody // 자바의 객체를 HTTP 응답본문의 객체로 변환한다. 클라이언트에 전송하는데 JSON타입으로 전송한다. 응답을 하는데 json타입으로 응답하겠다는 의미.
@RestController // 위 두 줄을 합친 어노테이션, 비동기 처리에서 사용, 객체 데이터를 JSON 형태로 변환해 반환하는 역할
public class MemberController {
	
	@Autowired 
	private MemberDao dao;
	
	
	/*
//	@GetMapping("/members") // Get 요청이 들어와 받음.
//	public String list(Model model) {
//		List<MemberDto> list= dao.getList();
//		model.addAttribute("list", list);
//		return "list";
//	}
	
	@GetMapping("/members")
	public MemberDto list(Model model) {
		MemberDto dto = new MemberDto();
		dto.setNum(1);
		dto.setName("김말이");
		dto.setAddr("강남구 역삼동");
		return dto;
	}
	
	@GetMapping("/insertform") // Get 요청이 들어와 받음.
	public String insertform() {
		return "insertform";
	}
	
	@PostMapping("/insert") // Post 요청이 들어와 받음.
	public String insert(@RequestParam("name")String name, @RequestParam("addr")String addr) {
		MemberDto dto = new MemberDto();
		dto.setName(name);
		dto.setAddr(addr);
		dao.insert(dto);
		return "redirect:/members"; // 추가 후 목록보기
	}
	*/
	
	// ------------Rest 요청 처리 --------------
	@GetMapping("/members") // 전체 자료 읽기(Get)
	public List<MemberDto> getList() {
		// DB 자료를 읽어 
		// Html 파일로 반환 X
		// JSON 형태로 변환해 클라이언트(JavaScript Ajax 요청)에 반환
		return dao.getList(); // 자료를 읽고 그대로 리턴
	}
	
	@PostMapping("/members") // 자료 추가
	public Map<String, Object> insert(@RequestBody MemberDto dto) {
		// @RequestBody : 요청 본문에 담긴 값(json)을 자바객체로 변환
		dao.insert(dto);
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("isSuccess", true); // JSON 방식으로 리턴
		return map;
	}
	
	@GetMapping("/members/{num}") // http://localhost:80/members/3
	public MemberDto getData(@PathVariable("num")int num) {
		return dao.getData(num); 		
	}
	
	@PutMapping("/members/{num}") 
	public Map<String, Object> update(@PathVariable("num")int num,@RequestBody MemberDto dto) {
		dto.setNum(num);
		dao.update(dto);
		return Map.of("isSuccess", true); // 77~79 행과 같은 뜻
	}
	
	@DeleteMapping("/members/{num}")
	public Map<String, Object> delete(@PathVariable("num")int num,@RequestBody MemberDto dto) {
		dao.delete(num);
		return Map.of("isSuccess", true);
	}
	
}
