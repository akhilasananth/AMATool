package app;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Created by jonathanscothorn on 3/18/2017.
 */
@RepositoryRestResource(collectionResourceRel="questions",path="questions")
public interface QuestionRepository extends CrudRepository<Question, Long> {

    List<Question> findAllByParent(@Param("parent") long parent);
}
