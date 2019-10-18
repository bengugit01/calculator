package com.bengu.calculator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bengu.calculator.service.Calculator;

import lombok.extern.slf4j.Slf4j;

/**
 * This the the calculator controller
 * @author Ben Gu
 *
 */
@Slf4j
@RestController
@RequestMapping("/calculator")
public class CalculatorController {
	
	@Autowired
	private Calculator calculator;
	
	@GetMapping("/sum")
	String sum(@RequestParam("a") Integer a, @RequestParam("b") Integer b) {
		log.debug("Debug: a=" + a + ",  b=" + b);
		return String.valueOf(calculator.sum(a, b));
	}
}
