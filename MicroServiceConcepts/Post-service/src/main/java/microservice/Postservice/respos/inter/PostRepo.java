package microservice.Postservice.respos.inter;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import microservice.Postservice.entities.Post;

@Repository
public interface PostRepo extends CrudRepository<Post, Long> {

//	@EntityGraph(value = "UserInfo.address", type = EntityGraph.EntityGraphType.LOAD)
	List<Post> findAll();
}
