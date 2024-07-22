package com.folder.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestDataController {

	@GetMapping("/test/2")
	public Map test2() {
		Map map = new HashMap<>();
		map.put("name", null);
		map.put("age", 18);		
		return map;
	}
	
}
