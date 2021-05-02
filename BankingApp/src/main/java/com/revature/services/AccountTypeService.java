package com.revature.services;

import java.util.List;

import com.revature.models.AccountType;
import com.revature.repo.AccountTypeRepoImpl;
import com.revature.repo.ReadRepo;



public class AccountTypeService {
	
	ReadRepo<AccountType> readRepo=new AccountTypeRepoImpl();
	
	public List<AccountType> findAll(){
		
		List<AccountType> list=readRepo.findAll();
		
		return list;
	}
	
	
	public AccountType findById(int Id) {
		return  readRepo.findById(Id);
	}
}
