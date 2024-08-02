package pack.controller;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import pack.model.DataDao;

@Controller
public class MemberController {
	
	@Autowired
	private DataDao dataDao;
   
   @GetMapping("/")
   public String start() {
      return "start";
   }
   
   @GetMapping("list")
   public String list(Model model) {
	   ArrayList<Mem> list = dataDao.getDataAll();
	   model.addAttribute("datas", list);
	   return list;
      
      return "list";
   }
}