package com.spring.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.example.component.ExampleComponent;
import com.spring.example.service.ExampleService;

@Controller
@RequestMapping("/example7")
public class ExampleController7 {

	@Autowired
	@Qualifier("exampleComponent")
	private ExampleComponent exampleComponent;

	@Autowired
	@Qualifier("exampleService")
	private ExampleService exampleService;

	public static final String EXAMPLE_VIEW_7 = "example7";

	// Primera forma recuperar plantillas
	// @GetMapping("/exampleString")
	@RequestMapping(value = "/exampleString", method = RequestMethod.GET)
	public String exampleString(Model model) {
		exampleComponent.sayHello();
		model.addAttribute("people", exampleService.getListPeople());
		return EXAMPLE_VIEW_7;
	}

	// Segunda forma recuperar plantillas
	@RequestMapping(value = "/exampleMAV", method = RequestMethod.GET)
	public ModelAndView exampleMAV() {
		ModelAndView mav = new ModelAndView(EXAMPLE_VIEW_7);
		mav.addObject("people", exampleService.getListPeople());
		return mav;
	}

}
