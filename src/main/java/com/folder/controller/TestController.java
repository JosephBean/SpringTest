package com.folder.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class TestController {

	@GetMapping("/test/1")
	public String test1() {
		return "test1";
	}
	
}
