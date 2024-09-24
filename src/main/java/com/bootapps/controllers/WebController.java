package com.bootapps.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bootapps.services.DataService;
import com.bootapps.utilities.ApplicationRequestCounter;
import com.bootapps.utilities.RequestCounter;

@Controller
@RequestMapping("/webapp")
public class WebController {
	
	@Autowired
	private DataService dservice;
	@Autowired
	RequestCounter sessionscoped;
	@Autowired
	ApplicationRequestCounter applicationScoped;

	@GetMapping("/home")
	public String first(ModelMap map) {
		sessionscoped.setCounter();
		applicationScoped.setCounter();
		map.addAttribute("names",dservice.getNames());
		map.addAttribute("scount",sessionscoped.getCounter());
		map.addAttribute("acount",applicationScoped.getCounter());
		return "home";
	}
}
