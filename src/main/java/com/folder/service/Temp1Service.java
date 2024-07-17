package com.folder.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.folder.mapper.Temp1Mapper;

@Service
public class Temp1Service {
	
	@Autowired
	private Temp1Mapper t1Mapper;

	public List<Map<String, Object>> findList(String accept) {
		return t1Mapper.findList(accept);
	}
	
	public Map<String, Object> save(Map<String, Object> map) {
		t1Mapper.save(map);
		return map;
	}
	
	public Map<String, Object> detail(int no) {
		return t1Mapper.findOne(no);
	}
	
	public Map<String, Object> detail(int no, String accept) {
		Map<String, Object> map = new HashMap<String, Object>();
		if(accept != null) {
			map.put("no", no);
			map.put("accept", accept);
			if(t1Mapper.accept(map) == 1) {
				map = t1Mapper.findOne(no);
			}
		}
		return map;
	}
	
	public Map<String, Object> edit(Map<String, Object> map) {
		if(t1Mapper.edit(map) == 1) {
			map = t1Mapper.findOne(Integer.parseInt(map.get("no").toString())); 
		}
		return map;
	}
	
}
