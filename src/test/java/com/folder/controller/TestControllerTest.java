package com.folder.controller;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.mockito.ArgumentMatchers.notNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import java.lang.Thread.State;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
//@ExtendWith(SpringExtension.class)
//@Import(TestController.class)
@WebMvcTest({TestController.class, TestDataController.class})
public class TestControllerTest {

	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private TestController tc;
	
	@Autowired
	private TestDataController tdc;
	
	@Autowired
	private ObjectMapper object;
	
	@Test
	void test3() throws Exception {
		// 가상 데이터 생성
		Map map = new HashMap<>();
		map.put("name", "홍길동");
		map.put("age", 18);
		
		String content = object.writeValueAsString(map);
		
		// 호출
		ResultActions 결과 = mvc.perform(
				get("/test/2")
				.content(content)
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
		);
		
		// 검사
		결과.andExpect(status().isOk())
			.andExpect( jsonPath("$.name", nullValue()) )
			.andExpect( jsonPath("$.age", notNullValue()) )
			.andDo(print());
	}
	
	@Test @Disabled
	void test2() throws Exception {
		// 해당 메소드 URL 호출 후 결과값 받기
		ResultActions 결과 = mvc.perform(get("/test/1"));
		
		// 200 상태값을 리턴 검사
		결과.andExpect(status().isOk()); 
	}
	
	@Test @Disabled
	void test1() {
		String 결과 = tc.test1();
		log.info(결과);
	}
	
}
