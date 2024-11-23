package pandey.ujjwal.springsecurityOAuthauthorizationserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pandey.ujjwal.springsecurityOAuthauthorizationserver.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String username);

}
