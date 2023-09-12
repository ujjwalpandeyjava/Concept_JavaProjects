package pandey.ujjwal.springsecurityclient.config;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import pandey.ujjwal.springsecurityclient.entity.User;
import pandey.ujjwal.springsecurityclient.event.RegistrationCompleteEvent;

@Configuration
@ComponentScan(basePackages = "pandey.ujjwal.springsecurityclient.config")
@EnableWebSecurity
public class WebSecurityConfig {

	public static final String[] WHITE_LIST_URLs= { "/appName", "/appName/", "/appName/register",
			"/appName/register/verifyRegistration" };

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(11);
	}

	@Bean
	public User getUser() {
		return new User();
	}

	@Bean
	@Scope(value = "prototype")
	public ApplicationEvent getRegistrationCompleteEvent() {
		return new RegistrationCompleteEvent(getUser());
	}

	/*@Bean
	CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration myCorsConfiguration = new CorsConfiguration();
		myCorsConfiguration.setAllowedOrigins(List.of("http://localhost:8080"));
		myCorsConfiguration.setAllowedMethods(List.of("GET", "POST"));
		myCorsConfiguration.setAllowedHeaders(List.of("*"));
		myCorsConfiguration.setExposedHeaders(List.of("Content-Type"));
		myCorsConfiguration.setMaxAge(3000l);
		return new CorsConfigurationSource() {
			@Override
			public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
				return myCorsConfiguration;
			}
		};
	}*/

	//	https://youtu.be/HRwlT_etr60
	// This will shut the security by pass of use login provided by spring security
	// csrf() = Cross-Site Request Forgery (CSRF) attacks.
	// form-based authentication, you should enable CSRF protection
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		 http.cors().and().csrf().disable()
		 // httpSecurity.cors().configurationSource(corsConfigurationSource()).and().csrf().disable()
			.authorizeRequests()
				.requestMatchers(WHITE_LIST_URLs).permitAll()
				.requestMatchers("/authorized/**").authenticated()
			.and()
				.oauth2Login(oAuth2Login -> oAuth2Login.loginPage("/oauth2/authorization/api-client-oidc"))
				.oauth2Client(Customizer.withDefaults());
		return http.build();
	}
}
