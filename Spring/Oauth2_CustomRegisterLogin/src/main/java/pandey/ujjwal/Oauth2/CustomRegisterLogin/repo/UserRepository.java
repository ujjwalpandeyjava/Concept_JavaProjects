package pandey.ujjwal.Oauth2.CustomRegisterLogin.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pandey.ujjwal.Oauth2.CustomRegisterLogin.entity.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {
	Users findByEmail(String emailId);
}
