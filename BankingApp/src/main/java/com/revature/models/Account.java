package com.revature.models;

import java.io.Serializable;

public class Account implements Serializable{
	
	private static final long serialVersionUID = 1L;
	   
	
	private int accountId;//primary key
	private double balance;//not null
	private AccountStatus status;
	private AccountType type;
	
	
	public Account() {
		super();
	}


	public Account(int accountId, double balance) {
		super();
		this.accountId = accountId;
		this.balance = balance;
	}


	public Account(int accountId, double balance, AccountStatus status) {
		this(accountId,balance);
		this.status = status;
	}


	public Account(int accountId, double balance, AccountStatus status, AccountType type) {
		this(accountId,balance,status);
		this.type = type;
	}


	public int getAccountId() {
		return accountId;
	}


	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}


	public double getBalance() {
		return balance;
	}


	public void setBalance(double balance) {
		this.balance = balance;
	}


	public AccountStatus getStatus() {
		return status;
	}


	public void setStatus(AccountStatus status) {
		this.status = status;
	}


	public AccountType getType() {
		return type;
	}


	public void setType(AccountType type) {
		this.type = type;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + accountId;
		long temp;
		temp = Double.doubleToLongBits(balance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (accountId != other.accountId)
			return false;
		if (Double.doubleToLongBits(balance) != Double.doubleToLongBits(other.balance))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", balance=" + balance + ", status=" + status + ", type=" + type
				+ "]";
	}
	
	
	
	
	
	
	
	
	

}
