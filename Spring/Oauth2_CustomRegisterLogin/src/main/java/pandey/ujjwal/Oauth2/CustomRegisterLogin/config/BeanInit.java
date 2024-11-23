package pandey.ujjwal.Oauth2.CustomRegisterLogin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Component;

import pandey.ujjwal.Oauth2.CustomRegisterLogin.enums.UserRole;

@Component
public class BeanInit {

	@Bean("BCryptPasswordEncoder")
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean("BCryptPasswordEncoder_Strength_11")
	@Primary
	public static BCryptPasswordEncoder passwordEncoder11() {
		return new BCryptPasswordEncoder(11);
	}

	@Bean
	public UserDetailsService hardCodedUsers() {
//		UserDetails superAdmin = org.springframework.security.core.userdetails.User.withUsername("SuperPandey")
		// .password(new
		// BCryptPasswordEncoder(11).encode("123")).roles(UserRoles.SUPER_ADMIN.getValue()).build();
		UserDetails superAdmin = org.springframework.security.core.userdetails.User.withUsername("SuperPandey")
				.password(passwordEncoder11().encode("123")).roles(UserRole.SUPER_ADMIN.getValue()).build();
		UserDetails admin = org.springframework.security.core.userdetails.User.withUsername("AdminPandey")
				.password(new BCryptPasswordEncoder(11).encode("123")).roles(UserRole.ADMIN.getValue()).build();
		UserDetails simple = org.springframework.security.core.userdetails.User.withUsername("SimplePandey")
				.password(new BCryptPasswordEncoder(11).encode("123")).roles(UserRole.USER.getValue()).build();
		return new InMemoryUserDetailsManager(superAdmin, admin, simple);
	}

}
