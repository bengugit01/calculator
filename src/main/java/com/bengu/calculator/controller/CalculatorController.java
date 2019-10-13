package com.bengu.calculator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bengu.calculator.service.Calculator;

/**
 * This the the calculator controller
 * @author Ben Gu
 *
 */
@RestController
@RequestMapping("/calculator")
public class CalculatorController {
	
	@Autowired
	private Calculator calculator;
	
	@GetMapping("/sum")
	String sum(@RequestParam("a") Integer a, @RequestParam("b") Integer b) {
		return String.valueOf(calculator.sum(a, b));
	}
}
