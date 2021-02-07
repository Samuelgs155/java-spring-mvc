package com.spring.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.example.model.Person;

@Controller
@RequestMapping("/example3")
public class ExampleController3 {
	
	public static final String EXAMPLE_VIEW = "example3";
	
	// Primera forma recuperar plantillas
	// @GetMapping("/exampleString")
	@RequestMapping(value="/exampleString", method=RequestMethod.GET)
	public String exampleString(Model model) {
		model.addAttribute("person", new Person("Sam", 25));
		return EXAMPLE_VIEW;
	}
	
	// Segunda forma recuperar plantillas
	@RequestMapping(value="/exampleMAV", method=RequestMethod.GET)
	public ModelAndView exampleMAV() {
		ModelAndView mav = new ModelAndView(EXAMPLE_VIEW);
		mav.addObject("person", new Person("Paco", 30));		
		return mav;
	}

}
