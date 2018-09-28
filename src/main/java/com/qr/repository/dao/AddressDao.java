package com.qr.repository.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;

import com.qr.repository.entity.Account;
import com.qr.repository.entity.Address;
import com.qr.repository.entity.AlertProfile;
import com.qr.repository.entity.Contact;
import com.qr.repository.factory.QrSessionFactory;

@SuppressWarnings("deprecation")
public class AddressDao {

	@SuppressWarnings({ "deprecation", "rawtypes", "unchecked" })
	public List<Address> getAll(int contactId) {
		
		List<Address> address=null;
		Session session = QrSessionFactory.startTransaction();
		String sql;
		if(contactId!=0){
			 sql= "SELECT * FROM address where ID="+contactId;
			}
		else{
			sql = "SELECT * FROM contact";
			}
		
		SQLQuery query = session.createSQLQuery(sql);
		query.addEntity(Address.class);
		address = query.list();
		QrSessionFactory.endTransaction(session);
		return address;
		}
		
		public AlertProfile addAddress(Address address)
		{
			AlertProfile alertprofile=new AlertProfile();
			try{
				Session session = QrSessionFactory.startTransaction();
				int i=address.getId();
				Contact contact=session.get(Contact.class, i);
				address.setContact(contact);
				session.save(address);
				Account account= contact.getAccount();
				alertprofile=(AlertProfile) AlertProfileDao.matchProfile(address,account.getId());
				QrSessionFactory.endTransaction(session);
			}catch (Exception e) {
				e.printStackTrace();
				return null;
			}
			return alertprofile;
		}
		
	
		public Boolean deleteAddress( int contactId)
		{
			try {
				Session session = QrSessionFactory.startTransaction();
				Query q = session.createQuery("DELETE FROM " + Address.class.getName() + " WHERE ID = " + contactId);
				q.executeUpdate();
				QrSessionFactory.endTransaction(session);
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
			return true;
		}

		public AlertProfile updateAddress(Address address){
			AlertProfile alertprofile=new AlertProfile();
			try {
				Session session = QrSessionFactory.startTransaction();
				session.evict(address);
				session.update(address);
				alertprofile=(AlertProfile) AlertProfileDao.matchProfile(address,address.getContact().getAccount().getId());
				session.flush();
				session.clear();
				QrSessionFactory.endTransaction(session);
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
			return alertprofile;
		}
	
	
}
