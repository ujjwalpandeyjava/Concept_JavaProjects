package microservice.Userservice.respos.inter;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import microservice.Userservice.entities.Address;

@Repository
public interface AddressRepo extends CrudRepository<Address, Long> {

}
