package pandey.ujjwal.concepts.spring;

import java.time.Duration;
import java.time.Instant;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import pandey.ujjwal.concepts.utility.constants.Const;

public class Valid_ann {
	
	@PostMapping("verifyNewUser")
	public ResponseEntity<String> verifyOTPForRegistration(@Valid @RequestBody UserRegistration userReg) {
		System.out.println(userReg);

		if (userReg.getId() == null)
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("ID missing!");
		if (userReg.getOtp() == null)
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("OTP to verify is missing!");

//		Optional<UserRegistration> byId = userRegistrationRepo.findById(userReg.getId());
//		if (byId.isPresent()) {
//			System.out.println(byId);
//			if (byId.get().getOtp().equals(userReg.getOtp()) == true) {
//				registeredUser.setEmailID(byId.get().getEmailID());
//				registeredUserRepo.save(registeredUser);
//				userRegistrationRepo.delete(byId.get());
//				return ResponseEntity.status(HttpStatus.CREATED).body(Const.SUCCESS);
//			} else
//				return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("OTP not matched");
//
//		} else {
//			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Const.Not_Found);
//		}
		return null;
	}
	
	

}

@Data
@Document
class UserRegistration {
	private String id;
	@NotBlank
	private String emailID;
	private String otp;
	private String registrationDateTime = Instant.now().toString();
	private String expireDateTime = Instant.now().plus(Duration.ofMinutes(Const.ONE_TWENTY)).toString();
}
