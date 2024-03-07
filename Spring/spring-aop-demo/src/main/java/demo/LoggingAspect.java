package demo;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	// Advice: For a mehtod

	@Before("execution(* *.*.*(..))")
	public void beforeAnyLogger() {
		System.out.println("Global before logger");
	}

	@Before("execution(* demo.ShoppingCart.checkout(..))")
	public void beforeLogger(JoinPoint jpObj) {
		System.out.println("Before logger");
		System.out.println("Signature: " + jpObj.getSignature());
		System.out.println("Args: " + Arrays.toString(jpObj.getArgs()));
	}

	@After("execution(* demo.ShoppingCart.checkout(..))")
	public void afterLogger() {
		System.out.println("After logger");
	}

	@Pointcut("execution(* demo.ShoppingCart.quantity(..))")
	public void afterReturningPointCut() {

	}

	@AfterReturning(pointcut = "afterReturningPointCut()", returning = "retVal")
	public void afterReturningLogger(String retVal) {
		System.out.println("After Returning pointcut Logger, val: " + retVal);
	}

	// OR
	/*
	 * @AfterReturning("execution(* demo.ShoppingCart.checkout(..))") public void
	 * afterReturningLogger() { System.out.println("After Returning Logger"); }
	 */

	@AfterThrowing("execution(* demo.ShoppingCart.checkout(..))")
	public void afterThrowingLogger() {
		System.out.println("After Throwing Logger");
	}

	// Uncomment this and only this will run
	/*
	 * @Around("execution(* demo.ShoppingCart.checkout(..))") public void
	 * aroundLogger() { System.out.println("Around logger"); }
	 */

}
