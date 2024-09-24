package com.bootapps.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/webapp")
public class WebController {

	@GetMapping("/home")
	public String first() {
		return "home";
	}
}
