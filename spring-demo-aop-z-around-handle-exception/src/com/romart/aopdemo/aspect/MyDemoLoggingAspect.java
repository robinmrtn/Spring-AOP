package com.romart.aopdemo.aspect;

import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.romart.aopdemo.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

	private Logger myLogger = Logger.getLogger(getClass().getName());

	@Around("execution(* com.romart.aopdemo.service.*.getFortune(..))")
	public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

		String method = proceedingJoinPoint.getSignature().toShortString();

		myLogger.info("\nExecuting @Around on method" + method);

		long begin = System.currentTimeMillis();

		Object result = null;

		try {
			result = proceedingJoinPoint.proceed();
		} catch (RuntimeException e) {

			myLogger.warning(e.getMessage());

			throw e;

		}

		long end = System.currentTimeMillis();

		long duration = end - begin;

		myLogger.info("\nExecution took " + duration + "ms.");

		return result;
	}

	@After("execution(* com.romart.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountsAdvice(JoinPoint joinPoint) {

		String method = joinPoint.getSignature().toShortString();

		myLogger.info("\nExecuting @After (finally) on method" + method);

	}

	@AfterThrowing(pointcut = "execution(* com.romart.aopdemo.dao.AccountDAO.findAccounts(..))", throwing = "exc")
	public void afterTrhwoingFindAccountAdvice(JoinPoint joinPoint, Throwable exc) {

		String method = joinPoint.getSignature().toShortString();

		myLogger.info("\nExecuting @AfterThrowing on method" + method);

		myLogger.info("\nThe exception is: " + exc);

	}

	@AfterReturning(pointcut = "execution(* com.romart.aopdemo.dao.AccountDAO.findAccounts(..))", returning = "result")
	public void afterRetruningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result) {

		String method = joinPoint.getSignature().toShortString();

		myLogger.info("\nExecuting @AfterReturning on method" + method);

		myLogger.info("\nresult is: " + result);

		convertAccountNamesToUpperCase(result);

		myLogger.info("\nresult is: " + result);
	}

	private void convertAccountNamesToUpperCase(List<Account> result) {

		for (Account account : result) {
			account.setName(account.getName().toUpperCase());
		}
	}

	@Before("com.romart.aopdemo.aspect.AopExpressions.forDaoPackageExcludingGetandSet()")
	public void beforeAddAccountAdvice(JoinPoint joinpoint) {

		myLogger.info("\n--->>> Eexecuting @Before advice on method");

		MethodSignature methodSig = (MethodSignature) joinpoint.getSignature();

		myLogger.info("Method: " + methodSig);

		Object[] args = joinpoint.getArgs();

		// Arrays.stream(args).forEach(System.out::println);

		for (Object obj : args) {
			myLogger.info(obj.toString());

			if (obj instanceof Account) {

				Account account = (Account) obj;

				myLogger.info("Account name: " + account.getName());
				myLogger.info("Account level: " + account.getLevel());

			}
		}

	}

}
