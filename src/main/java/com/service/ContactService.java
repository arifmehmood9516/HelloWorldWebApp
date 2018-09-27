package com.service;

import javax.ejb.Stateless;

import com.qr.repository.dao.ContactDao;
import com.qr.repository.entity.Contact;

@Stateless
public class ContactService implements ContactServiceRemote {

	public ContactService() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Contact addContact(Contact contact) {
		ContactDao contactdao=new ContactDao();
		contactdao.addContact(contact);
		return contact;
	}

	@Override
	public Boolean deleteContact(Contact contact) {
		ContactDao contactdao=new ContactDao();
		return contactdao.deleteContact(contact.getId());
	}

	
}
