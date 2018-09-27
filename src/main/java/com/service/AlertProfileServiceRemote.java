package com.service;

import javax.ejb.Remote;

import com.qr.repository.entity.AlertProfile;


@Remote
public interface AlertProfileServiceRemote {

	public AlertProfile addAlertProfile(AlertProfile alertprofile);

	
}
