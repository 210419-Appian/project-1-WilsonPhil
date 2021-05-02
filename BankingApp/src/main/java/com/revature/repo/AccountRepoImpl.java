package com.revature.repo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Account;
import com.revature.models.AccountStatus;
import com.revature.models.AccountType;
import com.revature.util.ConnectionUtil;

public class AccountRepoImpl implements CrudRepo<Account>{
	private static ReadRepo<AccountStatus> readstatus=new AccountStatusRepoImpl();
	private static ReadRepo<AccountType> readtype=new AccountTypeRepoImpl();
	
	
	@Override
	public List<Account> findAll() {
		try(Connection con=ConnectionUtil.getConnection()){
			String sql="SELECT * FROM Account;";
			Statement statement=con.createStatement();
			ResultSet result=statement.executeQuery(sql);
			
			List<Account> list=new ArrayList<>();
			
			while(result.next()) {
				Account a= new Account(
				result.getInt("accountId"),
				result.getDouble("balance"),
				readstatus.findById(result.getInt("statusId")),
				readtype.findById(result.getInt("typeId"))
						
				);
				list.add(a);
			}
			return list;
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		return null;
	}

	@Override
	public void insert(Account newObj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Account findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(Account updateObj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteById(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
