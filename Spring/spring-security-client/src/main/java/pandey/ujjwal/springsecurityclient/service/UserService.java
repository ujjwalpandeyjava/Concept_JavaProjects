package pandey.ujjwal.springsecurityclient.service;

import java.util.Map;

import pandey.ujjwal.springsecurityclient.entity.User;
import pandey.ujjwal.springsecurityclient.entity.VerificationToken;
import pandey.ujjwal.springsecurityclient.model.UserModel;

public interface UserService {

	Map<String, Object> registerUser(UserModel userModel);

	VerificationToken saveVerificationTokenForUser(User user, String token);

	String validateVerificationToken(String tokenToVerify);

}
