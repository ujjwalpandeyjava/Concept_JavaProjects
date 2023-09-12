package pandey.ujjwal.springsecurityclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
import pandey.ujjwal.springsecurityclient.entity.User;
import pandey.ujjwal.springsecurityclient.event.RegistrationCompleteEvent;
import pandey.ujjwal.springsecurityclient.model.UserModel;
import pandey.ujjwal.springsecurityclient.service.UserService;
import pandey.ujjwal.springsecurityclient.utlity.ReqResRelated;

/*
 * Contains (with token)
 * Registration: Register-Verify-ReVerify
 * Password: forget/change/
 * 
 */


@RestController
@RequestMapping("/appName")
public class RegistrationController {

	@Autowired
	private UserService userService;
	@Autowired
	private ApplicationEventPublisher appEvntPublisher;
	@Autowired
	private RegistrationCompleteEvent registrationCompleteEvent;

	@GetMapping(value = { "", "/" })
	public String getRgisterUser() {
		return "This is home page";
	}

	@PostMapping("/register")
	public ResponseEntity<String> registerUser(@RequestBody UserModel userModel, final HttpServletRequest req) {
		User newUser = userService.registerUser(userModel);
		if (newUser == null)
			return new ResponseEntity<String>("FAILED", HttpStatus.CREATED);
		registrationCompleteEvent.setUser(newUser);
		registrationCompleteEvent.setApplicationActivationUrl(ReqResRelated.applicationURl(req));
		appEvntPublisher.publishEvent(registrationCompleteEvent);
		return new ResponseEntity<String>("SUCCESS", HttpStatus.CREATED);
	}

	@PostMapping("/register/verifyRegistration")
	public String verifyUserRegistration(@RequestParam("token") String tokenToVerify) {
		String result = userService.validateVerificationToken(tokenToVerify);
		if (result.equalsIgnoreCase("VALID_TOKEN"))
			return "User verified";
		else if (result.equalsIgnoreCase("EXPIRED_TOKEN"))
			return "Time Expired, Register Again.";
		else // IN_VALID_TOKEN
			return "Bad User";
	}
}