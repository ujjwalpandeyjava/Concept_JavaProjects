package pandey.ujjwal.Oauth2.CustomRegisterLogin.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pandey.ujjwal.Oauth2.CustomRegisterLogin.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

	Role findByRole(String name);
}
