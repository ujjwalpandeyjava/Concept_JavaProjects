package pandey.ujjwal.Oauth2.CustomRegisterLogin.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pandey.ujjwal.Oauth2.CustomRegisterLogin.enums.UserPrivileges;
import pandey.ujjwal.Oauth2.CustomRegisterLogin.model.UserRegisteredDTO;
import pandey.ujjwal.Oauth2.CustomRegisterLogin.service.DefaultUserService;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

	// Constructor injector
	private DefaultUserService userService;

	public RegistrationController(DefaultUserService userService) {
		super();
		this.userService = userService;
	}

	/*
	 * @RequestBody : application/json content
	 * 
	 * @ModelAttribute("modalName") : form data as in url parameters or we can
	 * pre-populate a model in the thymeleaf the th:object must mathch the
	 * 'modalName'
	 */
	@ModelAttribute("userReg")
	public UserRegisteredDTO userRegistrationDto() {
		return new UserRegisteredDTO();
	}

	@GetMapping
	public String showRegistrationForm(Model model) {
		System.out.println("/registration" + model);
		model.addAttribute("listOfPrivileges", UserPrivileges.getAllValues());
		return "register";
//		return "redirect:/register";
	}

	@PostMapping("/") // use @RequestBody when sending data in body
//	public Map<String, Object> registerUserAccount(@RequestBody UserRegisteredDTO registrationDto) {
	public String registerUserAccount(@ModelAttribute("userReg") UserRegisteredDTO registrationDto, Model model) {
//		System.out.println("/reg/" + registrationDto);
		Map<String, Object> savedResp = userService.save(registrationDto);
		System.out.println(savedResp);
		model.addAttribute("Resp", savedResp);
//		return savedResp; // json
		return "redirect:/login"; // view
	}
}