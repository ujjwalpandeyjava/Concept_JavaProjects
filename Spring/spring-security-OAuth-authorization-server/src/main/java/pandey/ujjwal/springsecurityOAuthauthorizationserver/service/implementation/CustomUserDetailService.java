package pandey.ujjwal.springsecurityOAuthauthorizationserver.service.implementation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import pandey.ujjwal.springsecurityOAuthauthorizationserver.entity.User;
import pandey.ujjwal.springsecurityOAuthauthorizationserver.repository.UserRepository;

/*
 Very important part of the spring security
 It loads the user from the DB
 */
@Service
@Transactional
public class CustomUserDetailService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(11);
	}

	@Override
	public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
		User userFound = userRepository.findByEmail(userEmail);
		if (userFound == null)
			throw new UsernameNotFoundException("User with email: '" + userEmail + "' not found");
		// we can add all the details from the parameter in the DB
		return new org.springframework.security.core.userdetails.User(
				userFound.getFirstName(), 
				userFound.getPassword(),
				userFound.isEnabled(), 
				true, 
				true, 
				true, 
				getAuthorities(List.of(userFound.getRole())));
	}

	private Collection<? extends GrantedAuthority> getAuthorities(List<String> role) {
		List<GrantedAuthority> authorities = new ArrayList<>();
		for (String roles : role)
			authorities.add(new SimpleGrantedAuthority(roles));
		return authorities;
	}
}
