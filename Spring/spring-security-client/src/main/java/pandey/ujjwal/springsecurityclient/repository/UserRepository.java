package pandey.ujjwal.springsecurityclient.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pandey.ujjwal.springsecurityclient.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String email);

}
