package com.revature.repo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Account;
import com.revature.util.ConnectionUtil;

public class AccountRepoImpl implements CrudRepo{

	@Override
	public List<Account> findAll() {
		try(Connection con=ConnectionUtil.getConnection()){
			String sql="SELECT * FROM Account;";
			Statement statement=con.createStatement();
			ResultSet result=statement.executeQuery(sql);
			
			List<Account> list=new ArrayList<>();
			
			while(result.next()) {
				Account a= new Account(
						
						
						
						
						
						);
			}
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		return null;
	}

	@Override
	public void insert(Object newObj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(Object updateObj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteById(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
