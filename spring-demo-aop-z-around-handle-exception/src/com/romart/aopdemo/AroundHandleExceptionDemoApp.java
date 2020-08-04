package com.romart.aopdemo;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.romart.aopdemo.service.TrafficFortuneService;

public class AroundHandleExceptionDemoApp {

	private static Logger myLogger = Logger.getLogger(AroundHandleExceptionDemoApp.class.getName());

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		// AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
		TrafficFortuneService trafficFortuneService = context.getBean("trafficFortuneService",
				TrafficFortuneService.class);

		myLogger.info("\nMain Program: AroundDemoApp");

		myLogger.info("Calling getFortune()");

		boolean tripwire = true;
		String data = trafficFortuneService.getFortune(tripwire);

		myLogger.info("\nMy Fortune is: " + data);

		myLogger.info("Finished");

		context.close();

	}

}
