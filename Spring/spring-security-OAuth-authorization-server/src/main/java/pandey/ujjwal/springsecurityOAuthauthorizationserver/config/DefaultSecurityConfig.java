package pandey.ujjwal.springsecurityOAuthauthorizationserver.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import pandey.ujjwal.springsecurityOAuthauthorizationserver.service.implementation.CustomAuthenticationProvider;

@EnableWebSecurity
public class DefaultSecurityConfig {

	@Autowired
	private CustomAuthenticationProvider customAuthenticationProvider;

	@Bean
	public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity httpSecurity) throws Exception {
		return httpSecurity.authorizeHttpRequests(authorizeRequests -> authorizeRequests.anyRequest().authenticated())
				.formLogin(Customizer.withDefaults()).build();
	}

	@Bean
	public void bindAuthenticationProvider(AuthenticationManagerBuilder amb) {
		amb.authenticationProvider(customAuthenticationProvider);
	}
}
