package com.service;

import javax.ejb.Stateless;

import com.qr.repository.dao.AlertProfileDao;
import com.qr.repository.entity.AlertProfile;

@Stateless
public class AlertProfileService implements AlertProfileServiceRemote {

	public AlertProfileService() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public AlertProfile addAlertProfile(AlertProfile alertprofile) {
		AlertProfileDao alertprofiledao= new AlertProfileDao();
		alertprofiledao.addAlertProfile(alertprofile);
		return alertprofile;
	}
	
	
}
