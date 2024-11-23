package pandey.ujjwal.javaConcepts.spring;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class Validated_Ann {

	public static void main(String[] args) {
	}

	public class UserAccount {
		public interface ValidationStepOne {
		}

		public interface ValidationStepTwo {
		}

		@NotBlank(groups = { ValidationStepOne.class })
		private String username;

		@Size(min = 8, max = 20, groups = { ValidationStepTwo.class })
		private String password;

		// standard constructors / setters / getters
	}

	@Controller
	public class UserController {
		@RequestMapping(value = "/stepOne", method = RequestMethod.POST)
		public String stepOne(@Validated(UserAccount.ValidationStepOne.class) @ModelAttribute("useraccount") UserAccount useraccount, BindingResult result) {
			if (result.hasErrors()) {
				return "error";
			}
			return "success";
		}

		@RequestMapping(value = "/stepTwo", method = RequestMethod.POST)
		public String stepTwo(
				@Validated(UserAccount.ValidationStepTwo.class) @ModelAttribute("useraccount") UserAccount useraccount,
				BindingResult result) {
			if (result.hasErrors()) {
				return "error";
			}
			return "success";
		}
	}

}
