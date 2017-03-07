package app;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by jonathanscothorn on 3/7/2017.
 */
public interface UserRepository extends CrudRepository<User, Long>{
}
