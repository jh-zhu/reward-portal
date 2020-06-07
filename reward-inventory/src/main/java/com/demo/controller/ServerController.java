package com.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServerController {

	@GetMapping("/msg")
	public String msg() {
		return "This is a development test message";
	}
	
}