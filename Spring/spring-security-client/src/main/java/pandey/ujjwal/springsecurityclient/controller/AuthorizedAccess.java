package pandey.ujjwal.springsecurityclient.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/authorized")
public class AuthorizedAccess {

	@GetMapping("/hasAccess")
	public String getHello() {
		return "Yes you have access.";
	}
}
