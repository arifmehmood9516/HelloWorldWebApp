package com.service;

import javax.ejb.Remote;

import com.qr.repository.entity.Address;
import com.qr.repository.entity.AlertProfile;


@Remote
public interface AddressServiceRemote {

	public AlertProfile addAddress(Address address);

	
}
