package jp.csii.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// json
@RestController
public class HelloController {
  
//http://localhost:8080/
//		@GetMapping
//		public String get() {
//				return "Hello World ！";
//		}

	//http://localhost:8080/a  要斜線 代參  因為還沒有index.html
	@RequestMapping("/{author}")//參數
	public String get(@PathVariable String author) {
		return "Hello W  P-2"+author;
	}
}
