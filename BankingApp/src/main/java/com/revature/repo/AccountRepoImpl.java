package com.revature.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Account;
import com.revature.models.AccountStatus;
import com.revature.models.AccountType;
import com.revature.util.ConnectionUtil;

public class AccountRepoImpl implements AccountRepo{
	private static AccountStatusRepo readstatus=new AccountStatusRepoImpl();
	private static AccountTypeRepo  readtype=new AccountTypeRepoImpl();
	
	
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
	public boolean addAccount(Account account) {
		try (Connection conn = ConnectionUtil.getConnection()) {

			//There is no chance for sql injection with just an integer so this is safe. 
			String sql = "INSERT INTO Account (accountId, balance, statusId, typeId)"
					+ "	VALUES (?, ?, ?, ?);";

			
			PreparedStatement statement = conn.prepareStatement(sql);
			
			int index = 0;
			statement.setInt(++index, account.getAccountId());
			statement.setDouble(++index, account.getBalance());
			if(account.getStatus()!=null) {
				statement.setInt(++index, account.getStatus().getStatusId());
			}else {
			statement.setString(++index,null);
			}
			if(account.getType()!=null) {
				statement.setInt(++index, account.getType().getTypeId());
			}else {
			statement.setString(++index,null);
			}
			
			
			statement.execute();
			return true;


		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
		
	}

	@Override
	public Account findById(int id) {
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "SELECT * FROM Account WHERE accountId = " + id + ";";

			Statement statement = conn.createStatement();

			ResultSet result = statement.executeQuery(sql);

			Account a = null;

			while (result.next()) {
				a = new Account(result.getInt("accountId"),
						result.getDouble("balance"),
						readstatus.findById(result.getInt("statusId")),
						readtype.findById(result.getInt("typeId"))
						);
				return a;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean update(Account account) {
		try (Connection conn = ConnectionUtil.getConnection()) {

			// There is no chance for sql injection with just an integer so this is safe.
			String sql = "UPDATE Account " + "balance = ?, " + "statusId = ?, "
					+ "typeId = ?, " + "WHERE accountId = ?; ";

			PreparedStatement statement = conn.prepareStatement(sql);

			int index = 0;
			statement.setDouble(++index, account.getBalance());
			
			if (account.getStatus() != null) {
				statement.setInt(++index, account.getStatus().getStatusId());
			} else {
				statement.setString(++index, null);
			}
			if (account.getType() != null) {
				statement.setInt(++index, account.getType().getTypeId());
			} else {
				statement.setString(++index, null);
			}


			statement.setInt(++index, account.getAccountId());

			statement.execute();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteAccount(int id) {
		try(Connection conn=ConnectionUtil.getConnection()){
			String sql="DELETE FROM Account WHERE accountId="+id+";";
			
			Statement statement=conn.createStatement();
			statement.execute(sql);
			return true;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	@Override
	public Account findAccountByStatus(int id) {
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "SELECT * FROM Account WHERE statusId = " + id + ";";

			Statement statement = conn.createStatement();

			ResultSet result = statement.executeQuery(sql);

			Account a = null;

			while (result.next()) {
				a = new Account(result.getInt("accountId"),
						result.getDouble("balance"),
						readstatus.findById(result.getInt("statusId")),
						readtype.findById(result.getInt("typeId"))
						);
				return a;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
