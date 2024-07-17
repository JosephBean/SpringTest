package com.folder.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ExtendWith(SpringExtension.class)  // 단위테스트 환경 설정
@Import({AppService.class})			// 지정한 클래스 가져오기
class AppServiceTest {

	@Autowired
	private AppService appService;
	
	private int a, b;
	
	@BeforeEach
	void setUp() {
		this.a = 3;
		this.b = 5;
		log.info("a:{}, b:{}", a, b);
	}
	
	@Test @DisplayName("합 메소드 테스트") 
	void test1() {
		int 결과값 = appService.합(a, b);
		assertEquals((a + b), 결과값);
	}
	@Test @DisplayName("빼기 메소드 테스트") 
	void test2() {
		int 결과값 = appService.빼기(a, b);
		assertEquals((a - b), 결과값);
	}
	@Test @DisplayName("곱 메소드 테스트") 
	void test3() {
		int 결과값 = appService.곱(a, b);
		assertEquals((a * b), 결과값);
	}
	@Test @DisplayName("나누기 메소드 테스트") 
	void test4() {
		int 결과값 = appService.나누기(a, b);
		assertEquals((a / b), 결과값);
	}
	
}
