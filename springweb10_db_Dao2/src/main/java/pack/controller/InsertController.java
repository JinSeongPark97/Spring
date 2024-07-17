package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import pack.model.MemberDao;

@Controller
public class InsertController {
	@Autowired
	private MemberDao memberDao;

	@GetMapping("insert")
	public String method1() {
		return "insform";
	}
	
	@PostMapping("insert")
	public String submit(MemberBean bean) {
		// 추가 후 목록 보기
		memberDao.insData(bean);
		return "redirect:/list"; // 포워딩하면 추가된 내용을 읽을 수 없다. redirect를 해야함. 
	}
}
