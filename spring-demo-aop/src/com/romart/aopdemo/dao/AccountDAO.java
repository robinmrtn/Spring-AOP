package com.romart.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.romart.aopdemo.Account;

@Component
public class AccountDAO {

	public void addAccount(Account account, boolean vipFlag) {
		System.out.println(getClass() + " Adding an Account");
	}

	public boolean doWork() {

		System.out.println(getClass() + " doWork Method called");
		return false;
	}

}
