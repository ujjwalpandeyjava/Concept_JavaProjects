package pandey.ujjwal.Oauth2.CustomRegisterLogin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/")
@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:8080" })
public class ViewController {
	@GetMapping
	public String getDefault() {
		return "index";
	}
}
