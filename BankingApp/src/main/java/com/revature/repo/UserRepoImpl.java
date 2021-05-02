package com.revature.repo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Role;
import com.revature.models.User;
import com.revature.util.ConnectionUtil;

public class UserRepoImpl implements CrudRepo<User>{
	
	private static RoleRepo rolerepo=new RoleRepoImpl();
	@Override
	public List<User> findAll() {
		try(Connection con=ConnectionUtil.getConnection()){
			
			String sql="SELECT* FROM Users;";
			Statement statement=con.createStatement();
			ResultSet result=statement.executeQuery(sql);
			
			List<User> list=new ArrayList<>();
			
			while(result.next()) {
				
				User user=new User(
				result.getInt("userId"),
				result.getString("username"),
				result.getString("password"),
				result.getString("firstName"),
				result.getString("lastName"),
				result.getString("email"),
				rolerepo.findRoleById(result.getInt("roleId"))
				);
			
			
				list.add(user);
			}
			return list;
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void insert(User newObj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(User updateObj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteById(int id) {
		// TODO Auto-generated method stub
		return false;
	}



}
