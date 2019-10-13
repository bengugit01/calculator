package com.bengu.calculator.service;

import org.springframework.stereotype.Service;

/**
 * This is Calculator Implementation service
 * @author Ben Gu
 *
 */
@Service
public class CalculatorImpl implements Calculator {

	@Override
	public int sum(int a, int b) {
		return a + b;
	}

}
