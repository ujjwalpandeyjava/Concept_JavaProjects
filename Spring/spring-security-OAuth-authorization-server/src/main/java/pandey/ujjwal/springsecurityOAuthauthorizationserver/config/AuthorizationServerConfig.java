package pandey.ujjwal.springsecurityOAuthauthorizationserver.config;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.core.oidc.OidcScopes;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.server.authorization.client.InMemoryRegisteredClientRepository;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;
import org.springframework.security.oauth2.server.authorization.config.annotation.web.configuration.OAuth2AuthorizationServerConfiguration;
import org.springframework.security.oauth2.server.authorization.settings.AuthorizationServerSettings;
import org.springframework.security.oauth2.server.authorization.settings.ClientSettings;
import org.springframework.security.web.SecurityFilterChain;

import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.proc.SecurityContext;

/**
 * https://www.baeldung.com/spring-security-oauth-auth-server Client ID – Spring
 * will use it to identify which client is trying to access the resource Client
 * secret code – a secret known to the client and server that provides trust
 * between the two Authentication method – in our case, we’ll use basic
 * authentication, which is just a username and password Authorization grant
 * type – we want to allow the client to generate both an authorization code and
 * a refresh token Redirect URI – the client will use it in a redirect-based
 * flow Scope – this parameter defines authorizations that the client may have.
 * In our case, we’ll have the required OidcScopes.OPENID and our custom one,
 * articles. read
 */
@Configuration(proxyBeanMethods = false)
@Import(OAuth2AuthorizationServerConfiguration.class)
public class AuthorizationServerConfig {

	@Autowired
	private PasswordEncoder passwordEncoder;

	// Client get registers here with DB (In-build repo to all the)
	// (we can also go for custom implementation)
	@Bean
	public RegisteredClientRepository registeredClientRepository() {
		// My one static client (spring-security-client)
		// Have to make it dynamic by generating all details from DB server and all.
		RegisteredClient registeredClient = RegisteredClient.withId(UUID.randomUUID().toString()).clientId("api-client")
				.clientSecret(passwordEncoder.encode("secret"))
				.clientAuthenticationMethod(ClientAuthenticationMethod.CLIENT_SECRET_BASIC)
				.authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
				.authorizationGrantType(AuthorizationGrantType.REFRESH_TOKEN)
				.redirectUri("http://localhost:8085/login/oauth2/code/articles-client-oidc")
				.redirectUri("http://localhost:8085/authorized").scope(OidcScopes.OPENID).scope("articles.read") // Custom
//				.clientSettings(ClientSettings.builder().requireAuthorizationConsent(true).build())
				.build();
		return new InMemoryRegisteredClientRepository(registeredClient);
	}

	// Configuring our authorization
	// apply the default OAuth security and generate a default form login page
	@Bean
	@Order(Ordered.HIGHEST_PRECEDENCE)
	public SecurityFilterChain authServerSecurityFilterChain(HttpSecurity http) throws Exception {
		// This code line gives all the default line of APIs like:
		// /api, /token, JWT, etc. can add customs also
		OAuth2AuthorizationServerConfiguration.applyDefaultSecurity(http);
		return http.formLogin(Customizer.withDefaults()).build();
	}

	// Below 3 methods are standard in 90% case we don't need to change it.
	// Until need to change algorithm (RSA)
	// Each authorization server needs its signing key for tokens to keep a proper
	// boundary between security domains. Let’s generate a 2048-byte RSA key:
	@Bean
	public JWKSource<SecurityContext> jwkSource() throws NoSuchAlgorithmException {
		RSAKey rsaKey = generateRsa();
		JWKSet jwkSet = new JWKSet(rsaKey);
		return (jwkSelector, securityContext) -> jwkSelector.select(jwkSet);
	}

	private static RSAKey generateRsa() throws NoSuchAlgorithmException {
		KeyPair keyPair = generateRsaKey();
		RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
		RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
		return new RSAKey.Builder(publicKey).privateKey(privateKey).keyID(UUID.randomUUID().toString()).build();
	}

	private static KeyPair generateRsaKey() throws NoSuchAlgorithmException {
		KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
		keyPairGenerator.initialize(2048);
		return keyPairGenerator.generateKeyPair();
	}

	// Authorization server unique issuer URL
	// add an “127.0.0.1 auth-server” entry in our /etc/hosts file. This allows us to run the client and the auth server on our local machine, and avoids problems with session cookie overwrites between the two.
	@Bean
	public AuthorizationServerSettings authorizationServerSettings() {
		return AuthorizationServerSettings.builder()
				.issuer("http://auth-server:9000").build();
//	      		.issuer("http://localhost:9000").build();
	}

	@Bean
	public JwtDecoder jwtDecoder(JWKSource<SecurityContext> jwkSource) {
		return OAuth2AuthorizationServerConfiguration.jwtDecoder(jwkSource);
	}

//	@Bean
//	public AuthorizationServerSettings providerSettings() {
////		return AuthorizationServerSettings.builder().issuer("http://auth-server:9000").build();
//		return AuthorizationServerSettings.builder().issuer("http://localhost:9000").build();
//	}

	// Hard coded users
//	@Bean
//	public UserDetailsService hardCodedUsers() {
//		UserDetails admin = User.withUsername("AdminPandey").password(passwordEncoder.encode("123")).roles("ADMIN").build();
//		UserDetails simple = User.withUsername("SimplePandey").password(passwordEncoder.encode("123")).roles("SIMPLE").build();
//		return new InMemoryUserDetailsManager(admin, simple);
//	}
}
