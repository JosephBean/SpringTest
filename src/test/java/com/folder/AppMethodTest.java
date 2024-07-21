package com.folder;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(OrderAnnotation.class)
public class AppMethodTest {

	@Test @Order(2)
	void test3() {
		System.out.println("test3()");
	}
	
	@Test @Order(1)
	void test2() {
		System.out.println("test2()");
	}
	
	@Test @Order(3)
	void test1() {
		System.out.println("test1()");
	}
	
}
