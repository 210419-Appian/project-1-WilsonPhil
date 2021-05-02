package com.revature.services;

import java.util.List;

import com.revature.models.User;
import com.revature.repo.CrudRepo;
import com.revature.repo.UserRepoImpl;



public class UserService {
	
	 CrudRepo<User> crudRepo=new UserRepoImpl();
		
		public List<User> findAll(){
			
			List<User> list=crudRepo.findAll();
			
			return list;
		}

}
