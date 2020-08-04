package com.romart.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyCloudAspect {

	@Before("com.romart.aopdemo.aspect.AopExpressions.forDaoPackageExcludingGetandSet()")
	public void logToCloud() {
		System.out.println("\n--->>> Logging to Cloud");
	}

}
