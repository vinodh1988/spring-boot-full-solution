package com.bootapps.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bootapps.services.DataService;

@Controller
@RequestMapping("/webapp")
public class WebController {
	
	@Autowired
	private DataService dservice;

	@GetMapping("/home")
	public String first(ModelMap map) {
		map.addAttribute("names",dservice.getNames());
		return "home";
	}
}
