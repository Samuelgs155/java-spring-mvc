package com.spring.mvc.apirest.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.mvc.apirest.constant.ViewConstant;
import com.spring.mvc.apirest.model.UserCredentials;

@Controller
public class LoginController {
	
	private static final Log LOG  = LogFactory.getLog(LoginController.class);
	
	@GetMapping("/")
	public String redirectToLogin() {
		LOG.info("METHOD: redirectToLogin()");
		return "redirect:/login";
	}
	
	@GetMapping("/login")
	public String showLoginForm(Model model, 
			@RequestParam(name="error", required=false) String error,
			@RequestParam(name="logout", required=false) String logout) {
		LOG.info("METHOD: showLoginForm() -- PARAMS: error=" + error + ", logout=" + logout);
		model.addAttribute("error", error);
		model.addAttribute("logout", logout);
		model.addAttribute("userCredentials", new UserCredentials());
		LOG.info("Returning to login view");
		return ViewConstant.LOGIN;
	}
	
	@PostMapping("/logincheck")
	public String loginCheck(@ModelAttribute(name="userCredentials") UserCredentials userCredentials) {
		LOG.info("METHOD: loginCheck() -- PARAMS: UserCredentials=" + userCredentials.toString());
		if(userCredentials.getUsername().equals("user") && userCredentials.getPassword().equals("user")) {
			LOG.info("Returning to contacts view");
			return "redirect:/contacts/showcontacts";
		} else {
			LOG.info("Returning to login view?error");
			return "redirect:/login?error";
		}
		
	}

}
