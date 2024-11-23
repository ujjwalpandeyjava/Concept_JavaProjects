package pandey.ujjwal.Oauth2.CustomRegisterLogin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pandey.ujjwal.Oauth2.CustomRegisterLogin.enums.ResponseMessages;
import pandey.ujjwal.Oauth2.CustomRegisterLogin.model.UserLoginDTO;
import pandey.ujjwal.Oauth2.CustomRegisterLogin.service.DefaultUserService;

@Controller
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private DefaultUserService userService;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
//	@Autowired

	// It will create a new UserLoginDTO object and add it to the model before each
	// request, a convenient way to add a common attribute to the model.
	@ModelAttribute("user")
	public UserLoginDTO userLoginDTO() {
		return new UserLoginDTO();
	}

	/*
	 * @ModelAttribute and @RequestBody is that @ModelAttribute binds the request
	 * parameters to a Java object, while @RequestBody binds the request body to a
	 * Java object.
	 */
	@GetMapping
//	public String login(@ModelAttribute("user") UserLoginDTO userLoginDTO) {
	public String login() {
//		System.out.println("UserDTO login get:" + userLoginDTO);
		System.out.println("/login");
		return "login";
	}

	@ModelAttribute("user")
	public UserLoginDTO userRegistrationDto() {
		return new UserLoginDTO();
	}

	// Data received in parameters
	@PostMapping("/")
	public String loginUser(@ModelAttribute("user") UserLoginDTO userLoginDTO, Model model) {
		System.out.println("loginUser");
//		System.out.println("/login/" + userLoginDTO + "::");
		try {
			UserDetails foundUser = userService.loadUserByUsername(userLoginDTO.getUsername());
//			System.out.println("foundUser" + foundUser);
			if (bCryptPasswordEncoder.matches(userLoginDTO.getPassword(), foundUser.getPassword())) {
				model.addAttribute(ResponseMessages.MESSAGE.getValue(), ResponseMessages.SUCCESS.getValue());
				model.addAttribute("userDetails", foundUser);
				return "dashboard";
			} else {
				model.addAttribute(ResponseMessages.MESSAGE.getValue(), ResponseMessages.INCORRECT_PASSWORD.toString());
				return "login";
			}
		} catch (UsernameNotFoundException e) {
			model.addAttribute(ResponseMessages.MESSAGE.getValue(), ResponseMessages.USER_NOT_FOUND.toString());
		} catch (Exception e) {
			model.addAttribute(ResponseMessages.MESSAGE.getValue(), ResponseMessages.SERVER_ERROR.toString());
			e.printStackTrace();
		}
		return "login";
	}

	/*
	 * @ResponseBody
	 * 
	 * @PostMapping("/") public Map<String, Object> loginUser2(@RequestBody
	 * UserLoginDTO userLoginDTO) { System.out.println("loginUser2"); var
	 * returnObject = new HashMap<String, Object>();
	 * returnObject.put(ResponseMessages.MESSAGE.getValue(),
	 * ResponseMessages.DEFAULT.toString()); try { UserDetails foundUser =
	 * userService.loadUserByUsername(userLoginDTO.getUsername()); if
	 * (bCryptPasswordEncoder.matches(userLoginDTO.getPassword(),
	 * foundUser.getPassword()))
	 * returnObject.replace(ResponseMessages.MESSAGE.getValue(),
	 * ResponseMessages.SUCCESS.toString()); else
	 * returnObject.replace(ResponseMessages.MESSAGE.getValue(),
	 * ResponseMessages.INCORRECT_PASSWORD.toString()); } catch
	 * (UsernameNotFoundException e) {
	 * returnObject.replace(ResponseMessages.MESSAGE.getValue(),
	 * ResponseMessages.USER_NOT_FOUND.toString()); } catch (Exception e) {
	 * returnObject.replace(ResponseMessages.MESSAGE.getValue(),
	 * ResponseMessages.USER_NOT_FOUND.toString()); e.printStackTrace(); }
	 * System.out.println(returnObject); return returnObject; }
	 */

	@ResponseBody
	@GetMapping("/superAdmin")
	public String loginPageSuperAdmin() {
		return "I am 'Super Admin', I can access /superadmin";
	}

	@ResponseBody
	@GetMapping("/admin")
	public String loginPageAdmin() {
		return "I am 'Admin', I can access /admin";
	}

	@ResponseBody
	@GetMapping("/user")
	public String loginPageUser() {
		return "I am 'User', I can access /user";
	}

	@ResponseBody
	@GetMapping("/guest")
	public String loginPageGuest() {
		return "I am 'Guest', I can access /guest";
	}
}
