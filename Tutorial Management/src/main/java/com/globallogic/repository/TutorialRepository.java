package com.globallogic.repository;

import com.globallogic.model.Tutorial;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TutorialRepository extends MongoRepository<Tutorial, Long> {
    List<Tutorial> findByPublishedStatus(String publishedStatus);
    List<Tutorial> findByTitle(String title);
}
