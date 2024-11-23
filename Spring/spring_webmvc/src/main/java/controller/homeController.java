package controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pojo.Study;

/* 
 * 	Step 0: Create project and Add Dependencies to pom.xml -->
 *	Step 1: DispatcherServlet configuration -->
 *	Step 2: in "springmvc-servlet.xml" -->Step 4 & 5 runs together.
 *  Step 4 - Setup all the Spring controllers with the URLs along with functionality related to JSP.
 *  Step 5 - Work with normal JSPs
 */

@Controller
public class homeController {
	AnnotationConfigApplicationContext context2 = new AnnotationConfigApplicationContext(JavaConfig2.class);

	// Methods to handle URLs middle part view-resolver will add prefix and suffix.
	@RequestMapping("/home")
	public String home(Model m) {// Using model is simple
		m.addAttribute("ae", "something");
		Study bean = (Study) context2.getBean("getStudy");
		System.out.println(bean.toString());
		return "index";
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	protected ModelAndView contact(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("This is '/' url");
		ModelAndView model = new ModelAndView("index");
		model.addObject("msg", "Welcome<br>if you see this page, it means I'm working");
		return model;
	}

	@RequestMapping(value = "/myPage", method = RequestMethod.GET)
	protected ModelAndView myPage() {
		System.out.println("This is myPage url.");
		ModelAndView model = new ModelAndView("index");
		model.addObject("ae", "Welcome myPage<br>if you see this page, it means I'm working");
		return model;
	}

	// Must return ModelAndView Type
	@RequestMapping("/about")
	public ModelAndView about() {// Using modelAndView is weird
		System.out.println("about");
		ModelAndView mav = new ModelAndView(); // ModelAndView is like an map data structure.
		mav.addObject("mav", "This can be any object");
		mav.addObject("integ", 7878);
		LocalDateTime lc = LocalDateTime.now();
		mav.addObject("dateTime", lc);
		List<String> lit = new ArrayList<String>();
		lit.add("one");
		lit.add("Two");
		lit.add("Three");
		lit.add("Four");

		mav.addObject("lit", lit);
		// This line set the page name of referred page
		mav.setViewName("about");
		return mav;
	}

	@RequestMapping("/success")
	public String success(Model m) { // Using model is simple
		m.addAttribute("message", "This is contact data with model");
		System.out.println("This is success of form url.");
		return "success";
	}
}
