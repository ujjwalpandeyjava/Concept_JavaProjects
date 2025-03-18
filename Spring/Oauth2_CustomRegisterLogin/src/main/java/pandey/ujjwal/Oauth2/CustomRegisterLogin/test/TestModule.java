package pandey.ujjwal.Oauth2.CustomRegisterLogin.test;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import pandey.ujjwal.Oauth2.CustomRegisterLogin.config.BeanInit;
import pandey.ujjwal.Oauth2.CustomRegisterLogin.enums.UserPrivileges;
import pandey.ujjwal.Oauth2.CustomRegisterLogin.enums.UserRole;

public class TestModule {

	public static void main(String[] args) {

//		System.out.println(new BCryptPasswordEncoder(11).encode("123"));
//		System.out.println(new BCryptPasswordEncoder(11).encode(""));
//		System.out.println(new BCryptPasswordEncoder(11).encode(""));
//		System.out.println(UserPrivileges.READ);
//		System.out.println(UserPrivileges.READ.getValue());
//		System.out.println(UserRole.ADMIN);
//		System.out.println(UserRole.ADMIN.getValue());

		String encode = BeanInit.passwordEncoder11().encode("123");
		System.out.println(BeanInit.passwordEncoder11().matches("123", encode));

	}

}
