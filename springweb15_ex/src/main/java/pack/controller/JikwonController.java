package pack.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


import pack.model.JikwonRepositoty;
import pack.model.Jikwon;
import pack.model.JikwonDao;


@Controller
public class JikwonController {
	@Autowired
	JikwonDao dao;
	
	@GetMapping("/")
	public String start() {
		return "index";
	}
	
	@GetMapping("jik")
	public String getJikList(@RequestParam("jikwon") String jik,Model model) {
		ArrayList<Jikwon> list = (ArrayList<Jikwon>)dao.getSearchValue(jik);
		model.addAttribute("list",list);
		return "list";
	}
	
	
}
