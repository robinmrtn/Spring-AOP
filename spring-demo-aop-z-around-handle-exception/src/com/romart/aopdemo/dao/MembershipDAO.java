package com.romart.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

	public void addMember() {
		System.out.println(getClass() + " Adding a Membership account");
	}

	public void goToSleep() {

		System.out.println(getClass() + " called Method goToSleep");
	}
}
