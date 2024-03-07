package pandey.ujjwal.Oauth2.CustomRegisterLogin.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Transient;
import pandey.ujjwal.Oauth2.CustomRegisterLogin.enums.UserRole;

@Entity
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String email;
	private String password;
	private String privileges = "";
	@Transient
	private UserRole role;
	private String uRole;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPrivileges() {
		return this.privileges;
	}

	public void setPrivileges(String privileges) {
		this.privileges = privileges;
	}

	public String getuRole() {
		return this.uRole;
	}

	public void setuRole(String uRole) {
		this.uRole = uRole;
	}

	@PrePersist
	public void ifPrivilageIsEmpty() {
//		System.out.println("From prePersist: getPrivilege " + this.getPrivilege());
		if (privileges.isEmpty() || privileges.isBlank() || privileges == null) {
//			if (this.getRole().getValue().compareTo(String.USER.getValue()) == 0)
//			this.setPrivileges(UserPrivileges.READ.getValue());
			System.out.println(this.getRole());
			System.out.println(this.getRole().getPrivileges());
			this.setPrivileges(this.getRole().getPrivileges().toString());
		}
//		System.out.println("From prePersist: getPrivilege " + this.getPrivileges());
	}

	public UserRole getRole() {
		return this.role;
	}

	public void setRole(UserRole role) {
		this.role = role;
		this.uRole = this.role.getValue();
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", privileges="
				+ privileges + ", role=" + role + "]";
	}
}
