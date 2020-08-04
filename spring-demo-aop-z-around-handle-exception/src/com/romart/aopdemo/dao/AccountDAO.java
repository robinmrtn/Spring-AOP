package com.romart.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.romart.aopdemo.Account;

@Component
public class AccountDAO {

	private String name;
	private String serviceCode;

	public void addAccount(Account account, boolean vipFlag) {
		System.out.println(getClass() + " Adding an Account");
	}

	public boolean doWork() {

		System.out.println(getClass() + " doWork Method called");
		return false;
	}

	public String getName() {
		System.out.println("in method getName");
		return name;
	}

	public void setName(String name) {
		System.out.println("in method setName");
		this.name = name;
	}

	public String getServiceCode() {
		System.out.println("in method getServiceCode");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
		System.out.println("in method setServiceCode");
	}

	public List<Account> findAccounts(boolean tripwire) {

		if (tripwire) {
			throw new RuntimeException("No soup");
		}

		List<Account> list = new ArrayList<>();

		list.add(new Account("John", "Silver"));
		list.add(new Account("Luka", "Gold"));
		list.add(new Account("Pete", "Platinum"));

		return list;
	}

}
