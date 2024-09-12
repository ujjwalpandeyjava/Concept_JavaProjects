package microservice.Userservice.controller;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import microservice.Userservice.entities.Address;
import microservice.Userservice.entities.UserInfo;
import microservice.Userservice.respos.inter.AddressRepo;
import microservice.Userservice.respos.inter.UserInfoRepo;

@RestController
@RequestMapping("/userService")
public class UserController {

	@Autowired
	private AddressRepo addressRepo;
	@Autowired
	private UserInfoRepo userInfoRepo;

	@PostMapping("/newUserWithAddress")
	public ResponseEntity<Object> saveNewUser(@RequestBody @Valid UserInfo newUser) {
		System.err.println(newUser);
		return ResponseEntity.status(HttpStatus.OK).body(userInfoRepo.save(newUser));
	}

	@GetMapping({ "", "/" })
	public ResponseEntity<Object> home() {
		return ResponseEntity.status(HttpStatus.OK).body("Home");
	}

	@GetMapping("/getAll")
	public ResponseEntity<Object> getUser() {
		return ResponseEntity.status(HttpStatus.OK).body(userInfoRepo.findAll());
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<Object> get1User(@PathVariable(name = "id") String id) {
		try {
			Optional<UserInfo> byId = userInfoRepo.findById(Long.parseLong(id));
			if (byId.isEmpty()) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
			} else {
//				WebClie
				return ResponseEntity.status(HttpStatus.OK).body(byId);
			}
		} catch (NumberFormatException e) {
			System.out.println("Invalid number format: " + e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Not found");
		}
	}

	@PostMapping("/newAddress")
	public ResponseEntity<Object> saveAddress(@RequestBody @Valid Address address) {
		Address save = addressRepo.save(address);
		return ResponseEntity.status(HttpStatus.CREATED).body(Map.of("data", save));
	}

	@PostMapping("/newUser")
	public ResponseEntity<Object> saveUser(@RequestBody @Valid UserInfo userInfo) {
		UserInfo save = userInfoRepo.save(userInfo);
		return ResponseEntity.status(HttpStatus.CREATED).body(Map.of("data", save));
	}
}
