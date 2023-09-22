package pandey.ujjwal.springsecurityclient.config;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import pandey.ujjwal.springsecurityclient.entity.User;
import pandey.ujjwal.springsecurityclient.event.RegistrationCompleteEvent;

@ComponentScan(basePackages = "pandey.ujjwal.springsecurityclient.config")
@Configuration
@EnableWebSecurity // For the application
//@EnableMethodSecurity(prePostEnabled = false, securedEnabled = true)	// Each method can have custom security access
public class WebSecurityConfig {

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

	// Configuring our authorization with autorization server
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		return http.cors(cors -> cors.disable()) // Cross-Origin Resource Sharing
				.csrf(csrf -> csrf.disable()) // Cross-Site Request Forgery
				.authorizeHttpRequests(authorize -> authorize
					// "/hello" // Testing the authorization here
					.requestMatchers("/freePermission/**", "", "/", "/register", "register/verifyRegistration").permitAll()
					.anyRequest().authenticated()
				)
//				.formLogin(Customizer.withDefaults())	// Own server based authontication - Working fine
//				Use OAuth2 based authontication
//				.oauth2Login(oAuth2Login -> oAuth2Login.loginPage("/login/oauth2/code/apiClientName"))
//				.oauth2Client(Customizer.withDefaults())
				.oauth2Login(oAuth2Login -> oAuth2Login.loginPage("/login/oauth2/code/apiClientName"))
		        .oauth2Client(Customizer.withDefaults())
				.build();
	}

	// Hard coded users working fine for formLogin
	@Bean
	public UserDetailsService hardCodedUsers() {
		UserDetails admin = org.springframework.security.core.userdetails.User.withUsername("AdminPandey").password(new BCryptPasswordEncoder(11).encode("123")).roles("ADMIN").build();
		UserDetails simple = org.springframework.security.core.userdetails.User.withUsername("SimplePandey").password(new BCryptPasswordEncoder(11).encode("123")).roles("SIMPLE").build();
		return new InMemoryUserDetailsManager(admin, simple);
	}
}