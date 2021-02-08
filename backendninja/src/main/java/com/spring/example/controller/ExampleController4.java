package com.spring.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.example.model.Person;

@Controller
@RequestMapping("/example4")
public class ExampleController4 {
	
	public static final String EXAMPLE_VIEW_4 = "example4";
	
	// Primera forma recuperar plantillas
	// @GetMapping("/exampleString")
	@RequestMapping(value="/exampleString", method=RequestMethod.GET)
	public String exampleString(Model model) {
		model.addAttribute("people", this.getPeople());
		return EXAMPLE_VIEW_4;
	}
	
	// Segunda forma recuperar plantillas
	@RequestMapping(value="/exampleMAV", method=RequestMethod.GET)
	public ModelAndView exampleMAV() {
		ModelAndView mav = new ModelAndView(EXAMPLE_VIEW_4);
		mav.addObject("people", this.getPeople());		
		return mav;
	}
	
	private List<Person> getPeople() {
		List<Person> people = new ArrayList<Person>();
		people.add(new Person("Sam", 25));
		people.add(new Person("Paco", 30));
		people.add(new Person("Eva", 31));
		people.add(new Person("Paula", 33));
		return people;
	}

}
