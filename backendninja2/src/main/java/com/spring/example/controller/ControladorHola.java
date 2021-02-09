package com.spring.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/say")
public class ControladorHola {
	
	@GetMapping("/helloworld")
	public String hola() {
		return "helloworld";
	}

}
