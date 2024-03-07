package demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class AppEntryMain {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
		var shopCart = context.getBean(ShoppingCart.class);
		shopCart.checkout("10 people");
		System.out.println("_______");
		shopCart.quantity();
		((AbstractApplicationContext) context).close();
	}
}
