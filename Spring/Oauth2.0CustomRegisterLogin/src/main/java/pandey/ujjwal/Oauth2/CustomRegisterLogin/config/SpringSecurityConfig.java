package pandey.ujjwal.Oauth2.CustomRegisterLogin.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import pandey.ujjwal.Oauth2.CustomRegisterLogin.service.DefaultUserService;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {

	@Autowired
	private DefaultUserService userDetailsService;

	@Autowired
	AuthenticationSuccessHandler successHandler;

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
		auth.setUserDetailsService(userDetailsService);
		auth.setPasswordEncoder(passwordEncoder());
		return auth;
	}

	public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
			throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		return http.csrf(c -> c.disable()).authorizeHttpRequests(a -> {
			a.requestMatchers("/registration/**", "/login/**").permitAll();
			a.anyRequest().authenticated();
		}).formLogin(formLogin -> {
			formLogin.loginPage("/login").successHandler(successHandler);
		}).csrf(c -> c.disable()).logout(l -> {
			l.logoutUrl("/logout");
			l.logoutSuccessUrl("/login");
		}).oauth2Login(o2 -> {
			o2.loginPage("/login");
			o2.successHandler(successHandler);
		}).build();
	}

}
