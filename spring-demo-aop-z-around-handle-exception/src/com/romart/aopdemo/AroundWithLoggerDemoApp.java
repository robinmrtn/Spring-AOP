package com.romart.aopdemo;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.romart.aopdemo.service.TrafficFortuneService;

public class AroundWithLoggerDemoApp {

	private static Logger myLogger = Logger.getLogger(AroundWithLoggerDemoApp.class.getName());

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		// AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
		TrafficFortuneService trafficFortuneService = context.getBean("trafficFortuneService",
				TrafficFortuneService.class);

		myLogger.info("\nMain Program: AroundDemoApp");

		myLogger.info("Calling getFortune()");

		String data = trafficFortuneService.getFortune();

		myLogger.info("\nMy Fortune is: " + data);

		myLogger.info("Finished");

		context.close();

	}

}
