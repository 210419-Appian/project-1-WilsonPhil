package com.revature.repo;

import java.util.List;

import com.revature.models.Account;

public interface AccountRepo {
	
	public List<Account>findAll();
	Account findById(int id);
	boolean update(Account Account);
	boolean deleteAccount(int id);
	public boolean addAccount(Account a);
	Account findAccountByStatus(int id);

}
