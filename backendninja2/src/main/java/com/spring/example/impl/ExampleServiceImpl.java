package com.spring.example.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.spring.example.model.Person;
import com.spring.example.service.ExampleService;

@Service("exampleService")
public class ExampleServiceImpl implements ExampleService {
	
	private static final Log LOG = LogFactory.getLog(ExampleServiceImpl.class);

	@Override
	public List<Person> getListPeople() {
		List<Person> people = new ArrayList<Person>();
		people.add(new Person("Sam", 25));
		people.add(new Person("Paco", 30));
		people.add(new Person("Eva", 31));
		people.add(new Person("Paula", 33));
		LOG.info("HELLO FROM SERVICE");
		return people;

	}

}
