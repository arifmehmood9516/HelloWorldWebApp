package com.qr.repository.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.qr.repository.entity.Account;
import com.qr.repository.entity.Contact;
import com.qr.repository.factory.QrSessionFactory;

@SuppressWarnings({ "deprecation", "unused" })
public class ContactDao {

	@SuppressWarnings({ "unchecked" })
	public List<Contact> getAll(int accountId) {
		
	List<Contact> contacts=null;
	Session session = QrSessionFactory.startTransaction();
	String sql;
	if(accountId!=0){
		 sql= "SELECT * FROM contact where ACCOUNT_ID="+accountId;
		}
	else{
		sql = "SELECT * FROM contact";
		}
	
	SQLQuery query = session.createSQLQuery(sql);
	query.addEntity(Contact.class);
	contacts = query.list();
	QrSessionFactory.endTransaction(session);
	return contacts;
	}
	
	public Contact addContact(Contact contact)
	{
		try{
			Session session = QrSessionFactory.startTransaction();
			 Criteria criteria = session.createCriteria(Account.class)
	                    .add(Restrictions.eq("id", contact.getId()));
			 Object result = criteria.uniqueResult();
			 Account account=(Account) result;
			contact.setAccount(account);
			//account.getContacts().add(contact);
			session.save(contact);
			QrSessionFactory.endTransaction(session);
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return contact;
		
	}

	public Boolean deleteContact(int contactId)
	{
		try {
			Session session = QrSessionFactory.startTransaction();
			Contact contact = (Contact) session.get(Contact.class, contactId);
            session.delete(contact);
			QrSessionFactory.endTransaction(session);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public Boolean updateContact(Contact contact){
		try {
			Session session = QrSessionFactory.startTransaction();
			session.evict(contact);
			session.update(contact);
			session.flush();
			session.clear();
			QrSessionFactory.endTransaction(session);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

}

