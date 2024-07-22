package com.folder.controller;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.folder.dto.TestDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
//@Import(TestController.class)
@WebMvcTest({TestController.class, TestDataController.class, ViewController.class})
public class TestControllerTest {

	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private TestController tc;
	
	@MockBean
	private TestDataController tdc;
	
	@Autowired
	private ObjectMapper object;
	
	@Test
	void test6() throws Exception {
		// 테스트용 정의 : no의 값이 1로 전달 했을 경우 DTO 받기
		TestDTO dto1 = TestDTO.builder().no(2).build();
		TestDTO dto2 = TestDTO.builder().no(1).name("홍길동").age(20).gender(true).build();
		//Mockito.when(tdc.test3(dto1)).thenReturn(dto2);
		BDDMockito.given(tdc.test3(dto1)).willReturn(dto2);
		String content = object.writeValueAsString(dto1);
		
		// 실행 : no의 값이 1로 입력 받은 후 결과값 리턴
		ResultActions 결과 = mvc.perform(post("/test/3")
				.content(content)
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
		);
		
		// 검사 : 리턴 받은 결과값 비교
		결과.andExpect(status().isOk())
			.andExpect(jsonPath("$.no").value(new Integer(1)))
			.andExpect(jsonPath("$.name", notNullValue()))
			.andExpect(jsonPath("$.gender").value(new Boolean(true)));
		
		Mockito.verify(tdc).test3(dto1);
	}
	
	@Test @Disabled
	void test5() throws Exception {
		mvc.perform(get("/detail/{no:[0-9]+}", "1A").accept(MediaType.APPLICATION_JSON));
	}
	
	@Test @Disabled
	void test4() throws Exception {
		Map map = new HashMap<>();
		map.put("name", "홍길동");
		map.put("age", 18);
		String content = object.writeValueAsString(map);
		
		// 실행
		MvcResult 결과 =  mvc.perform(
				get("/test/2")
				.content(content)
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
			).andReturn();
		
		// 검사
		assertEquals("application/xml", 결과.getResponse().getContentType());
		
	}
	
	@Test @Disabled
	void test3() throws Exception {		
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
		assertEquals("참", 결과);
	}
	
}
