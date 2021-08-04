package example.bank.springboot.basic.aop.example;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @author Rojar Smith
 *
 * @date 2021-08-04
 */
@Aspect
public class MyAspect {

	@Pointcut("execution (* example.bank.springboot.basic.aop.example.UserServiceImpl.printUser(..))")
	public void pointCut() {
	}

	@Before("pointCut() && args(user)")
	public void before(JoinPoint jp, User user) {
		System.out.println("before ....");
	}

	@Around("pointCut()")
	public Object around(ProceedingJoinPoint jp) throws Throwable {
		System.out.println("around before....");
		Object proceed = jp.proceed();
		System.out.println("around after....");
		return proceed;
	}

	@After("pointCut()")
	public void after() {
		System.out.println("after ....");
	}

	@AfterReturning("pointCut()")
	public void afterReturningbefore() {
		System.out.println("afterReturning ....");
	}

	@AfterThrowing("pointCut()")
	public void afterThrowing() {
		System.out.println("afterThrowing ....");
	}

}
