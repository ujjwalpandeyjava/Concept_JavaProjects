package controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;
import pojo.UserD;

@Controller
@RequestMapping(path = "/formProcess")
public class FormHandlerController {
	
	// Form will have relative url ("XXX" not "/XXX")
	// Can use any Model or ModelAndView with them to send data to the
	// redirecting JSP page
	@RequestMapping(path = "/registerWay1", method = RequestMethod.POST)
	public String saveData1(HttpServletRequest request, Model m) {
		// Old way
		String email = request.getParameter("email");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String phone = request.getParameter("phone");
		int amount = Integer.parseInt(request.getParameter("amount"));
		
		// Use data received (process or do database work)
		m.addAttribute("email", email);	//Do one by one or use class
		m.addAttribute("name", name);
		m.addAttribute("password", password);
		m.addAttribute("phone", phone);
		m.addAttribute("amount", amount);
		System.out.println(
				"The email is: " +email
				+"\nThe name is: " +name
				+"\nThe password is: " +password
				+"\nThe phone is: " +phone
				+"\nThe amount is: " +amount
				);
		
		return "success";
	}

	
	//Using required give us ability to leave the form-filed empty 
	// While accepting from form it auto-typeCasting
	@RequestMapping(path = "/registerWay2", method = RequestMethod.POST)
//	Or I can use this line , it will have its own model class also.
//	public String saveData2(@ModelAttribute("assignToObj") POJO object){
	public String saveData2(
			@RequestParam("email") String e,
			@RequestParam(name = "name",  required = true) String n,
			@RequestParam("password") String p,
			@RequestParam("phone") String phn,
			@RequestParam("amount") int amount,
			Model m) {
			// Use the variables (usableVatiable, var2, var3)
		UserD u = new UserD();
		u.setEmail(e);
		u.setName(n);
		u.setPassword(p);
		u.setPhone(phn);
		u.setAmount(amount);
		
		List<String> lit = new ArrayList<String>();
		lit.add("One");
		lit.add("Two");
		lit.add("Three");
		lit.add("Four");
		lit.add("Five");
		
		System.out.println(
				"The email is: " +e
				+"\nThe name is: " +n
				+"\nThe password is: " +p
				+"\nThe phone is: " +phn
				+"\nThe amount is: " +amount
				+"\nThe list is: " +lit
				);
			//Sending data to the redirected page using model
		m.addAttribute("details", u);
		m.addAttribute("listIn", lit);
		return "success";
	}

	
	/*  To use Class to send data of form field name and class variables
		must be exact same in order and name	*/
	 
	//3 work 1 line (getting data, setting in object, setting attribute)
	//("user") is used when we have given handled a urls too
	@RequestMapping(path = "/registerWay3_1", method = RequestMethod.POST)
	public String saveData3_1(@ModelAttribute("user") UserD user, Model details) {
		System.out.println(user);
		details.addAttribute("details",user);	//Use it to add non-class data	
		return "success";
	}
	
	//On method level it adds an attribute(s) named "__" to all models defined in the controller class.
	@ModelAttribute
	public void addAttributes(Model model) {
	    model.addAttribute("msg", "Welcome to the Netherlands! this will be added to all controller URLs of this class");
	}
}


/*@RequestMapping(	path = "/registerWay3_1",
					method = RequestMethod.POST	)
Replace with
@PostMapping("registerWay3_1")*/