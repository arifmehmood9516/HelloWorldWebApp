package com.service;

import javax.ejb.Remote;

import com.qr.repository.entity.Account;


@Remote
public interface AccountServiceRemote {

	public Account loginAccount(Account account);
	public Account addAccount(Account account);
	public Boolean deleteAccount(Account account);
}
