package pandey.ujjwal.Oauth2.CustomRegisterLogin.config;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pandey.ujjwal.Oauth2.CustomRegisterLogin.enums.UserRole;
import pandey.ujjwal.Oauth2.CustomRegisterLogin.model.UserRegisteredDTO;
import pandey.ujjwal.Oauth2.CustomRegisterLogin.repo.UserRepository;
import pandey.ujjwal.Oauth2.CustomRegisterLogin.service.DefaultUserService;

@Component
public class CustomSuccessHandler implements AuthenticationSuccessHandler {

	@Autowired
	UserRepository userRepo;

	@Autowired
	DefaultUserService userService;

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		System.out.println("Inside onAuthenticationSuccess...");
		// two kind of use - local(springsecurity.core.user) &
		// oAuth(springsecurity.oauth2.core.user.DefaultOAuth2User)
		if (authentication.getPrincipal() instanceof DefaultOAuth2User) {
			DefaultOAuth2User userResourceDetails = (DefaultOAuth2User) authentication.getPrincipal();
			System.out.println(userResourceDetails);
			// Why?
			String userName = userResourceDetails.getAttribute("email") != null
					? userResourceDetails.getAttribute("email")
					: userResourceDetails.getAttribute("login");
			String userEamil = userName + "@gmail.com";
			if (userRepo.findByEmail(userEamil) == null) {
				UserRegisteredDTO user = new UserRegisteredDTO();
				user.setEmail_id(userEamil);
				user.setName(userName);
				user.setEncodedPassword("");
				user.setUserRole(UserRole.USER);
//				user.setUserRole(UserRole.getRoleByValue("USER"));
				Map<String, Object> saved = userService.save(user);
				System.out.println("From CustomSuccessHandler: " + saved);
			}
		}
		new DefaultRedirectStrategy().sendRedirect(request, response, "/dashboard");
	}
}
