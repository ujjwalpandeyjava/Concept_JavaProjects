package pandey.ujjwal.Oauth2.CustomRegisterLogin.service;

import java.util.Map;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import pandey.ujjwal.Oauth2.CustomRegisterLogin.model.UserRegisteredDTO;

public interface DefaultUserService extends UserDetailsService {
	Map<String, Object> save(UserRegisteredDTO userRegisteredDTO);

	UserDetails loadUserByUsername(String username);

}
