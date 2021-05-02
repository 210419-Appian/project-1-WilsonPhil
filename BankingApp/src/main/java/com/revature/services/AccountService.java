package com.revature.services;

import java.util.List;

import com.revature.models.Account;
import com.revature.repo.AccountRepoImpl;
import com.revature.repo.CrudRepo;



public class AccountService {
	
	 CrudRepo<Account> ac=new AccountRepoImpl();
		
		public List<Account> findAll(){
			
			List<Account> list=ac.findAll();
			
			return list;
		}
		
		
		
	
	

}
