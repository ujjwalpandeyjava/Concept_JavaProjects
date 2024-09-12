package microservice.Userservice.respos.inter;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import microservice.Userservice.entities.UserInfo;

@Repository
public interface UserInfoRepo extends CrudRepository<UserInfo, Long> {

    @EntityGraph(value = "UserInfo.address", type = EntityGraph.EntityGraphType.LOAD)
    List<UserInfo> findAll();
}
