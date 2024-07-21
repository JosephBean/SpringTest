package com.folder;

import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@DisplayName("Junit 라이프 사이클 테스트 하는 클래스 입니다.")
public class StandardTests {

	@BeforeAll
    static void initAll() {
		log.info("initAll()");
    }
    @BeforeEach
    void init() {
    	log.info("init()");
    }
    @Test
    void succeedingTest() {
    	log.info("succeedingTest()");
    }
    @Test
    void failingTest() {
    	log.info("failingTest()");
        fail("a failing test");
    }
    @Test @Disabled("for demonstration purposes")
    void skippedTest() {
    	log.info("skippedTest()");
    }
    @Test
    void abortedTest() {
    	log.info("abortedTest()");
        assumeTrue("abc".contains("Z"));
        fail("test should have been aborted");
    }
    @AfterEach
    void tearDown() {
    	log.info("tearDown()");
    }
    @AfterAll
    static void tearDownAll() {
    	log.info("tearDownAll()");
    }
	
}
