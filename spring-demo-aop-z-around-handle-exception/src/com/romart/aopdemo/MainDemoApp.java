package com.romart.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.romart.aopdemo.dao.AccountDAO;
import com.romart.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
		var membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);

		Account account = new Account();
		account.setLevel("Platinum");
		account.setName("Sven");

		accountDAO.addAccount(account, true);

		membershipDAO.addMember();

		accountDAO.setName("foobar");
		accountDAO.setServiceCode("sivler");

		String name = accountDAO.getName();
		String serviceCode = accountDAO.getServiceCode();

		accountDAO.doWork();

		membershipDAO.goToSleep();

		context.close();

	}

}
