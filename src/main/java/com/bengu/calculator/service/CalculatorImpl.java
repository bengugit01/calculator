package com.bengu.calculator.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorImpl implements Calculator {

	@Override
	public int sum(int a, int b) {
		return a + b;
	}

}
