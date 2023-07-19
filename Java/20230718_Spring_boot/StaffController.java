package jp.csii.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class StaffController {


	//只有 index 可以只寫/
	//@RequestMapping("/")
	@RequestMapping(path="/", method = RequestMethod.GET)
	public String M01() {
		return "index";
	}
	@RequestMapping(path="/input", method = RequestMethod.POST)
	//抓前端值
	public String M02(@ModelAttribute("param1") String param1, @ModelAttribute("param2") String param2,Model model){

		//傳回前端顯示值
		model.addAttribute("key", param1 + param2);


		//前端傳值
		//System.out.println(param1 + param2);
		return "index";
	}
}
