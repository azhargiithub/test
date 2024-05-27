package com.neosoft.controller;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.neosoft.model.Employee;

@RestController
public class TestController {

	@PostMapping("/getMsg")
	public String getMessage(@RequestBody @Valid Employee e) {
		
		return "success";
	}
}
