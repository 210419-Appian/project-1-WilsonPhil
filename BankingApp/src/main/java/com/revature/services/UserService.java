package com.revature.services;

import java.util.List;

import com.revature.models.User;
import com.revature.repo.UserRepo;
import com.revature.repo.UserRepoImpl;



public class UserService {
	
	 UserRepo ur=new UserRepoImpl();
		
		public List<User> findAll(){
			
			List<User> list=ur.findAll();
			
			return list;
		}
		
		public User findById(int id) {
			return ur.findById(id);
			
		}
		public boolean updateUser(User u) {
			return ur.update(u);
		}
		
		

}
