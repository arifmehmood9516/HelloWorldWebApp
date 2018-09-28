package com.service;

import java.util.List;

import javax.ejb.Stateless;

import com.qr.repository.dao.AlertProfileDao;
import com.qr.repository.dao.ContactDao;
import com.qr.repository.entity.AlertProfile;
import com.qr.repository.entity.Contact;

@Stateless
public class ContactService implements ContactServiceRemote {

	public ContactService() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String addContact(Contact contact) {
		ContactDao contactdao=new ContactDao();
		contact.getAddress().setContact(contact);
		contactdao.addContact(contact);
		List<AlertProfile> list=AlertProfileDao.matchProfile(contact.getAddress(), contact.getAccountId());
		String profiles="";
		int index=0;
		while(list.size()>index)
		{
			profiles=profiles+list.get(index).getName();
			index++;
			profiles=((list.size()>index)?profiles+", ":profiles+".");
		}
		return profiles;
	}

	@Override
	public Boolean deleteContact(Contact contact) {
		ContactDao contactdao=new ContactDao();
		return contactdao.deleteContact(contact.getId());
	}

	
}
