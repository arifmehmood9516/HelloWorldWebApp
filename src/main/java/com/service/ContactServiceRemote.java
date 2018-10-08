package com.service;

import java.util.List;

import javax.ejb.Remote;

import com.qr.repository.entity.Contact;


@Remote
public interface ContactServiceRemote {

	public String addContact(Contact contact);
	public String updateContact(Contact contact);
	public List<Contact> getContacts(int accountId);
	public Boolean deleteContact(Contact contact);
}
