package pandey.ujjwal.Oauth2.CustomRegisterLogin.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import pandey.ujjwal.Oauth2.CustomRegisterLogin.dto.UserRegisteredDTO;
import pandey.ujjwal.Oauth2.CustomRegisterLogin.model.User;

public interface DefaultUserService extends UserDetailsService {
	User save(UserRegisteredDTO userRegisteredDTO);

}
