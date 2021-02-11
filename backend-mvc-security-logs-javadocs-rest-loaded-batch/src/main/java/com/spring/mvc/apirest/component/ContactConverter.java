package com.spring.mvc.apirest.component;

import org.springframework.stereotype.Component;

import com.spring.mvc.apirest.entity.Contact;
import com.spring.mvc.apirest.model.ContactModel;

// TODO: Auto-generated Javadoc
/**
 * The Class ContactConverter.
 */
@Component("contactConverter")
public class ContactConverter {
	
	/**
	 * Contact model to contact.
	 *
	 * @param contactModel the contact model
	 * @return the contact
	 */
	public Contact contactModelToContact(ContactModel contactModel) {
		Contact contact = new Contact();
		contact.setId(contactModel.getId());
		contact.setFirstname(contactModel.getFirstname());
		contact.setLastname(contactModel.getLastname());
		contact.setTelephone(contactModel.getTelephone());
		contact.setCity(contactModel.getCity());
		return contact;
	}
	
	/**
	 * Contact tocontact model.
	 *
	 * @param contact the contact
	 * @return the contact model
	 */
	public ContactModel contactTocontactModel(Contact contact) {
		ContactModel contactModel = new ContactModel();		
		contactModel.setId(contact.getId());
		contactModel.setFirstname(contact.getFirstname());
		contactModel.setLastname(contact.getLastname());
		contactModel.setTelephone(contact.getTelephone());
		contactModel.setCity(contact.getCity());
		return contactModel;
	}
	
	/**
	 * Contact tocontact model 2.
	 *
	 * @param contact the contact
	 * @return the contact model
	 */
	public ContactModel contactTocontactModel2(Contact contact) {
		ContactModel contactModel = new ContactModel();
		contactModel.setId(contact.getId());
		contactModel.setFirstname(contact.getFirstname());
		contactModel.setLastname(contact.getLastname());
		contactModel.setTelephone(contact.getTelephone());
		contactModel.setCity(contact.getCity());
		return contactModel;
	}
	

}
