package com.spring.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.example.model.Person;

@Controller
@RequestMapping("/example5")
public class ExampleController5 {
	
	public static final String EXAMPLE_VIEW_5 = "example5";
	
	//localhost:8080/example5/reques1?nm=JON
	//localhost:8080/example5/reques1?nm=MIKEL
	@GetMapping("/request1")
	public ModelAndView request1(@RequestParam(name="nm", required = false, defaultValue = "NULL") String name) {
		ModelAndView mav = new ModelAndView(EXAMPLE_VIEW_5);
		mav.addObject("nm_in_model", name);
		return mav;
	}
	
	//localhost:8080/example5/reques2/JON
	//localhost:8080/example5/reques2/MIKEL
	@GetMapping("/request2/{nm}")
	public ModelAndView request2(@PathVariable("nm") String name) {
		ModelAndView mav = new ModelAndView(EXAMPLE_VIEW_5);
		mav.addObject("nm_in_model", name);
		return mav;
	}
}
