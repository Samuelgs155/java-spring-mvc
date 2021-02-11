package com.spring.mvc.apirest.service.impl;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.mvc.apirest.component.ContactConverter;
import com.spring.mvc.apirest.entity.Contact;
import com.spring.mvc.apirest.model.ContactModel;
import com.spring.mvc.apirest.repository.ContactRepository;

@Service("contactServiceImpl")
public class ContactServiceImpl implements ContactService{
	
	@Autowired
	@Qualifier("contactRepository")
	private ContactRepository contactRepository;
	
	@Autowired
	@Qualifier("contactConverter")
	private ContactConverter contactConverter;

	@Override
	@Transactional
	// @PreAuthorize("permitAll()")
	public ContactModel addContact(ContactModel contactModel) {		
		Contact contact = contactRepository.save(contactConverter.contactModelToContact(contactModel));
		return contactConverter.contactTocontactModel(contact);
	}

	@Override
	@Transactional(readOnly=true)
	public List<ContactModel> listAllContacts() {
		List<Contact> list = contactRepository.findAll();
		List<ContactModel> listContactModel = new ArrayList<>();
		for(Contact contact: list) {
			listContactModel.add(contactConverter.contactTocontactModel(contact));
		}
		return listContactModel;
	}

	@Override
	public Contact findContactById(int id) {
		return contactRepository.findById(id);
	}
	
	public ContactModel findContactByIdModel(int id) {
		return contactConverter.contactTocontactModel2(findContactById(id));
	}

	@Override
	public void removeContact(int id) {
		Contact contact = findContactById(id);
		if(contact != null) {
			contactRepository.delete(contact);
		}
	}

}
