package com.romart.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpressions {

	@Pointcut("execution(* com.romart.aopdemo.dao.*.*(..))")
	public void forDaoPackage() {
	}

	@Pointcut("execution(* com.romart.aopdemo.dao.*.set*(..))")
	public void forDaoPackageSetter() {
	}

	@Pointcut("execution(* com.romart.aopdemo.dao.*.get*(..))")
	public void forDaoPackageGetter() {
	}

	@Pointcut("forDaoPackage() && !(forDaoPackageSetter() || forDaoPackageGetter())")
	public void forDaoPackageExcludingGetandSet() {
	}

}
