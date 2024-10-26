package com.cos.blog.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Blog {
	@GetMapping("/blog")
	public String blog() {
		return "<h1>Hello spring Blog </h1>";
	}

}
