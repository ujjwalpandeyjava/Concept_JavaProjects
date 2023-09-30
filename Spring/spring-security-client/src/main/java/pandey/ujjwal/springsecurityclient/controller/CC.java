package pandey.ujjwal.springsecurityclient.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CC {

	@GetMapping("/home")
	public String viewHomePage(Model model) {
//		model.addAttribute("allemplist", "att");
		return "index";
	}

}
