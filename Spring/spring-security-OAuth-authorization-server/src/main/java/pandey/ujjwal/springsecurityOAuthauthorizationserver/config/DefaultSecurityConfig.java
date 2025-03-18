package pandey.ujjwal.springsecurityOAuthauthorizationserver.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import pandey.ujjwal.springsecurityOAuthauthorizationserver.service.implementation.CustomAuthenticationProvider;

@EnableWebSecurity
public class DefaultSecurityConfig {

	@Autowired
	private CustomAuthenticationProvider customAuthenticationProvider;

	@Bean
	public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
		// authentication for all requests
		return http.authorizeHttpRequests(authorizeRequests -> authorizeRequests.anyRequest().authenticated())
				.formLogin(Customizer.withDefaults()).build();
	}

	// Hard coded set of example users working fine for formLogin
	@Bean
	public UserDetailsService users() {
		// .roles("ADMIN"), .roles("SIMPLE")
		UserDetails admin = User.withUsername("AdminPandey").password(new BCryptPasswordEncoder(11).encode("123")).build();
		return new InMemoryUserDetailsManager(admin);
	}

	@Bean
	public void bindAuthenticationProvider(AuthenticationManagerBuilder amb) {
		amb.authenticationProvider(customAuthenticationProvider);
	}
}
