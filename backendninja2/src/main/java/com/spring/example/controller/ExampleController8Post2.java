package com.spring.example.controller;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.spring.example.model.Person;

@Controller
@RequestMapping("/example8")
public class ExampleController8Post2 {
	
	private static final Log LOGGER = LogFactory.getLog(ExampleController8Post2.class);

	public static final String FORM_VIEW = "form2";
	public static final String FORM_VIEW_2 = "form2";
	public static final String RESULT_VIEW = "result";
	
	// Forma 1 redireccionar
//	@GetMapping("/")
//	public String redirect() {
//		return "redirect:/example6/showform";
//	}
	
	// Forma 2 redireccionar
//	@GetMapping("/")
//	public RedirectView redirect() {
//		return new RedirectView("/example/showform");
//	}

	@GetMapping("/showform")
	public String showForm(Model model) {
		LOGGER.info("INFO TRACE");
		LOGGER.warn("Warning TRACE");
		LOGGER.error("Error TRACE");
		LOGGER.debug("Debug TRACE");
		model.addAttribute("person", new Person());
		// int i = 6 / 0;
		return FORM_VIEW_2;
	}
	
	@PostMapping("/addperson")
	public ModelAndView addPerson(@Valid @ModelAttribute("person") Person person, BindingResult bindingResult) {
		ModelAndView mav = new ModelAndView();
		if(bindingResult.hasErrors()) {
			mav.setViewName(FORM_VIEW);
		} else {
			mav.setViewName(RESULT_VIEW);
			mav.addObject("person", person);
		}		
		return mav;
		
	}

}
