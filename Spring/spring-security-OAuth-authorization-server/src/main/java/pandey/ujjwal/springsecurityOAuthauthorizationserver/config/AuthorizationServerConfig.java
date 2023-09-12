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
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.core.oidc.OidcScopes;
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

@Configuration(proxyBeanMethods = false)
public class AuthorizationServerConfig {

	@Autowired
	private PasswordEncoder passwordEncoder;

	// Security-Filter-Chain
	@Bean
	@Order(Ordered.HIGHEST_PRECEDENCE)
	public SecurityFilterChain authServerSecurityFilterChain(HttpSecurity httpSecurity) throws Exception {
		// This code line gives all the default line of APIs like: /api, /token, JWT,
		// etc.
		OAuth2AuthorizationServerConfiguration.applyDefaultSecurity(httpSecurity);

		return httpSecurity.formLogin(Customizer.withDefaults()).build();
	}

	// In-build repo to all the client get registered (we can also go for custom
	// implementation)
	@Bean
	public RegisteredClientRepository registeredClientRepository() {

		// My one client (spring-security-client)
		// Have to make it dynamic by generating all details from DB server and all.
		RegisteredClient registeredClient = RegisteredClient.withId(UUID.randomUUID().toString()).clientId("api-client")
				.clientSecret(passwordEncoder.encode("SecereteKey"))
				.clientAuthenticationMethod(ClientAuthenticationMethod.CLIENT_SECRET_BASIC)
				.authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
				.authorizationGrantType(AuthorizationGrantType.REFRESH_TOKEN)
				.authorizationGrantType(AuthorizationGrantType.PASSWORD)
				.redirectUri("http://127.0.0.1:8080/login/oauth2/code/api-client-oidc")
				.redirectUri("http://127.0.0.1:8080/authorized").scope(OidcScopes.OPENID).scope("api.read")
				.clientSettings(ClientSettings.builder().requireAuthorizationConsent(true).build()).build();
		return new InMemoryRegisteredClientRepository(registeredClient);
	}
	
	//Below 3 methods are standard in 90% case we don't need to change it.
	// Until need to change algorithm (RSA)
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

	
	// About OAuth server provider
	@Bean
	public AuthorizationServerSettings providerSettings() {
	    return AuthorizationServerSettings.builder()
	      .issuer("http://localhost:9000")
	      .build();
	}
}
