package pandey.ujjwal.Oauth2.CustomRegisterLogin.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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

import pandey.ujjwal.Oauth2.CustomRegisterLogin.enums.UserRole;
import pandey.ujjwal.Oauth2.CustomRegisterLogin.service.DefaultUserService;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {

	@Autowired
	private DefaultUserService userDetailsService;

	@Autowired
	private AuthenticationSuccessHandler authoniticationSuccessHandler;

	@Autowired
	@Qualifier("BCryptPasswordEncoder_Strength_11")
	private BCryptPasswordEncoder bCryptPasswordEncoder_Strength_11;

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
		auth.setUserDetailsService(userDetailsService);
		auth.setPasswordEncoder(bCryptPasswordEncoder_Strength_11);
		return auth;
	}

	public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
			throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
	}

	// User are stored in DB and that data is added to UserDeatilsService after
	// extraction from DB for authenticate via loadByUserName().
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		return http.csrf(c -> c.disable())
//				.requestMatchers(MvcRequestMatcher.INSTANCE).servletPath("/")
				.authorizeHttpRequests(a -> a.requestMatchers("/").permitAll())
				// Testing above two lines to let WAR working fine.
				.authorizeHttpRequests(a -> {
//					requestMatchers(MvcRequestMatcher.INSTANCE)
//					a.requestMatchers(MvcRequestMatcher.Builder.matches);
					a.requestMatchers("/registration/**", "/login/**").permitAll();
					a.requestMatchers("/superAdmin/**").hasAnyRole(UserRole.SUPER_ADMIN.getValue());
					a.requestMatchers("/admin/**").hasAnyRole(UserRole.SUPER_ADMIN.getValue(),
							UserRole.ADMIN.getValue());
					a.requestMatchers("/user/**").hasAnyRole(UserRole.SUPER_ADMIN.getValue(), UserRole.ADMIN.getValue(),
							UserRole.USER.getValue());
					a.anyRequest().authenticated();
				}).csrf(c -> c.disable()).logout(logoutWork -> {
					logoutWork.logoutUrl("/logout");
					logoutWork.logoutSuccessUrl("/login");
				}).formLogin(formLogin -> {
					formLogin.loginPage("/login").successHandler(authoniticationSuccessHandler);
				}).oauth2Login(o2 -> {
					o2.loginPage("/login");
					o2.successHandler(authoniticationSuccessHandler);
				}).build();
	}
}
