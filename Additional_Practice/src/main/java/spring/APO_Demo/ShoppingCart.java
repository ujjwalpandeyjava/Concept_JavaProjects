package APO_Demo;

import org.springframework.stereotype.Component;

@Component
public class ShoppingCart {
	/*
	 * AOP Works Logging Authentication, Authorization Sanitize the data
	 */
	public String checkout(String passes) {
		System.out.println("Checkout() from ShoppingCart class.");
		return "This is return";
	}

	public String quantity() {
		return "sr";
	}
}
