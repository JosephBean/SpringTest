package com.folder.service;

import org.springframework.stereotype.Service;

@Service
public class AppService {

	public int 합(int a, int b) {
		return (a + b);
	}
	
	public int 빼기(int a, int b) {
		return (a - b);
	}
	
	public int 곱(int a, int b) {
		return (a * b);
	}
	
	public int 나누기(int a, int b) {
		return (a / b);
	}
	
}
