package com.folder.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import lombok.extern.slf4j.Slf4j;

@Slf4j
//@ExtendWith(SpringExtension.class)
//@Import({AppService.class})
class AppServiceTest {

	@Autowired
	private static AppService appService;
	
	private int a, b;
	
	@BeforeAll
    static void initAll() {
		appService = new AppService();
    }

	@Test @DisplayName("3의 값을 넣고 합이 3으로 나오면 정상")
	void test1() {
		log.info("test1()");
		
		a = 3;
		int 결과 = appService.합(a, b);
		assertEquals(2, 결과);
	}
	
}
