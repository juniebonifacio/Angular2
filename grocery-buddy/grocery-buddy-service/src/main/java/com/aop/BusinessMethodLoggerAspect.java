package com.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class BusinessMethodLoggerAspect{
	

	/**
	 * Log method entry.
	 * 
	 * @param joinPoint
	 *            the join point
	 */
	@Before( "execution(* com.business.impl.*Report*+.findAll*(..))" )
	public void logMethodEntry(JoinPoint joinPoint) 
	{
		 StringBuffer logMessageStringBuffer = new StringBuffer();
		 logMessageStringBuffer.append("<<< Entering Method : ");
		 logMessageStringBuffer.append(joinPoint.getTarget().getClass().getName());
		 logMessageStringBuffer.append(".");
		 logMessageStringBuffer.append(joinPoint.getSignature().getName() + " >>>");
		 		 
		 System.out.println(logMessageStringBuffer.toString());
	}

	/**
	 * Log normal method exit.
	 * 
	 * @param joinPoint
	 *            the join point
	 */
	@After( "execution(* com.business.impl.*Report*+.findAllReports*(..))" )
	public void logNormalMethodExit(JoinPoint joinPoint) 
	{
		 StringBuffer logMessageStringBuffer = new StringBuffer();
		 logMessageStringBuffer.append("<<< Exiting Method : ");
		 logMessageStringBuffer.append(joinPoint.getTarget().getClass().getName());
		 logMessageStringBuffer.append(".");
		 logMessageStringBuffer.append(joinPoint.getSignature().getName() + " >>>");
		 
		 System.out.println(logMessageStringBuffer.toString());
	}
	

}
