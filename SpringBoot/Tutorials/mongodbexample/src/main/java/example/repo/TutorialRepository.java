package example.repo;

import example.models.Tutorial;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TutorialRepository extends MongoRepository<Tutorial, Integer> {
    public Tutorial findById(int id);

    List<Tutorial> findByPublishedStatus(String publishedStatus);
    List<Tutorial> findByTitle(String title);




}
