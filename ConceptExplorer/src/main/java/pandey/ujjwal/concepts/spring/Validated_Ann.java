package pandey.ujjwal.concepts.spring;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

// Controller class to handle form submission with validation steps
@Controller
public class Validated_Ann {

	// Step one validation: validate fields annotated for ValidationStepOne
	@RequestMapping(value = "/stepOne", method = RequestMethod.POST)
	public String stepOne(
			@Validated(UserAccount.ValidationStepOne.class) @ModelAttribute("useraccount") UserAccount useraccount,
			BindingResult result) {

		// Check for validation errors
		if (result.hasErrors()) {
			return "error"; // Return error view if any validation fails
		}
		return "success"; // Proceed if validation passes
	}

	// Step two validation: validate fields annotated for ValidationStepTwo
	@RequestMapping(value = "/stepTwo", method = RequestMethod.POST)
	public String stepTwo(
			@Validated(UserAccount.ValidationStepTwo.class) @ModelAttribute("useraccount") UserAccount useraccount,
			BindingResult result) {

		// Check for validation errors
		if (result.hasErrors()) {
			return "error"; // Return error view if any validation fails
		}
		return "success"; // Proceed if validation passes
	}
}

// UserAccount model with group-based validation
class UserAccount {

	// Validation group for step one
	public interface ValidationStepOne {
	}

	// Validation group for step two
	public interface ValidationStepTwo {
	}

	// Field validated in step one: cannot be blank
	@NotBlank(groups = { ValidationStepOne.class })
	private String username;

	// Field validated in step two: size between 8 and 20
	@Size(min = 8, max = 20, groups = { ValidationStepTwo.class })
	private String password;

	// standard constructors / setters / getters (not shown here)
}
