package pandey.ujjwal.Oauth2.CustomRegisterLogin.model;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Transient;
import pandey.ujjwal.Oauth2.CustomRegisterLogin.config.BeanInit;
import pandey.ujjwal.Oauth2.CustomRegisterLogin.enums.UserPrivileges;
import pandey.ujjwal.Oauth2.CustomRegisterLogin.enums.UserRole;

public class UserRegisteredDTO {

	@Autowired
	@Qualifier("BCryptPasswordEncoder_Strength_11")
	@Transient
	@JsonIgnore // no seialization, deserialization
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	private String name;
	private String email_id;
	private String encodedPassword;
	private UserRole userRole;
	private String privileges = "";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	public String getEncodedPassword() {
		return encodedPassword;
	}

	public void setEncodedPassword(String encodedPassword) {
		this.encodedPassword = BeanInit.passwordEncoder11().encode(encodedPassword);
	}

	public UserRole getUserRole() {
		return this.userRole;
	}

	public void setUserRole(UserRole userRole) {
//		System.out.println("got role as UserRole enum");
		this.userRole = userRole;
	}

	public void setUserRole(String userRoleValue) {
//		System.out.println("got role as string");
		this.userRole = UserRole.getRoleByValue(userRoleValue);
	}

	public String getPrivileges() {
		return this.privileges;
	}

	public void setPrivileges(String privileges) {
		// This login is better in pre persist.
//		if (privileges.isEmpty() || privileges.isBlank() || privileges == null)
//			privileges = UserPrivileges.READ.getValue();
		String[] splitPrivilages = privileges.split(",");
		System.out.println("splitPrivilages:" + Arrays.toString(splitPrivilages));
		privileges = "";
		for (String eachPrivilage : splitPrivilages) {
			if (UserPrivileges.getPrivilageByValue(eachPrivilage) != null)
				privileges += privileges.isBlank() ? eachPrivilage : "," + eachPrivilage;
		}
		this.privileges = privileges;
	}

	@Override
	public String toString() {
		return "UserRegisteredDTO [bCryptPasswordEncoder=" + bCryptPasswordEncoder + ", name=" + name + ", email_id="
				+ email_id + ", encodedPassword=" + encodedPassword + ", userRole=" + userRole + ", privileges="
				+ privileges + "]";
	}

}
