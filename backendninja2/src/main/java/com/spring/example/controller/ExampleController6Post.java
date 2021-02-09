package com.spring.example.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.spring.example.model.Person;

@Controller
@RequestMapping("/example6")
public class ExampleController6Post {
	
	private static final Log LOGGER = LogFactory.getLog(ExampleController6Post.class);

	public static final String FORM_VIEW = "form";
	public static final String RESULT_VIEW = "result";
	
	// Forma 1 redireccionar
//	@GetMapping("/")
//	public String redirect() {
//		return "redirect:/example6/showform";
//	}
	
	// Forma 2 redireccionar
	@GetMapping("/")
	public RedirectView redirect() {
		return new RedirectView("/example6/showform");
	}

	@GetMapping("/showform")
	public String showForm(Model model) {
		LOGGER.info("INFO TRACE");
		LOGGER.warn("Warning TRACE");
		LOGGER.error("Error TRACE");
		LOGGER.debug("Debug TRACE");
		model.addAttribute("person", new Person());
		// int i = 6 / 0;
		return FORM_VIEW;
	}
	
	@PostMapping("/addperson")
	public ModelAndView addPerson(@ModelAttribute("person") Person person) {
		ModelAndView mav = new ModelAndView(RESULT_VIEW);
		mav.addObject("person", person);
		return mav;
		
	}

}
