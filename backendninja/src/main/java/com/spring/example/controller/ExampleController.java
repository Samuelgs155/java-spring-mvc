package com.spring.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/example")
public class ExampleController {
	
	public static final String EXAMPLE_VIEW = "example";
	
	// Primera forma recuperar plantillas
	// @GetMapping("/exampleString")
	@RequestMapping(value="/exampleString", method=RequestMethod.GET)
	public String exampleString() {
		return EXAMPLE_VIEW;
	}
	
	// Segunda forma recuperar plantillas
	@RequestMapping(value="/exampleMAV", method=RequestMethod.GET)
	public ModelAndView exampleMAV() {
		return new ModelAndView(EXAMPLE_VIEW);
	}

}
