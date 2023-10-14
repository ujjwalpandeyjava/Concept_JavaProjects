package pandey.ujjwal.Oauth2.CustomRegisterLogin.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import pandey.ujjwal.Oauth2.CustomRegisterLogin.entity.User;
import pandey.ujjwal.Oauth2.CustomRegisterLogin.model.UserRegisteredDTO;

public interface DefaultUserService extends UserDetailsService {
	User save(UserRegisteredDTO userRegisteredDTO);

}
