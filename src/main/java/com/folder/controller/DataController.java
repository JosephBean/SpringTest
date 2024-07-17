package com.folder.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.folder.service.Temp1Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class DataController {
	
	@Autowired
	private Temp1Service ts;

	@PostMapping(value = {"/findList", "/findList/{accept:[0-1]}"})
	public List<Map<String, Object>> findList(@PathVariable(name = "accept", required = false) String accept) {
		log.info("Accept : {}", accept);
		return ts.findList(accept);
	}
	
	@PostMapping("/save")
	public Map<String, Object> save(@RequestParam Map<String, Object> map) {
		log.info("Map : {}", map);
		return ts.save(map);
	}
	
	@PostMapping("/detail/{no:[0-9]+}")
	public Map<String, Object> detail(@PathVariable(name = "no") int no) {
		log.info("No : {}", no);
		return ts.detail(no);
	}
	
	@PostMapping("/detail/{no:[0-9]+}/{accept:[0-1]}")
	public Map<String, Object> detail(@PathVariable(name = "no") int no, @PathVariable(name = "accept") String accept) {
		log.info("No : {}, Accept : {}", no, accept);
		return ts.detail(no, accept);
	}
	
	@PostMapping("/edit")
	public Map<String, Object> edit(@RequestParam Map<String, Object> map) {
		log.info("Map : {}", map);
		return ts.edit(map);
	}
	
}
