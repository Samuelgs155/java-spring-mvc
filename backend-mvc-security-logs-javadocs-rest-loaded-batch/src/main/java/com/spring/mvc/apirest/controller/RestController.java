package com.spring.mvc.apirest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.mvc.apirest.model.ContactModel;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/rest")
public class RestController {

	@GetMapping("/checkrest")
	// public ResponseEntity<String> checkrest() {
	public ResponseEntity<ContactModel> checkrest() {
		ContactModel cm = new ContactModel(2, "contact1","contact1", "123456789", "Albacete");
		// return new ResponseEntity<String>("OK!!!", HttpStatus.OK);
		return new ResponseEntity<ContactModel>(cm, HttpStatus.OK);
	}
}
