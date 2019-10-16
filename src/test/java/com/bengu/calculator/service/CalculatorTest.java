package com.bengu.calculator.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Calculator test
 * @author Ben Gu
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CalculatorTest {
	
	@Autowired
	private Calculator calculator;

	@Test
	public void sumTest() {
	
		// when
		int acutalSum = calculator.sum(10, 20);
		
		// then
		assertEquals(30, acutalSum);
	}

}
