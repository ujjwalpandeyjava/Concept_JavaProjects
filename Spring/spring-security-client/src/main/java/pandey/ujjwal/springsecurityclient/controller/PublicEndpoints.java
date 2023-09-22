package pandey.ujjwal.springsecurityclient.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/freePermission")
public class PublicEndpoints {

	@GetMapping("/hello")
	public String getHello() {
		return "This path has authorization free access.";
	}

	@GetMapping("/hello2")
	public String getHello2() {
		return "This path is also has authorization free access.";
	}
	
}
