package com.folder.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.folder.dto.TestDTO;


@Controller
public class TestController {

	@GetMapping("/test/1")
	public String test1() {
		return "test1";
	}
	
}
