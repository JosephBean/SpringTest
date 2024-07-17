package com.folder.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:context.xml")
public class AppServiceTest2 {
	
	@Autowired
	private AppService appService;

	@Test
	void test1() {
		assertEquals(8, appService.합(2, 6));
	}
	
}
