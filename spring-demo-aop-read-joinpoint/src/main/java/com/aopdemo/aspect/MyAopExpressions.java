package com.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class MyAopExpressions {

		// Create a pointcut declaration
		@Pointcut("execution(* com.aopdemo.dao.*.*(..))")
		public void forDaoPackage() {}
		
		// Create pointcut for getter methods
		@Pointcut("execution(* com.aopdemo.dao.*.get*(..))")
		public void getter() {}
		
		// Create pointcut for setter methods
		@Pointcut("execution(* com.aopdemo.dao.*.set*(..))")
		public void setter() {}
		
		// Create a pointcut: include package ... exclude getter/setter
		@Pointcut("forDaoPackage() && !(getter() || setter())")
		public void forDaoPackageNoGetterSetter() {}
		
		
}
