package pandey.ujjwal.Oauth2.CustomRegisterLogin.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pandey.ujjwal.Oauth2.CustomRegisterLogin.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	User findByEmail(String emailId);
}
