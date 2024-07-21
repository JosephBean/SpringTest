package com.folder.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ExtendWith(SpringExtension.class)
@Import({Temp1Service.class})
//@SpringBootTest
public class Temp1ServiceTest {
	
	@MockBean   // 테스트를 위하여 대상 클래스 비어 있는 상태로 생성해 준다.
	//@Autowired
	private Temp1Service t1Service;
	
	private static List<Map<String, Object>> list;
	private static Map<String, Object> map1;
	private static Map<String, Object> map2;
	
	@BeforeAll  // 테스트 시작 전 공통 초기값 설정
	static void setUp() {
		list = new ArrayList<Map<String, Object>>();
		map1 = new HashMap<String, Object>();
		map1.put("no", 1);
		map1.put("title", "연습1");
		map1.put("content", "내용1");
		map1.put("accept", 0);
		map1.put("regDate", "2024-07-04 16:24:03");
		map2 = new HashMap<String, Object>();
		map2.put("no", 2);
		map2.put("title", "연습2");
		map2.put("content", "내용2");
		map2.put("accept", 1);
		map2.put("regDate", "2024-07-05 16:03:33");
	}
	
	@AfterEach
	void reset() {
		list = new ArrayList<Map<String, Object>>();
	}

  /****************************************************
   * 1단계 : 시나리오 진행에 필요한 조건 설정
   * 2단계 : 시나리오를 진행 시 필요한 변화를 명시
   * 3단계 : 시나리오를 완료했을 때 예상되는 결과를 명시
   ****************************************************/
	
	@Test @DisplayName("전체 목록 확인하기")
	void Test1() {
		log.info("전체 목록 시작");
		list.add(map1);
		list.add(map2);
		
		Mockito.when(t1Service.findList(null)).thenReturn(list);
		
		List<Map<String, Object>> result = t1Service.findList(null);
		
		assertEquals(2, result.size());
		
		Mockito.verify(t1Service).findList(null);
	}
	@Test @DisplayName("승인 목록 확인하기") @Disabled
	void Test2() {
		log.info("승인 목록 시작 : {}", list.size());
		list.add(map2);
		Mockito.when(t1Service.findList("1")).thenReturn(list);
		
		List<Map<String, Object>> result = t1Service.findList("1");
		
		assertEquals(1, result.get(0).get("accept"));
		Mockito.verify(t1Service).findList("1");
	}
	@Test @DisplayName("미승인 목록 확인하기") @Disabled
	void Test3() {
		log.info("미승인 목록 시작 : {}", list.size());
		list.add(map1);
		Mockito.when(t1Service.findList("0")).thenReturn(list);
		
		List<Map<String, Object>> result = t1Service.findList("0");
		
		assertEquals(0, result.get(0).get("accept"));
		verify(t1Service).findList("0");
	}
	
}
