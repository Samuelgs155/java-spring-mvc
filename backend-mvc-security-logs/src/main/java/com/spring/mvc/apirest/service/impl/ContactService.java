package com.spring.mvc.apirest.service.impl;

import java.util.List;

import com.spring.mvc.apirest.entity.Contact;
import com.spring.mvc.apirest.model.ContactModel;

public interface ContactService {

	public abstract ContactModel addContact(ContactModel contactModel);
	
	public abstract List<ContactModel> listAllContacts();
	
	public abstract Contact findContactById(int id);
	
	public abstract void removeContact(int id);
	
	public abstract ContactModel findContactByIdModel(int id);

}
