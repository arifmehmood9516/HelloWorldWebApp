package com.service;

import javax.ejb.Remote;

import com.qr.repository.entity.Contact;


@Remote
public interface ContactServiceRemote {

	public String addContact(Contact contact);
	public Boolean deleteContact(Contact contact);
}
