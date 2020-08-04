package com.romart.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.romart.aopdemo.service.TrafficFortuneService;

public class AroundDemoApp {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		// AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
		TrafficFortuneService trafficFortuneService = context.getBean("trafficFortuneService",
				TrafficFortuneService.class);

		System.out.println("\nMain Program: AroundDemoApp");

		System.out.println("Calling getFortune()");

		String data = trafficFortuneService.getFortune();

		System.out.println("\nMy Fortune is: " + data);

		System.out.println("Finished");

		context.close();

	}

}
