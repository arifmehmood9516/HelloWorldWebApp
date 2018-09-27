package com.service;

import javax.ejb.Stateless;

import com.qr.repository.dao.AccountDao;
import com.qr.repository.entity.Account;

@Stateless
public class AccountService implements AccountServiceRemote {

	public AccountService() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Account addAccount(Account account) {
		AccountDao accountdao=new AccountDao();
		accountdao.addAccount(account);
		return account;
	}

	@Override
	public Boolean deleteAccount(Account account) {
		AccountDao accountdao=new AccountDao();
		return accountdao.deleteAccount(account.getId());
	}

	
}
