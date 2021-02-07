package com.spring.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/example2")
public class ExampleController2 {
	
	public static final String EXAMPLE_VIEW = "example2";
	
	// Primera forma recuperar plantillas
	// @GetMapping("/exampleString")
	@RequestMapping(value="/exampleString", method=RequestMethod.GET)
	public String exampleString(Model model) {
		model.addAttribute("name", "Sam");
		return EXAMPLE_VIEW;
	}
	
	// Segunda forma recuperar plantillas
	@RequestMapping(value="/exampleMAV", method=RequestMethod.GET)
	public ModelAndView exampleMAV() {
		ModelAndView mav = new ModelAndView(EXAMPLE_VIEW);
		mav.addObject("name", "Sam2");		
		return mav;
	}

}
