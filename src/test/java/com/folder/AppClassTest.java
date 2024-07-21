package com.folder;

import org.junit.jupiter.api.ClassOrderer;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestClassOrder;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@TestClassOrder(ClassOrderer.OrderAnnotation.class)
class AppClassTest {

	@Nested @Order(1)
	class Test2 {
		
		@Test
		void test1() {
			log.info("Test2.test1()");
		}
		
	}
	
	@Nested @Order(2)
	class Test1 {
		
		@Test
		void test1() {
			log.info("Test1.test1()");
		}
		
	}

}
