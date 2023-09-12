package pandey.ujjwal.springsecurityclient.service.implementations;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import pandey.ujjwal.springsecurityclient.entity.User;
import pandey.ujjwal.springsecurityclient.entity.VerificationToken;
import pandey.ujjwal.springsecurityclient.model.UserModel;
import pandey.ujjwal.springsecurityclient.repository.UserRepository;
import pandey.ujjwal.springsecurityclient.repository.VerificationTokenRepository;
import pandey.ujjwal.springsecurityclient.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private VerificationTokenRepository verificationTokenRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;

	private final static String VALID_TOKEN = "VALID_TOKEN";
	private final static String INVALID_TOKEN = "IN_VALID_TOKEN";
	private final static String EXPIRED_TOKEN = "EXPIRED_TOKEN";

	@Override
	public User registerUser(UserModel userModel) {
		User newUser = new User();
		if (!userModel.getPassword().equals(userModel.getMatchingPassword()))
			return null;
		newUser.setFirstName(userModel.getFirstName());
		newUser.setLastName(userModel.getLastName());
		newUser.setEmail(userModel.getEmail());
		newUser.setPassword(passwordEncoder.encode(userModel.getPassword()));
		System.out.println(newUser);
		return userRepository.save(newUser);
	}

	@Override
	public VerificationToken saveVerificationTokenForUser(User user, String token) {
		// Connect Token and User, then save in DB with expiration time
		VerificationToken userConnectedVerificationToken = new VerificationToken(user, token); // Connecting
		return verificationTokenRepository.save(userConnectedVerificationToken);
	}

	@Override
	public String validateVerificationToken(String tokenToVerify) {
		VerificationToken tokenRow = verificationTokenRepository.findByToken(tokenToVerify);
		if (tokenRow == null) {
			return INVALID_TOKEN;
		} else {
			User user = tokenRow.getUser();
			if (tokenRow.getExpirationTime().after(new Date())) {
				user.setEnabled(true);
				userRepository.save(user);
				verificationTokenRepository.delete(tokenRow);
				return VALID_TOKEN;
			} else {
				userRepository.delete(user);
				verificationTokenRepository.delete(tokenRow);
				return EXPIRED_TOKEN;
			}
		}
	}
}