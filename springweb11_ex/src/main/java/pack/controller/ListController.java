package pack.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pack.model.JikwonDao;
import pack.model.JikwonDto;

@Controller
public class ListController {
	@Autowired
	private JikwonDao dataDao;
	
	@GetMapping("jikwondb")
	public String listProcess(@RequestParam(value="jik")String jik , Model model) {
		ArrayList<JikwonDto> list = (ArrayList<JikwonDto>)dataDao.getDataSearch(jik);
		model.addAttribute("datas",list);
		return "show";
	}
	
	
		
}
