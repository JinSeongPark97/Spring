package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import pack.model.ProductModel;

@Controller
public class ProductController {
	@Autowired
	private ProductModel productModel; // field injection
	
	@GetMapping("insdata")
	public String method1() {
		return "redirect:input.html"; // → webapp 
	}
	
	// FORMBEAN 사용 방법(POST)
	@PostMapping("insdata")
	public String method2(ProductBean bean, Model model) {
		model.addAttribute("data", productModel.computerPrice(bean));		
		return "result"; 
	}
}
