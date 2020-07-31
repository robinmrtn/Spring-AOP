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

		accountDAO.addAccount(account, true);

		membershipDAO.addMember();

		accountDAO.doWork();

		membershipDAO.goToSleep();

		context.close();

	}

}
