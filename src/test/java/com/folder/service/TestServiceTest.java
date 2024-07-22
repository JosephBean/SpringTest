package com.folder.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ExtendWith(SpringExtension.class)
@Import(TestService.class)
class TestServiceTest {
	
	@Autowired
	//@MockBean
	private TestService ts;

	@Test
	void test() {
		String a = "B";
		String r = "오류";
		
		//Mockito.when(ts.getString(a)).thenReturn(r);
		
		String 결과 = ts.getString(a);
//		log.info(결과);
		assertEquals(r, 결과);
		
		//Mockito.verify(ts).getString(a);
	}

}
