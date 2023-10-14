package pandey.ujjwal.Oauth2.CustomRegisterLogin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pandey.ujjwal.Oauth2.CustomRegisterLogin.model.UserRegisteredDTO;
import pandey.ujjwal.Oauth2.CustomRegisterLogin.service.DefaultUserService;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

	private DefaultUserService userService;

	public RegistrationController(DefaultUserService userService) {
		super();
		this.userService = userService;
	}

	// Used to pre-populate a model
	@ModelAttribute("user")
	public UserRegisteredDTO userRegistrationDto() {
		return new UserRegisteredDTO();
	}

	@GetMapping
	public String showRegistrationForm() {
//		return "redirect:/register";
		return "register";
	}

	@PostMapping
	public String registerUserAccount(@ModelAttribute("user") UserRegisteredDTO registrationDto) {
		userService.save(registrationDto);
		return "redirect:/login";
	}
}