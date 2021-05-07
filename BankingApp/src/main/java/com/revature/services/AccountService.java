package com.revature.services;

import java.util.List;

import com.revature.models.Account;
import com.revature.repo.AccountRepo;
import com.revature.repo.AccountRepoImpl;

public class AccountService {
	
	 AccountRepo ac=new AccountRepoImpl();
		
		public List<Account> findAll(){
			
			List<Account> list=ac.findAll();
			
			return list;
		}

		public boolean addAccount(Account a) {
			return ac.addAccount(a);
			
		}
		public Account findById(int id) {
			return ac.findById(id);
		}
		
		public boolean updateAccount(Account a) {
			return ac.update(a);
		}

		public boolean deleteAccount(int id) {
			return ac.deleteAccount(id);
		}
		
		
		
		
		
	
	

}
