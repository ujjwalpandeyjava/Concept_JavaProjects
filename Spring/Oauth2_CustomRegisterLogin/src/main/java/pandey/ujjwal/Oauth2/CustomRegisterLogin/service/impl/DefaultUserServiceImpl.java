package pandey.ujjwal.Oauth2.CustomRegisterLogin.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import pandey.ujjwal.Oauth2.CustomRegisterLogin.entity.Users;
import pandey.ujjwal.Oauth2.CustomRegisterLogin.enums.ResponseMessages;
import pandey.ujjwal.Oauth2.CustomRegisterLogin.enums.UserRole;
import pandey.ujjwal.Oauth2.CustomRegisterLogin.model.UserRegisteredDTO;
import pandey.ujjwal.Oauth2.CustomRegisterLogin.repo.UserRepository;
import pandey.ujjwal.Oauth2.CustomRegisterLogin.service.DefaultUserService;

@Service
public class DefaultUserServiceImpl implements DefaultUserService {
	@Autowired
	private UserRepository userRepo;

	@Autowired
	@Qualifier("BCryptPasswordEncoder_Strength_11")
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	// Gets called when the user login via any mean, we override to check user exist
	// in DB with active details.
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Users user = userRepo.findByEmail(email);
		System.out.println("user: " + user);
		if (user == null)
			throw new UsernameNotFoundException("Invalid username.");
		return new User(user.getEmail(), user.getPassword(),
				mapRolesToAuthorities(UserRole.getRoleByValue(user.getuRole())));
	}

	@SuppressWarnings("unused")
	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Set<UserRole> roles) {
		return roles.stream().map(eachRole -> new SimpleGrantedAuthority(eachRole.getValue()))
				.collect(Collectors.toList());
	}

	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(UserRole roles) {
		ArrayList<UserRole> arrayList = new ArrayList<UserRole>(Arrays.asList(roles));
		return arrayList.stream().map(eachRole -> new SimpleGrantedAuthority(eachRole.getValue()))
				.collect(Collectors.toList());
	}

//	@Override
	public Map<String, Object> save(UserRegisteredDTO userRegisteredDTO) {
		System.out.println("Before saving " + userRegisteredDTO);
		HashMap<String, Object> returnJSON = new HashMap<>();
		returnJSON.put(ResponseMessages.MESSAGE.getValue(), ResponseMessages.DEFAULT);
		if (userRegisteredDTO.getUserRole() == null)
			returnJSON.replace(ResponseMessages.MESSAGE.getValue(), "userRole cannot be empty!");
		else {
			Users user = new Users();
			user.setEmail(userRegisteredDTO.getEmail_id());
			user.setName(userRegisteredDTO.getName());
			user.setPassword(userRegisteredDTO.getEncodedPassword());
			user.setRole(userRegisteredDTO.getUserRole());
			user.setPrivileges(userRegisteredDTO.getPrivileges());
			Users savedUser = userRepo.save(user);
			returnJSON.put("savedDetail", savedUser);
			returnJSON.put(ResponseMessages.MESSAGE.getValue(), ResponseMessages.SAVED.getValue());
		}
		return returnJSON;
	}
}
