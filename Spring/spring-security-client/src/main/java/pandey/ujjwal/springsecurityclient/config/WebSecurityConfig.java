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
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientProvider;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientProviderBuilder;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.web.DefaultOAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.web.OAuth2AuthorizedClientRepository;
import org.springframework.security.oauth2.client.web.reactive.function.client.ServletOAuth2AuthorizedClientExchangeFilterFunction;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.reactive.function.client.WebClient;

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
						.requestMatchers("/freePermission/**", "", "/", "/register", "register/verifyRegistration")
						.permitAll().anyRequest().authenticated())
				.oauth2Login(Customizer.withDefaults())
				.formLogin(Customizer.withDefaults())
				.build();
	}

	// Hard coded users working fine for formLogin
	@Bean
	public UserDetailsService hardCodedUsers() {
		UserDetails admin = org.springframework.security.core.userdetails.User.withUsername("AdminPandey")
				.password(new BCryptPasswordEncoder(11).encode("123")).roles("ADMIN").build();
		UserDetails simple = org.springframework.security.core.userdetails.User.withUsername("SimplePandey")
				.password(new BCryptPasswordEncoder(11).encode("123")).roles("SIMPLE").build();
		return new InMemoryUserDetailsManager(admin, simple);
	}

	// WebClient instance to perform HTTP requests to our resource server
	@Bean
	WebClient webClient(OAuth2AuthorizedClientManager authorizedClientManager) {
		ServletOAuth2AuthorizedClientExchangeFilterFunction oauth2Client = new ServletOAuth2AuthorizedClientExchangeFilterFunction(
				authorizedClientManager);
		return WebClient.builder().apply(oauth2Client.oauth2Configuration()).build();
	}

	// WebClient requires an OAuth2AuthorizedClientManager as a dependency
	@Bean
	OAuth2AuthorizedClientManager authorizedClientManager(ClientRegistrationRepository clientRegistrationRepository,
			OAuth2AuthorizedClientRepository authorizedClientRepository) {

		OAuth2AuthorizedClientProvider authorizedClientProvider = OAuth2AuthorizedClientProviderBuilder.builder()
				.authorizationCode().refreshToken().build();
		DefaultOAuth2AuthorizedClientManager authorizedClientManager = new DefaultOAuth2AuthorizedClientManager(
				clientRegistrationRepository, authorizedClientRepository);
		authorizedClientManager.setAuthorizedClientProvider(authorizedClientProvider);
		return authorizedClientManager;
	}
}