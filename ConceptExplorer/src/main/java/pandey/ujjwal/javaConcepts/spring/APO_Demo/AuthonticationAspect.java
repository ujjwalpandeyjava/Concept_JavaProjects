package pandey.ujjwal.javaConcepts.spring.APO_Demo;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect

@Component
public class AuthonticationAspect {
	// Pointcut: For a class all method

	@Pointcut("within(demo..*)")
	public void authenticationPointCut() {
		System.out.println("authorizationPointCut");
	}

	@Pointcut("within(demo.ShoppingCart.*)")
	public void authorizationPointCut() {
		System.out.println("authorizationPointCut");
	}

	// If these methods have pointcut "&&/||" available.
	// Replace '||' with '&&' it will not work as authorizationPointCut does not have same pointcut match
	@Before("authenticationPointCut() || authorizationPointCut()")
	public void authenticate() {
		System.out.println("authenticating the request");
	}
}
