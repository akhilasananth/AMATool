package app;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by jonathanscothorn on 3/7/2017.
 */
@RepositoryRestResource(collectionResourceRel="users",path="users")
public interface UserRepository extends CrudRepository<User, Long>{
    User findById(@Param("id") Long id);
    User findByHandle(@Param("handle")String handle);
}
