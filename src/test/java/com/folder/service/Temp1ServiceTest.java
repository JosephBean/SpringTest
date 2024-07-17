package com.folder.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Temp1ServiceTest {
	
	@Autowired
	private Temp1Service t1Service;

	@Test
	void findList() {
		String accept = null; // null, 0, 1
		int 예상수 = 8;
		
		int 결과수 = t1Service.findList(accept).size();
		
		assertEquals(예상수, 결과수);
	}
	
}
