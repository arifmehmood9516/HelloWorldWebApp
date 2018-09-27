package com.service;

import javax.ejb.Stateless;

import com.qr.repository.dao.AddressDao;
import com.qr.repository.entity.Address;
import com.qr.repository.entity.AlertProfile;

@Stateless
public class AddressService implements AddressServiceRemote {

	public AddressService() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public AlertProfile addAddress(Address address){
		AddressDao addressdao=new AddressDao();
		AlertProfile alertProfile= addressdao.addAddress(address);
		return alertProfile;
	}

	
}
