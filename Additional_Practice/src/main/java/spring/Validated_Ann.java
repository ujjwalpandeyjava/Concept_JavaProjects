package spring;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

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
