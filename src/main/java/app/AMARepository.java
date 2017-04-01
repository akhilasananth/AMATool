package app;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;


/**
 * Created by jonathanscothorn on 3/7/2017.
 */
@RepositoryRestResource(collectionResourceRel="amas",path="amas")
public interface AMARepository extends CrudRepository<AMA, Long> {
AMA findById(@Param("id") Long id);
AMA findByDescription(@Param("description")String description);
List<AMA> findAllByCreatorID(@Param("creatorID")Long creatorID);
}
