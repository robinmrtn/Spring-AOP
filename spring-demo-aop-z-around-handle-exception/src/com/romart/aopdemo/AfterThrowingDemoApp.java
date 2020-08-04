package com.romart.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.romart.aopdemo.dao.AccountDAO;

public class AfterThrowingDemoApp {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);

		List<Account> accounts = null;

		try {
			boolean tripwire = true;
			accounts = accountDAO.findAccounts(tripwire);
		} catch (Exception e) {
			System.out.println("Main Program ... caught exception: " + e);
		}

		System.out.println("\n\nMain Program: AfterThrowingDemo");
		System.out.println("---");

		accounts.forEach(System.out::println);

		context.close();

	}

}
