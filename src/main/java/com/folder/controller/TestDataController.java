package com.folder.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.folder.dto.TestDTO;

@RestController
public class TestDataController {

	@GetMapping("/test/2")
	public Map test2() {
		Map map = new HashMap<>();
		map.put("name", null);
		map.put("age", 18);		
		return map;
	}
	
	@PostMapping("/test/3")
	public TestDTO test3(@RequestBody TestDTO dto) {
		return TestDTO.builder()
				.no(1)
				.name("홍길동")
				.age(20)
				.gender(true)
				.build();
	}
	
}
