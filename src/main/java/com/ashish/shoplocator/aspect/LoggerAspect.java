package com.ashish.shoplocator.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggerAspect {
	
	private static final Logger logger = LoggerFactory.getLogger(LoggerAspect.class);
	
	@Pointcut("execution(public * com.ashish.shoplocator.controller.*.*(..))")
	public void controllerPublicMethods(){}
	
	@Pointcut("execution(public * com.ashish.shoplocator.service.impl.*.*(..))")
	public void servicePublicMethods(){}
	
	@Pointcut("execution(public * com.ashish.shoplocator.dao.impl.*.*(..))")
	public void repositoryPublicMethods(){}

	@Around("controllerPublicMethods()")
    public Object logController(ProceedingJoinPoint pjp) throws Throwable {
		logger.info("Entry : Controller : " + pjp.getSignature());
		Object retVal = pjp.proceed();
		logger.info("Exit : Controller : " + pjp.getSignature());
		return retVal;
    }
	
	@Around("servicePublicMethods()")
    public Object logService(ProceedingJoinPoint pjp) throws Throwable {
		logger.info("Entry : Service : " + pjp.getSignature());
		Object retVal = pjp.proceed();
    	logger.info("Exit : Service : " + pjp.getSignature());
    	return retVal;
    }
	
	@Around("repositoryPublicMethods()")
    public Object logRepository(ProceedingJoinPoint pjp) throws Throwable {
		logger.info("Entry : Repository : " + pjp.getSignature());
		Object retVal = pjp.proceed();
		logger.info("Exit : Repository : " + pjp.getSignature());
		return retVal;
    }
	
}
