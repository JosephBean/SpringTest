package com.folder.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class ViewController {

	@GetMapping("/findList")
	public String findList() {
		return "v2/list";
	}
	
	@GetMapping("/new")
	public String newPage() {
		return "v2/new";
	}
	
	@GetMapping("/detail/{no:[0-9]+}")
	public String detail(@PathVariable(name="no") int no) {
		log.info("NO : {}", no);
		return "v2/detail";
	}
	
}
