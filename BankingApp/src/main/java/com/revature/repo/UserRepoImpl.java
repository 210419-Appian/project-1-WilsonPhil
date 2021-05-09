package com.revature.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Account;
import com.revature.models.User;
import com.revature.util.ConnectionUtil;

public class UserRepoImpl implements UserRepo{
	
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
	public User findById(int id) {
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "SELECT * FROM Users WHERE userId = " + id + ";";

			Statement statement = conn.createStatement();

			ResultSet result = statement.executeQuery(sql);

			User u = null;

			while (result.next()) {
				u = new User(
						result.getInt("userId"),
						result.getString("username"),
						result.getString("password"),
						result.getString("firstName"),
						result.getString("lastName"),
						result.getString("email"),
						rolerepo.findRoleById(result.getInt("roleId"))
				
						);
				return u;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean update(User u) {
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "UPDATE Users " 
					+ "Set username = ?," 
					+ "password = ?,"
					+ "firstName = ?,"
					+ "lastName = ?," 
					+ "email = ?," 
					+ "roleId = ?" 
					+ "Where userId = ?;";

			PreparedStatement statement = conn.prepareStatement(sql);

			int index = 0; // inputs for sql statement from paremeter
			
			statement.setString(++index, u.getUsername());
			statement.setString(++index, u.getPassword());
			statement.setString(++index, u.getFirstName());
			statement.setString(++index, u.getLastNmae());
			statement.setString(++index, u.getEmail());
			statement.setInt(++index, u.getRole().getRoleId());
			statement.setInt(++index, u.getUserId());
			statement.execute();
			return true;

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean deleteById(int id) {
		// TODO Auto-generated method stub
		return false;
	}



}
