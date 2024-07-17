package com.folder;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.folder.service.AppService;

@SpringBootTest
class SpringTestApplicationTests {

	@Test @DisplayName("정수 6과 변수 a 비교하는 테스트") @Disabled
	void test1() {
		int a = 5;
		assertEquals(6, a);
	}
	
	@Test @Disabled
	void test2() {
		assertEquals("김", "박");
	}

	@Autowired
	private AppService appService;
	
	@Test
	void test3() {
		// 예상값 (비교값을 만들자)
		int a = 3;
		int b = 5;
		int c = 8;
		
		// 대상 메소드 호출 실행 >> 결과값을 받는다.
		int d = appService.합(a, b);
		
		// 예상값과 결과값을 비교하자
		assertEquals(c, d);
	}
	
	
	
	
	
	
}
